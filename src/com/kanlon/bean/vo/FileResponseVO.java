package com.kanlon.bean.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * 返回接受文件数据的值对象(返回各学校人数和各个年份的人数)
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class FileResponseVO implements Serializable {
	private static final long serialVersionUID = -430937186621429933L;
	private Map<String, String> mapYear;
	private Map<String, String> mapSchool;

	public Map<String, String> getMapYear() {
		return mapYear;
	}

	public void setMapYear(Map<String, String> mapYear) {
		this.mapYear = mapYear;
	}

	public Map<String, String> getMapSchool() {
		return mapSchool;
	}

	public void setMapSchool(Map<String, String> mapSchool) {
		this.mapSchool = mapSchool;
	}

}
