package com.kanlon.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ��Ĺ�����
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class TimeUtil {

	/**
	 * ���ݵ�ǰʱ��õ�����20181112190311��ʱ���ʽ
	 *
	 * @param millis
	 *            ʱ��ĺ���ֵ
	 * @return ����yyyyMMddHHmmss֮���ʱ���ַ�����ʽ
	 */
	public static String getLocalDateTime(long millis) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = format.format(new Date(millis));
		return dateStr;
	}

	/**
	 * ���ݵ�ǰʱ��õ�����2018-11-12 19:03:11��ʱ���ʽ
	 *
	 * @param millis
	 *            ʱ�����ֵ
	 * @return ����yyyy-MM-dd HH:mm:ss֮���ʱ���ʽ�ַ���
	 */
	public static String getSimpleDateTime(long millis) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date(millis));
		return dateStr;
	}

}
