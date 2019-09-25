package com.sdstc.mybatis.example.plugin;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * 配置需要拦截的数据 
 * 
 * type:拦截的接口 method：拦截的方法 args：方法参数（方法+参数才能确定具体是哪个方法）
 *
 */
@Intercepts(
		@Signature(type = Executor.class, method = "query", args = { 
				MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
		)
public class FirstPlugin implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		// invocation 对应拦截的  type  method  args
		Executor executor=(Executor) invocation.getTarget();
		MappedStatement  mappedStatement=(MappedStatement) invocation.getArgs()[0];
		Object parameter=invocation.getArgs()[1];
		ResultHandler<?> resultHandler=(ResultHandler<?>) invocation.getArgs()[3];
		BoundSql  boundSql=mappedStatement.getBoundSql(parameter);
		
		String newSql=boundSql.getSql()+" limit 0,10";
		
		BoundSql  boundSql2=new BoundSql(mappedStatement.getConfiguration(),newSql,boundSql.getParameterMappings(), parameter);
		return executor.query(mappedStatement, parameter,RowBounds.DEFAULT, resultHandler,null,boundSql2);
        		
	/*	System.out.println("first---------begin------------");
		Object obj=invocation.proceed();
		System.out.println("first---------end------------");
		return obj;*/
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {

	}

}
