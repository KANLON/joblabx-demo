package com.kanlon.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import com.mysql.jdbc.Statement;

/**
 * jdbc�����ӵĹ�����
 *
 * @author zhangcanlong
 * @date 2018��11��13��
 */
public class JDBCUtil {

	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "root";

	/**
	 * �õ������ݿ�����
	 *
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnect() throws Exception {
		// ͨ���õ��ֽ������ķ�ʽ���ؾ�̬����飬�Ӷ�ע����������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.���ӵ���������ݿ�
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	/**
	 * �ر���Դ
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
	 * �ر���Դ
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
	 * ��ʼ����
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
	 * �ύ����
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
	 * �ع�����
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
