package com.kanlon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import com.kanlon.bean.po.SchoolExcelObjectPO;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.JDBCUtil;
import com.kanlon.common.LoggerUtil;

/**
 * 基于dbutil框架的dao类
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class DBUtilDao {

	/**
	 * 插入学校数据
	 *
	 * @param lists
	 *            学校持久层实体类集合
	 * @return
	 * @throws SQLException
	 */
	public Boolean insertSchoolObject(List<SchoolExcelObjectPO> lists) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		// 影响结果的总行数
		int row = 0;
		try {
			conn = JDBCUtil.getConnect();
			JDBCUtil.beginTransaction(conn);
			String sql = "insert into school_data(nid,province,school,school_code,blong_to,city,education) values(?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			// 遍历行
			for (int i = 0; i < lists.size(); i++) {
				// 遍历列
				stmt.setInt(1, lists.get(i).getNid());
				stmt.setString(2, lists.get(i).getProvince());
				stmt.setString(3, lists.get(i).getSchool());
				stmt.setString(4, lists.get(i).getSchool_code());
				stmt.setString(5, lists.get(i).getBlong_to());
				stmt.setString(6, lists.get(i).getCity());
				stmt.setString(7, lists.get(i).getEducation());
				// 添加批处理
				stmt.addBatch();
				// 每3000条执行一次批处理
				if ((i + 1) % 1000 == 0) {
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

			if (row != lists.size()) {
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
}
