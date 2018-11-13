package com.kanlon.common.exception;

/**
 * �Զ����ҵ���߼��쳣
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class BusinessException extends Exception {

	/**
	 * �Զ����쳣����
	 */
	private int code;
	/**
	 * �Զ����쳣��Ϣ
	 */
	private String message;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
		this.message = message;
	}

	public BusinessException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

}
