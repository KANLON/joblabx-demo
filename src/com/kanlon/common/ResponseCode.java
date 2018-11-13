package com.kanlon.common;

/**
 * 返回给前端的响应码
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class ResponseCode {

	/**
	 * 成功
	 */
	public static final int RESPONSE_SUCCESS = 0;

	/**
	 * 输入或发送数据有误
	 */
	public static final int REQUEST_ERROR = 1;

	/**
	 * 后端出现错误
	 */
	public static final int RESPONSE_ERROR = 2;
}