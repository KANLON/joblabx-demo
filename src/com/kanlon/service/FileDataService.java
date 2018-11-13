package com.kanlon.service;

import java.util.ArrayList;
import java.util.List;

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

}
