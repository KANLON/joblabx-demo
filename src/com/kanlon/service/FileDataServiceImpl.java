package com.kanlon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kanlon.common.exception.BusinessException;
import com.kanlon.dao.DataDao;
import com.mysql.jdbc.StringUtils;

/**
 * �ļ����ݲ�����service��
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class FileDataServiceImpl implements FileDataService {
	DataDao dao = new DataDao();

	/**
	 * �洢���ݣ� Ĭ�ϵ�һ��Ԫ���Ǳ�����
	 *
	 * @param list
	 *            Ƕ��list��Ĭ�ϵ�һ��Ϊ������
	 * @return �����Ƿ�洢�ɹ�
	 */
	@Override
	public Boolean storeData(List<ArrayList<String>> list) throws BusinessException {
		// Ĭ�ϵ�һ��Ԫ���Ǳ�����
		if (list == null || list.size() <= 1) {
			return true;
		}
		list.remove(0);
		return dao.insertData(list);
	}

	@Override
	public List<ArrayList<String>> getAllData(int pageIndex, int pageSize) throws BusinessException {
		int offset = (pageIndex - 1) * pageSize;
		int limit = pageSize;
		return dao.selectAllData(offset, limit);
	}

	@Override
	public Integer getAllDataNum() throws BusinessException {
		String sql = "select count(*) num from joblabx_data";
		return dao.selectNumBySql(sql);
	}

	@Override
	public List<ArrayList<String>> getOneSchoolOrYearData(String schoolOrYear, int pageIndex, int pageSize)
			throws BusinessException {
		int offset = (pageIndex - 1) * pageSize;
		int limit = pageSize;
		if (StringUtils.isEmptyOrWhitespaceOnly(schoolOrYear)) {
			return getAllData(pageIndex, pageSize);
		}
		List<ArrayList<String>> list = new ArrayList<>();
		// ��������
		if (schoolOrYear.matches("\\d")) {
			list = dao.selectDataBySchoolAndYear(null, schoolOrYear, offset, limit);
		} else {
			// ѧУ
			list = dao.selectDataBySchoolAndYear(schoolOrYear, null, offset, limit);
		}
		return list;
	}

	@Override
	public Integer getOneSchoolOrYearDataNum(String schoolOrYear) throws BusinessException {
		if (StringUtils.isEmptyOrWhitespaceOnly(schoolOrYear)) {
			return getAllDataNum();
		}
		String sql = "select count(*) num from joblabx_data where 1=1 ";
		String condition = new String();
		// ��������
		if (schoolOrYear.matches("\\d")) {
			condition = " and  year='" + schoolOrYear + "'";
		} else {
			// ѧУ
			condition = " and school='" + schoolOrYear + "'";
		}
		sql = sql + condition;
		return dao.selectNumBySql(sql);
	}

	@Override
	public Map<String, String> getNumGroupBySchool() throws BusinessException {
		String sql = "SELECT school,COUNT(*) num FROM joblabx_data GROUP BY school";
		// ȫ����У������3000��
		List<ArrayList<String>> list = dao.selectDataBySql(sql, 2, 0, 10000);
		if (list == null || list.size() <= 0) {
			return null;
		}
		// ���м�����ȡ����У���͸ø�У������Ԫ�ط��뵽map��
		Map<String, String> map = new HashMap<>();
		for (ArrayList<String> colList : list) {
			map.put(colList.get(0), colList.get(1));
		}
		return map;
	}

	@Override
	public Map<String, String> getNumGroupByYear() throws BusinessException {
		String sql = "SELECT year,COUNT(*) num FROM joblabx_data GROUP BY year";
		// ȫ����У������3000��
		List<ArrayList<String>> list = dao.selectDataBySql(sql, 2, 0, 10000);
		if (list == null || list.size() <= 0) {
			return null;
		}
		// ���м�����ȡ����ݺ͸�����µ�����Ԫ�ط��뵽map��
		Map<String, String> map = new HashMap<>();
		for (ArrayList<String> colList : list) {
			map.put(colList.get(0), colList.get(1));
		}
		return map;
	}

}
