package com.kanlon.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import com.mysql.jdbc.Statement;

/**
 * jdbc的链接的工具类
 *
 * @author zhangcanlong
 * @date 2018年11月13日
 */
public class JDBCUtil {

	private static final String url = PropUtil.getValueByKey("url");
	private static final String username = PropUtil.getValueByKey("username");
	private static final String password = PropUtil.getValueByKey("password");

	/**
	 * 得到来数据库链接
	 *
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnect() throws Exception {
		// 通过得到字节码对象的方式加载静态代码块，从而注册驱动程序
		Class.forName(PropUtil.getValueByKey("driverClassName"));
		// 2.连接到具体的数据库
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	/**
	 * 关闭资源
	 *
	 * @param conn
	 * @param stmt
	 */
	public static void close(Connection conn, Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
				throw new RuntimeException(e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
				throw new RuntimeException(e.getMessage());
			}
		}

	}

	/**
	 * 关闭资源
	 *
	 * @param conn
	 * @param stmt
	 */
	public static void close(Connection conn, PreparedStatement stmt, ResultSet result) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
				throw new RuntimeException(e.getMessage());
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
				throw new RuntimeException(e.getMessage());
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	/**
	 * 开始事务
	 *
	 * @param cnn
	 */
	public static void beginTransaction(Connection conn) {
		if (conn != null) {
			try {
				if (conn.getAutoCommit()) {
					conn.setAutoCommit(false);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 提交事务
	 *
	 * @param cnn
	 */
	public static void commitTransaction(Connection conn) {
		if (conn != null) {
			try {
				if (!conn.getAutoCommit()) {
					conn.commit();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 回滚事务
	 *
	 * @param cnn
	 */
	public static void rollBackTransaction(Connection conn) {
		if (conn != null) {
			try {
				if (!conn.getAutoCommit()) {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
