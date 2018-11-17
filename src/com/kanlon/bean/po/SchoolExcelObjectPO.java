package com.kanlon.bean.po;

/**
 * 学校情况表的持久化实体类
 *
 * @author zhangcanlong
 * @date 2018年11月18日
 */
public class SchoolExcelObjectPO {
	/**
	 * 自增id
	 */
	private int id;
	/**
	 * excel表的序号
	 */
	private int nid;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 学校代码
	 */
	private String school_code;
	/**
	 * 所属
	 */
	private String blong_to;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 学历
	 */
	private String education;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool_code() {
		return school_code;
	}

	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}

	public String getBlong_to() {
		return blong_to;
	}

	public void setBlong_to(String blong_to) {
		this.blong_to = blong_to;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
