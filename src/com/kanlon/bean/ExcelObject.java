package com.kanlon.bean;

import com.github.crab2died.annotation.ExcelField;

/**
 * excel表的对象
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class ExcelObject {
	@ExcelField(title = "性别", order = 0)
	private String sex;
	@ExcelField(title = "大学", order = 1)
	private String school;
	@ExcelField(title = "学院", order = 2)
	private String deparement;
	@ExcelField(title = "入学年", order = 3)
	private String year;
	@ExcelField(title = "J值", order = 4)
	private String JValue;

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

	public String getDeparement() {
		return deparement;
	}

	public void setDeparement(String deparement) {
		this.deparement = deparement;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getJValue() {
		return JValue;
	}

	public void setJValue(String jValue) {
		JValue = jValue;
	}

}
