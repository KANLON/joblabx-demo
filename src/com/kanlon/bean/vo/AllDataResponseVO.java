package com.kanlon.bean.vo;

/**
 * 一行记录的实体类
 *
 * @author zhangcanlong
 * @date 2018年11月16日
 */
public class AllDataResponseVO {
	/**
	 * 学校名
	 */
	private String school;

	/**
	 * 学院名
	 */
	private String department;
	/**
	 * 入学年份
	 */
	private String year;
	/**
	 * j值
	 */
	private String jValue;
	/**
	 * 性别
	 */
	private String sex;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getjValue() {
		return jValue;
	}

	public void setjValue(String jValue) {
		this.jValue = jValue;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
