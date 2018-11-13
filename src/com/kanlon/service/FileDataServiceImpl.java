package com.kanlon.service;

import java.util.ArrayList;
import java.util.List;

import com.kanlon.common.exception.BusinessException;

/**
 * 文件数据操作的service类
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class FileDataServiceImpl implements FileDataService {

	/**
	 * 存储数据
	 *
	 * @param list
	 *            嵌套list表，默认第一行为标题行
	 * @return 返回是否存储成功
	 */
	@Override
	public Boolean storeData(List<ArrayList<String>> list) throws BusinessException {

		return null;
	}

}
