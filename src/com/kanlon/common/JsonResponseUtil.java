package com.kanlon.common;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

/**
 * ����json���ݵĹ�����
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class JsonResponseUtil {

	/**
	 * ����Ӧ����Ϊjson���ݸ�ʽ����������ת��Ϊjson�ַ���
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
