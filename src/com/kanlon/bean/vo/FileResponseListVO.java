package com.kanlon.bean.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 返回接受文件数据的值对象list集合(返回各学校人数和各个年份的人数)
 *
 * @author zhangcanlong
 * @date 2018年11月13日
 */
public class FileResponseListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4586603817140852334L;
	/**
	 * 年份的集合与各年份人数集合对应
	 */
	private List<String> yearList;
	/**
	 * 各年份人数集合，与年份集合对应
	 */
	private List<String> yearNumList;
	/**
	 * 学校名集合 ，与各学校人数集合对应
	 */
	private List<String> schoolList;
	/**
	 * 各学校人数集合，与学校名集合对应
	 */
	private List<String> schoolNumList;

	public List<String> getYearList() {
		return yearList;
	}

	public void setYearList(List<String> yearList) {
		this.yearList = yearList;
	}

	public List<String> getYearNumList() {
		return yearNumList;
	}

	public void setYearNumList(List<String> yearNumList) {
		this.yearNumList = yearNumList;
	}

	public List<String> getSchoolList() {
		return schoolList;
	}

	public void setSchoolList(List<String> schoolList) {
		this.schoolList = schoolList;
	}

	public List<String> getSchoolNumList() {
		return schoolNumList;
	}

	public void setSchoolNumList(List<String> schoolNumList) {
		this.schoolNumList = schoolNumList;
	}

}
