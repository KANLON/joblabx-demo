package com.kanlon.bean;

import com.github.crab2died.annotation.ExcelField;

/**
 * 导入学校表的excel对象
 *
 * @author zhangcanlong
 * @date 2018年11月17日
 */
public class SchoolExcelObject {
	@ExcelField(title = "序号", order = 0)
	private String id;
	@ExcelField(title = "省份", order = 1)
	private String province;

	@ExcelField(title = "大学名称", order = 2)
	private String school;

	@ExcelField(title = "代码", order = 3)
	private String schoolCode;
	@ExcelField(title = "所属", order = 4)
	private String blongTo;
	@ExcelField(title = "所属地区", order = 5)
	private String city;
	@ExcelField(title = "学历", order = 6)
	private String education;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public String getBlongTo() {
		return blongTo;
	}

	public void setBlongTo(String blongTo) {
		this.blongTo = blongTo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

}
