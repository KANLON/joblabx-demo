package com.kanlon.common;

import java.io.Serializable;

/**
 * ���������������ݵı�׼������
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class JsonResult<Result> implements Serializable {
	private static final long serialVersionUID = 7714253606546956900L;

	/**
	 * ��Ӧ״̬
	 */
	private int code;

	/**
	 * ��Ӧ��Ϣ
	 */
	private String msg;

	/**
	 * ��Ӧ����
	 */
	private Result data;

	/**
	 * ���캯��
	 */
	public JsonResult() {
		this.code = 0;
		this.msg = "";
		this.data = null;
	}

	/**
	 * ���÷������ݵ�״̬�����Ϣ
	 *
	 * @param code
	 *            ��ʾ�������ݵ�״̬��
	 * @param msg
	 *            �����������ݵĴ�����Ϣ����ȷʱ����Ϊ��
	 */
	public void setStateCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
		this.data = (Result) "";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Result getData() {
		return data;
	}

	public void setData(Result data) {
		this.data = data;
	}
}