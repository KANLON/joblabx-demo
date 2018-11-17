package com.kanlon;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kanlon.bean.po.ExcelObjectPO;
import com.kanlon.common.C3P0Util;
import com.kanlon.dao.DataDao;

/**
 * 测试类
 *
 * @author zhangcanlong
 * @date 2018年11月7日
 */
public class Test {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		DataDao dao = new DataDao();
		QueryRunner query = new QueryRunner(C3P0Util.getDataSource());
		try {
			List<ExcelObjectPO> objects = query.query("Select id,school,sex from joblabx_data limit 0,10",
					new BeanListHandler<>(ExcelObjectPO.class));
			for (ExcelObjectPO po : objects) {
				System.out.println(po.getSchool());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
