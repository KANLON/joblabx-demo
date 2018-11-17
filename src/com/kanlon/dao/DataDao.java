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

import com.kanlon.bean.ExcelObject;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JDBCUtil;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.TimeUtil;
import com.mysql.jdbc.StringUtils;

/**
 * 将数据写入数据库，进行增删改查操作
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class DataDao {

	/**
	 * 根据list集合插入数据
	 *
	 * @param list
	 *            数据的list集合
	 * @return 返回是否插入成功
	 */
	public Boolean insertData(List<ArrayList<String>> list) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		// 影响结果的总行数
		int row = 0;
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "insert into joblabx_data(sex,school,department,YEAR,j_value) values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			// 遍历行
			for (int i = 0; i < list.size(); i++) {
				// 遍历列
				for (int j = 0; j < list.get(i).size(); j++) {
					stmt.setString(j + 1, list.get(i).get(j));
				}
				// 添加批处理
				stmt.addBatch();
				// 每3000条执行一次批处理
				if ((i + 1) % 3000 == 0) {
					// 批量执行
					int[] ints = stmt.executeBatch();
					for (int z = 0; z < ints.length; z++) {
						row += ints[z];
					}
					// 清空批处理
					stmt.clearBatch();
				}
			}
			// 批量执行
			int[] ints = stmt.executeBatch();
			for (int z = 0; z < ints.length; z++) {
				row += ints[z];
			}
			LoggerUtil.logger.log(Level.INFO, Arrays.toString(ints));
			// 清空批处理
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
	 * 根据list集合对象插入数据
	 *
	 * @param objects
	 *            数据的list集合对象
	 * @return 返回是否插入成功
	 */
	public Boolean insertObjectData(List<ExcelObject> objects) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		// 影响结果的总行数
		int row = 0;
		long millisTime = System.currentTimeMillis();
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "insert into joblabx_data(sex,school,department,YEAR,j_value) values(?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			// 遍历行
			for (int i = 0; i < objects.size(); i++) {
				// 遍历列
				stmt.setString(1, objects.get(i).getSex());
				stmt.setString(2, objects.get(i).getSchool());
				stmt.setString(3, objects.get(i).getDeparement());
				stmt.setString(4, objects.get(i).getYear());
				stmt.setString(5, objects.get(i).getJValue());
				// 添加批处理
				stmt.addBatch();
				// 每3000条执行一次批处理
				if ((i + 1) % 3000 == 0) {
					// 批量执行
					int[] ints = stmt.executeBatch();
					for (int z = 0; z < ints.length; z++) {
						row += ints[z];
					}
					// 清空批处理
					stmt.clearBatch();
				}
			}
			// 批量执行
			int[] ints = stmt.executeBatch();
			for (int z = 0; z < ints.length; z++) {
				row += ints[z];
			}
			LoggerUtil.logger.log(Level.INFO, Arrays.toString(ints));
			// 清空批处理
			stmt.clearBatch();

			if (row != objects.size()) {
				JDBCUtil.rollBackTransaction(conn);

				return false;
			} else {
				JDBCUtil.commitTransaction(conn);
				LoggerUtil.logger.log(Level.SEVERE,
						"花费的时间为：" + String.valueOf(System.currentTimeMillis() - millisTime));
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
	 * 根据list集合插入数据到临时表中
	 *
	 * @param list
	 *            数据的list集合
	 * @return 返回是否插入成功
	 */
	public Boolean insertTempData(List<ArrayList<String>> list) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		// 影响结果的总行数
		int row = 0;
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "insert into joblabx_data(ctime,sex,school,deparement,YEAR,j_value) values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			// 遍历行
			for (int i = 0; i < list.size(); i++) {
				// 设置创建时间
				stmt.setString(1, TimeUtil.getSimpleDateTime(System.currentTimeMillis()));
				// 遍历列
				for (int j = 0; j < list.get(i).size(); j++) {
					stmt.setString(j + 1, list.get(i).get(j));
				}
				// 添加批处理
				stmt.addBatch();
				// 每3000条执行一次批处理
				if ((i + 1) % 3000 == 0) {
					// 批量执行
					int[] ints = stmt.executeBatch();
					for (int z = 0; z < ints.length; z++) {
						row += ints[z];
					}
					// 清空批处理
					stmt.clearBatch();
				}
			}
			// 批量执行
			int[] ints = stmt.executeBatch();
			for (int z = 0; z < ints.length; z++) {
				row += ints[z];
			}
			LoggerUtil.logger.log(Level.INFO, Arrays.toString(ints));
			// 清空批处理
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
	 * 返回所有记录数据
	 *
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<ArrayList<String>> selectAllData(int offset, int limit) {
		return selectDataBySchoolAndYear(null, null, offset, limit);
	}

	/**
	 * 根据id查询查询出结果
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
			String sql = "select * from joblabx_data where id =?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(rs.getString(4));
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
	 * 根据id数组查询出嵌套list集合
	 *
	 * @param ids
	 */
	public List<ArrayList<String>> selectDataByIds(String[] ids, int offset, int limit) {
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
			sql = "select * from joblabx_data where id in (" + idsBuffer.toString() + ") " + " limit " + offset + ","
					+ limit;
			rs = statTest.executeQuery(sql);
			while (rs.next()) {
				ArrayList<String> collist = new ArrayList<>();
				collist.add(rs.getString(1));
				collist.add(rs.getString(2));
				collist.add(rs.getString(3));
				collist.add(rs.getString(4));
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
	 * 根据学校条件和年级条件查询出嵌套list集合
	 *
	 * @param school
	 * @param year
	 * @return
	 */
	public List<ArrayList<String>> selectDataBySchoolAndYear(String school, String year, int offset, int limit) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sql = " select * from joblabx_data where 1=1 ";
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
			// 默认倒叙id输出
			sql = sql + conditionBuffer.toString() + " order by id desc " + " limit " + offset + "," + limit;
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> collist = new ArrayList<>();
				collist.add(rs.getString("id"));
				collist.add(rs.getString("sex"));
				collist.add(rs.getString("school"));
				collist.add(rs.getString("department"));
				collist.add(rs.getString("year"));
				collist.add(rs.getString("j_value"));

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
	 * 根据id和传入的list集合更新某个条记录
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
			// 去掉最后个逗号
			String condition = buffer.toString();
			if (condition.contains(",")) {
				condition = condition.substring(0, condition.length() - 1);
			}
			String sql = "update  joblabx_data set" + condition + " where id='" + id + "' ";
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
	 * 根据id删除条记录
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
			String sql = "delete from joblabx_data where id=? ";
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
	 * 截断所有数据
	 *
	 */
	public Boolean truncateAllData() {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int row = 0;
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "truncate table joblabx_data ";
			stmt = conn.prepareStatement(sql);
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
	 * 根据sql 语句查询出数据(嵌套list集合)
	 *
	 * @param sql
	 *            语句
	 * @param columnNum
	 *            查询出列的数量
	 * @return
	 */
	public List<ArrayList<String>> selectDataBySql(String sql, int columnNum, int offset, int limit) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		sql = sql + " limit " + offset + "," + limit;
		if (columnNum <= 0) {
			return null;
		}
		List<ArrayList<String>> list = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnect();
			LoggerUtil.logger.log(Level.INFO, "查询的sql为：" + sql);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ArrayList<String> colList = new ArrayList<>();
				// 根据列数量，存入到list集合中
				for (int i = 1; i <= columnNum; i++) {
					colList.add(rs.getString(i));
				}
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
	 * 根据sql 语句查询出数量
	 *
	 * @param sql
	 * @return
	 */
	public int selectNumBySql(String sql) {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		int num = 0;
		try {
			conn = JDBCUtil.getConnect();
			stmt = conn.prepareStatement(sql);
			LoggerUtil.logger.log(Level.INFO, sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}
			LoggerUtil.logger.log(Level.INFO, "查询出的数量为:" + String.valueOf(num));
		} catch (Exception e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new RuntimeException(e.getMessage());
		} finally {
			JDBCUtil.close(conn, stmt, rs);
		}
		return num;
	}

	/**
	 * 根据sql 语句更新,查询，删除数据
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
