package com.kanlon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kanlon.common.exception.BusinessException;

public interface FileDataService {

	/**
	 * 存储数据
	 *
	 * @param list
	 *            嵌套list表，默认第一行为标题行
	 * @return 返回是否存储成功
	 */
	Boolean storeData(List<ArrayList<String>> list) throws BusinessException;

	/**
	 * 获取所有记录
	 *
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            每页大小
	 * @return 返回嵌套list集合
	 * @throws BusinessException
	 */
	List<ArrayList<String>> getAllData(int pageIndex, int pageSize) throws BusinessException;

	/**
	 * 获取所有记录
	 *
	 * @return 返回嵌套list集合
	 * @throws BusinessException
	 */
	Integer getAllDataNum() throws BusinessException;

	/**
	 * 获取指定某个学校或者年份的学生记录
	 *
	 * @param schoolOryear
	 *            学校名或者年份
	 * @param pageIndex
	 *            页码
	 * @param pageSize
	 *            每页大小
	 * @return 返回嵌套list集合
	 * @throws BusinessException
	 */
	List<ArrayList<String>> getOneSchoolOrYearData(String schoolOrYear, int pageIndex, int pageSize)
			throws BusinessException;

	/**
	 * 获取指定某个学校或者年份的学生记录的总数量
	 *
	 * @param schoolOryear
	 *            学校名或者年份
	 * @return 返回嵌套list集合
	 * @throws BusinessException
	 */
	Integer getOneSchoolOrYearDataNum(String schoolOrYear) throws BusinessException;

	/**
	 * 获取各个学校的人数的数量
	 *
	 * @return map集合key为学校，value为数量
	 * @throws BusinessException
	 */
	Map<String, String> getNumGroupBySchool() throws BusinessException;

	/**
	 * 获取各个年份的人数的数量
	 *
	 * @return map集合 key为年份，value为数量
	 * @throws BusinessException
	 */
	Map<String, String> getNumGroupByYear() throws BusinessException;

	/**
	 * 获取男女生的数量（集合第一个元素表示男生数量，集合第二个元素表示女生数量）
	 * 
	 * @return
	 * @throws BusinessException
	 */
	List<Integer> getNumGroupBySex() throws BusinessException;
}
