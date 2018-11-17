package com.kanlon.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.kanlon.bean.SchoolExcelObject;
import com.kanlon.bean.po.SchoolExcelObjectPO;
import com.kanlon.common.CustomerExceptionTool;
import com.kanlon.common.LoggerUtil;
import com.kanlon.common.exception.BusinessException;
import com.kanlon.dao.DBUtilDao;

/**
 * 全国高校信息表处理类
 *
 * @author zhangcanlong
 * @date 2018年11月18日
 */
public class SchoolDataService {

	/**
	 * 存储学校的数据
	 *
	 * @param schools
	 * @return
	 * @throws BusinessException
	 */
	public boolean stroeSchoolData(List<SchoolExcelObject> schools) throws BusinessException {
		DBUtilDao dao = new DBUtilDao();
		if (schools == null || schools.size() == 0) {
			return true;
		}
		List<SchoolExcelObjectPO> lists = new ArrayList<>();
		for (SchoolExcelObject school : schools) {
			SchoolExcelObjectPO po = new SchoolExcelObjectPO();
			po.setNid(Integer.parseInt(school.getId()));
			po.setProvince(school.getProvince());
			po.setSchool(school.getSchool());
			po.setSchool_code(school.getSchoolCode());
			po.setBlong_to(school.getBlongTo());
			po.setCity(school.getCity());
			po.setEducation(school.getEducation());
			lists.add(po);
		}
		try {
			dao.insertSchoolObject(lists);
		} catch (SQLException e) {
			LoggerUtil.logger.log(Level.SEVERE, CustomerExceptionTool.getException(e));
			throw new BusinessException("插入数据库错误！！");
		}
		return true;
	}
}
