package com.kanlon.common;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * 返回json数据的工具类
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class JsonResponseUtil {

	/**
	 * 将响应设置为json数据格式，并将对象转化为json字符串
	 *
	 * @param response
	 * @param obj
	 * @return
	 */
	public static byte[] getVOJsonStr(HttpServletResponse response, Serializable obj) {
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		String jsonStr = JSON.toJSONString(obj);
		byte[] jsonByte = {};
		try {
			jsonByte = jsonStr.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return jsonByte;
	}
}
