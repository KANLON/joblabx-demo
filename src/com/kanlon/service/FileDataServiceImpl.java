package com.kanlon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kanlon.common.exception.BusinessException;
import com.kanlon.dao.DataDao;
import com.mysql.jdbc.StringUtils;

/**
 * 文件数据操作的service类
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class FileDataServiceImpl implements FileDataService {
	DataDao dao = new DataDao();

	/**
	 * 存储数据， 默认第一个元素是标题栏
	 *
	 * @param list
	 *            嵌套list表，默认第一行为标题行
	 * @return 返回是否存储成功
	 */
	@Override
	public Boolean storeData(List<ArrayList<String>> list) throws BusinessException {
		if (list == null || list.size() <= 1) {
			return true;
		}
		// list.remove(0);
		return dao.insertData(list);
	}

	@Override
	public List<ArrayList<String>> getAllData(int pageIndex, int pageSize) throws BusinessException {
		if (pageIndex <= 0 || pageSize <= 0) {
			throw new BusinessException("页码或每页条数请求参数错误！！！");
		}
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
		if (pageIndex <= 0 || pageSize <= 0) {
			throw new BusinessException("页码或每页条数请求参数错误！！！");
		}
		int offset = (pageIndex - 1) * pageSize;
		int limit = pageSize;
		if (StringUtils.isEmptyOrWhitespaceOnly(schoolOrYear)) {
			return getAllData(pageIndex, pageSize);
		}
		List<ArrayList<String>> list = new ArrayList<>();
		// 如果是年份
		if (schoolOrYear.matches("\\d")) {
			list = dao.selectDataBySchoolAndYear(null, schoolOrYear, offset, limit);
		} else {
			// 学校
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
		// 如果是年份
		if (schoolOrYear.matches("\\d")) {
			condition = " and  year='" + schoolOrYear + "'";
		} else {
			// 学校
			condition = " and school='" + schoolOrYear + "'";
		}
		sql = sql + condition;
		return dao.selectNumBySql(sql);
	}

	@Override
	public Map<String, String> getNumGroupBySchool() throws BusinessException {
		String sql = "SELECT school,COUNT(*) num FROM joblabx_data GROUP BY school";
		// 全国高校数少于3000间
		List<ArrayList<String>> list = dao.selectDataBySql(sql, 2, 0, 10000);
		if (list == null || list.size() <= 0) {
			return null;
		}
		// 从行集合中取出高校名和该高校的人数元素放入到map中
		Map<String, String> map = new HashMap<>();
		for (ArrayList<String> colList : list) {
			map.put(colList.get(0), colList.get(1));
		}
		return map;
	}

	@Override
	public Map<String, String> getNumGroupByYear() throws BusinessException {
		String sql = "SELECT year,COUNT(*) num FROM joblabx_data GROUP BY year";
		// 全国高校数少于3000间
		List<ArrayList<String>> list = dao.selectDataBySql(sql, 2, 0, 10000);
		if (list == null || list.size() <= 0) {
			return null;
		}
		// 从行集合中取出年份和该年份下的人数元素放入到map中
		Map<String, String> map = new HashMap<>();
		for (ArrayList<String> colList : list) {
			map.put(colList.get(0), colList.get(1));
		}
		return map;
	}

	@Override
	public List<Integer> getNumGroupBySex() throws BusinessException {
		StringBuffer sqlBuffer = new StringBuffer(
				"SELECT SUM(IF(sex = 'M',num,0)) AS '男' ,SUM(IF(sex = 'F',num,0)) AS '女' FROM("
						+ "SELECT sex,COUNT(*) num FROM joblabx_data GROUP BY sex" + ") group_table");
		List<ArrayList<String>> list = dao.selectDataBySql(sqlBuffer.toString(), 2, 0, 1);
		List<Integer> returnList = new ArrayList<>();
		returnList.add(Integer.parseInt(list.get(0).get(0)));
		returnList.add(Integer.parseInt(list.get(0).get(1)));
		return returnList;
	}

}
