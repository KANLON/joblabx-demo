package com.kanlon.bean.vo;

import java.io.Serializable;
import java.util.List;

/**
 * ���ؽ����ļ����ݵ�ֵ����list����(���ظ�ѧУ�����͸�����ݵ�����)
 *
 * @author zhangcanlong
 * @date 2018��11��13��
 */
public class FileResponseListVO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4586603817140852334L;
	/**
	 * ��ݵļ����������������϶�Ӧ
	 */
	private List<String> yearList;
	/**
	 * ������������ϣ�����ݼ��϶�Ӧ
	 */
	private List<String> yearNumList;
	/**
	 * ѧУ������ �����ѧУ�������϶�Ӧ
	 */
	private List<String> schoolList;
	/**
	 * ��ѧУ�������ϣ���ѧУ�����϶�Ӧ
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
