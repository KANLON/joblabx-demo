package com.kanlon.service;

import java.util.ArrayList;
import java.util.List;

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

}
