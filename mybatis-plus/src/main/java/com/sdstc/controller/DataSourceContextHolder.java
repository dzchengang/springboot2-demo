package com.sdstc.controller;

import com.baomidou.mybatisplus.core.toolkit.TableNameParser;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;

public class DataSourceContextHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDbType() {
		DynamicTableNameInnerInterceptor
		//DynamicTableNameInnerInterceptor
		//TableNameHandler
		TableNameParser
		return ((String) contextHolder.get());
	}
}
