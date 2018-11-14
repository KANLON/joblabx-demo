package com.kanlon.common.exception;

/**
 * 自定义的业务逻辑异常
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class BusinessException extends Exception {

	/**
	 * 自定义异常代码
	 */
	private int code;
	/**
	 * 自定义异常信息
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
