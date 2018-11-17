package com.kanlon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {
	@Test
	public void testSelect() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 1.创建自定义连接池对象
		// 此种方法加载的配置文件中默认配置default-config
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// 加载有名称的配置named-config
		// ComboPooledDataSource dataSource = new
		// ComboPooledDataSource("mysql");
		try {
			// 2.从池中获取对象（改造过后）
			conn = dataSource.getConnection();
			// 3.编写SQL语句
			String sql = "select * from joblabx_data where id=?";
			// 4.获取执行sql语句的对象
			pstmt = conn.prepareStatement(sql);
			// 5.设置参数
			pstmt.setInt(1, 1);
			// 6.执行
			rs = pstmt.executeQuery();
			// 7.处理结果集
			while (rs.next()) {
				System.out.println(rs.getString("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
