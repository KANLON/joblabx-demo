package com.kanlon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JDBCUtil;
import com.kanlon.common.LoggerUtil;
import com.mysql.jdbc.StringUtils;

/**
 * ������д�����ݿ⣬������ɾ�Ĳ����
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class DataDao {

	/**
	 * ����list���ϲ�������
	 *
	 * @param list
	 *            ���ݵ�list����
	 * @return �����Ƿ����ɹ�
	 */
	public Boolean insertData(List<ArrayList<String>> list) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		// Ӱ������������
		int row = 0;
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "insert into person(pname,sex) values(?,?)";
			stmt = conn.prepareStatement(sql);
			// ������
			for (int i = 0; i < list.size(); i++) {
				// ������
				for (int j = 0; j < list.get(i).size(); j++) {
					stmt.setString(j + 1, list.get(i).get(j));
				}
				// ���������
				stmt.addBatch();
				// ÿ100��ִ��һ��������
				if (i + 1 % 100 == 0) {
					// ����ִ��
					int[] ints = stmt.executeBatch();
					for (int z = 0; z < ints.length; z++) {
						row += ints[z];
					}
					// ���������
					stmt.clearBatch();
				}
			}
			// ����ִ��
			int[] ints = stmt.executeBatch();
			for (int z = 0; z < ints.length; z++) {
				row += ints[z];
			}
			LoggerUtil.logger.log(Level.INFO, Arrays.toString(ints));
			// ���������
			stmt.clearBatch();
			if (row != list.size()) {
				JDBCUtil.rollBackTransaction(conn);
				return false;
			} else {
				JDBCUtil.commitTransaction(conn);
				return true;
			}
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			JDBCUtil.rollBackTransaction(conn);
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
	}

	/**
	 * ����id��ѯ��ѯ�����
	 *
	 * @param id
	 */
	public List<String> selectDataById(String id) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnect();
			String sql = "select * from person where pid =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
			}
			LoggerUtil.logger.log(Level.INFO, list.toString());
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return list;
	}

	/**
	 * ����id�����ѯ��Ƕ��list����
	 *
	 * @param ids
	 */
	public List<ArrayList<String>> selectDataByIds(String[] ids) {
		PreparedStatement stmt = null;
		Statement statTest = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = "";
		StringBuffer idsBuffer = new StringBuffer();
		List<ArrayList<String>> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnect();
			statTest = conn.createStatement();
			for (int i = 0; i < ids.length; i++) {
				if (i == ids.length - 1) {
					idsBuffer.append(ids[i]);
				} else {
					idsBuffer.append(ids[i] + ",");
				}
			}
			sql = "select * from person where pid in (" + idsBuffer.toString() + ")";
			rs = statTest.executeQuery(sql);
			while (rs.next()) {
				ArrayList<String> collist = new ArrayList<>();
				collist.add(rs.getString(1));
				collist.add(rs.getString(2));
				collist.add(rs.getString(3));
				list.add(collist);
			}

		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		LoggerUtil.logger.log(Level.INFO, sql);
		LoggerUtil.logger.log(Level.INFO, list.toString());
		return list;
	}

	/**
	 * ����ѧУ�������꼶������ѯ��Ƕ��list����
	 *
	 * @param school
	 * @param year
	 * @return
	 */
	public List<ArrayList<String>> selectDataBySchoolAndYear(String school, String year) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = " select * from person where 1=1 ";
		StringBuffer conditionBuffer = new StringBuffer();
		List<ArrayList<String>> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnect();
			if (!StringUtils.isEmptyOrWhitespaceOnly(school)) {
				conditionBuffer.append(" and school='" + school + "' ");
			}
			if (!StringUtils.isEmptyOrWhitespaceOnly(year)) {
				conditionBuffer.append(" and year='" + year + "' ");
			}
			stmt = conn.prepareStatement(sql + conditionBuffer.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> collist = new ArrayList<>();
				collist.add(rs.getString(1));
				collist.add(rs.getString(2));
				collist.add(rs.getString(3));
				list.add(collist);
			}
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		LoggerUtil.logger.log(Level.INFO, sql + conditionBuffer.toString());
		LoggerUtil.logger.log(Level.INFO, list.toString());
		return list;
	}

	/**
	 * ����id�ʹ����list���ϸ���ĳ������¼
	 *
	 * @param id
	 * @param list
	 */
	public Boolean updataDataById(String id, Map<String, String> map) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		if (map == null || map.size() <= 0) {
			return false;
		}
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			StringBuffer buffer = new StringBuffer();
			for (String key : map.keySet()) {
				if (map.get(key) != null) {
					buffer.append(" " + key + "='" + map.get(key) + "',");
				}
			}
			// ȥ����������
			String condition = buffer.toString();
			if (condition.contains(",")) {
				condition = condition.substring(0, condition.length() - 1);
			}
			String sql = "update  person set" + condition + " where pid='" + id + "' ";
			LoggerUtil.logger.log(Level.INFO, sql);
			stmt = conn.prepareStatement(sql);
			int row = stmt.executeUpdate();
			JDBCUtil.commitTransaction(conn);
			if (row == 1) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			JDBCUtil.rollBackTransaction(conn);
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
	}

	/**
	 * ����idɾ������¼
	 *
	 * @param id
	 */
	public Boolean deleteDataById(String id) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "delete from person where pid=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			row = stmt.executeUpdate();
			JDBCUtil.commitTransaction(conn);
			if (row != 1) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			JDBCUtil.rollBackTransaction(conn);
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
	}

	/**
	 * ����sql ����ѯ������
	 *
	 * @param sql
	 * @return
	 */
	public List<ArrayList<String>> selectDataBySql(String sql) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<ArrayList<String>> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnect();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> colList = new ArrayList<>();
				colList.add(rs.getString(1));
				colList.add(rs.getString(2));
				colList.add(rs.getString(3));
				list.add(colList);
			}
			LoggerUtil.logger.log(Level.INFO, list.toString());
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return list;
	}

	/**
	 * ����sql ������,��ѯ��ɾ������
	 *
	 * @param sql
	 * @return
	 */
	public int updateDataBySql(String sql) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int row = 0;
		List<ArrayList<String>> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnect();
			stmt = conn.prepareStatement(sql);
			row = stmt.executeUpdate();
			LoggerUtil.logger.log(Level.INFO, list.toString());
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return row;
	}

}
