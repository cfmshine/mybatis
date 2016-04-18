package com.company.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	public static void main(String[] args) {

		// 数据库连接
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 获取数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 连接数据库
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "123456");
			// 需要执行的sql
			String sql = "select * from user where username = ?";
			// 预编译sql,提高效率
			preparedStatement = connection.prepareStatement(sql);
			// 为占位符? 设置参数值
			preparedStatement.setString(1, "王五");
			// 查询结果集
			resultSet = preparedStatement.executeQuery();
			// 遍历结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
