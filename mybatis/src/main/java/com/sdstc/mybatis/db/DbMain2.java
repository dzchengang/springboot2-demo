package com.sdstc.mybatis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbMain2 {

	public static void main(String[] args) {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://172.16.10.21:3306/coopyzz?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true",
					"root", "qwe123-=");

			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			StringBuffer sb = new StringBuffer("insert into testest (name) values ('cheng0')");
			for (int i = 0; i < 5; i++) {
				sb.append(",('lisi" + i + "')");
			}
			
			int a=1/0;
			statement.execute(sb.toString());
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
