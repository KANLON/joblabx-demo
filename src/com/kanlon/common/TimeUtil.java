package com.kanlon.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间的工具类
 *
 * @author zhangcanlong
 * @date 2018年11月12日
 */
public class TimeUtil {

	/**
	 * 根据当前时间得到例如20181112190311的时间格式
	 *
	 * @param millis
	 *            时间的毫秒值
	 * @return 返回yyyyMMddHHmmss之类的时间字符串格式
	 */
	public static String getLocalDateTime(long millis) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = format.format(new Date(millis));
		return dateStr;
	}

	/**
	 * 根据当前时间得到例如2018-11-12 19:03:11的时间格式
	 *
	 * @param millis
	 *            时间毫秒值
	 * @return 返回yyyy-MM-dd HH:mm:ss之类的时间格式字符串
	 */
	public static String getSimpleDateTime(long millis) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = format.format(new Date(millis));
		return dateStr;
	}

}
