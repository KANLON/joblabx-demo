package com.kanlon.bean.po;

import java.io.Serializable;

/**
 * 存到数据库中的excel的列里面的对象
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class ExcelObjectPO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -5535032243231557883L;
	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 入学年份
	 */
	private String year;
	/**
	 * j值
	 */
	private String j_value;
	/**
	 * 学院
	 */
	private String department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

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

	public String getJ_value() {
		return j_value;
	}

	public void setJ_value(String j_value) {
		this.j_value = j_value;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
