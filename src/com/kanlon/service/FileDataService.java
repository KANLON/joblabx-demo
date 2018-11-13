package com.kanlon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kanlon.common.exception.BusinessException;

public interface FileDataService {

	/**
	 * �洢����
	 *
	 * @param list
	 *            Ƕ��list��Ĭ�ϵ�һ��Ϊ������
	 * @return �����Ƿ�洢�ɹ�
	 */
	Boolean storeData(List<ArrayList<String>> list) throws BusinessException;

	/**
	 * ��ȡ���м�¼
	 *
	 * @param pageIndex
	 *            ҳ��
	 * @param pageSize
	 *            ÿҳ��С
	 * @return ����Ƕ��list����
	 * @throws BusinessException
	 */
	List<ArrayList<String>> getAllData(int pageIndex, int pageSize) throws BusinessException;

	/**
	 * ��ȡ���м�¼
	 *
	 * @return ����Ƕ��list����
	 * @throws BusinessException
	 */
	Integer getAllDataNum() throws BusinessException;

	/**
	 * ��ȡָ��ĳ��ѧУ������ݵ�ѧ����¼
	 *
	 * @param schoolOryear
	 *            ѧУ���������
	 * @param pageIndex
	 *            ҳ��
	 * @param pageSize
	 *            ÿҳ��С
	 * @return ����Ƕ��list����
	 * @throws BusinessException
	 */
	List<ArrayList<String>> getOneSchoolOrYearData(String schoolOrYear, int pageIndex, int pageSize)
			throws BusinessException;

	/**
	 * ��ȡָ��ĳ��ѧУ������ݵ�ѧ����¼��������
	 *
	 * @param schoolOryear
	 *            ѧУ���������
	 * @return ����Ƕ��list����
	 * @throws BusinessException
	 */
	Integer getOneSchoolOrYearDataNum(String schoolOrYear) throws BusinessException;

	/**
	 * ��ȡ����ѧУ������������
	 *
	 * @return map����keyΪѧУ��valueΪ����
	 * @throws BusinessException
	 */
	Map<String, String> getNumGroupBySchool() throws BusinessException;

	/**
	 * ��ȡ������ݵ�����������
	 *
	 * @return map���� keyΪ��ݣ�valueΪ����
	 * @throws BusinessException
	 */
	Map<String, String> getNumGroupByYear() throws BusinessException;

}
