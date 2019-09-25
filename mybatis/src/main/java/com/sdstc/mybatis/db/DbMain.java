package com.sdstc.mybatis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbMain {

	public static void main(String[] args) throws Exception {
		// 加载驱动程序
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 1.getConnection()方法，连接MySQL数据库！！
		Connection con = DriverManager.getConnection("jdbc:mysql://172.16.10.21:3306/coopyzz?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true", "root", "qwe123-=");
		// 2.创建statement类对象，用来执行SQL语句！！
		Statement statement = con.createStatement();
		// 要执行的SQL语句
		String sql = "select * from project_task";
		// 3.ResultSet类，用来存放获取的结果集！！
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String id=rs.getString("id");
			String taskName=rs.getString("task_name");
			System.out.println(id+":"+taskName);
		}
		rs.close();
		con.close();

	}
}
