package com.kanlon.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.mysql.jdbc.StringUtils;

/**
 * 获取配置文件内容的工具局，采用双检验实现单例模式
 *
 * @author zhangcanlong
 * @date 2018年11月16日
 */
public final class PropUtil {
	private static volatile Properties prop;
	// 缓存配置文件的最后修改时间
	private static long lastModifiedTimeCache = 0l;

	private static void init() throws IOException {
		File conf = new File(Constant.WEB_APP_ROOT + "WEB-INF/resoure/config.properties");
		// 配置文件发生变化时加载
		if (prop == null || isFileChanged(conf)) {
			synchronized (PropUtil.class) {
				if (prop == null || isFileChanged(conf)) {
					prop = new Properties();
					prop.load(new FileReader(Constant.WEB_APP_ROOT + "WEB-INF/resoure/config.properties"));
					// 更新配置文件的最后修改时间
					lastModifiedTimeCache = conf.lastModified();
				}
			}
		}
	}

	/**
	 * 判断配置文件是否有更新
	 *
	 * @param file
	 *            配置文件
	 * @return
	 */
	private static boolean isFileChanged(File file) {
		long lastModifiedTime = file.lastModified();
		if (lastModifiedTime != lastModifiedTimeCache) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 根据配置的文件的key，得到值的字符串
	 * 
	 * @param key
	 * @return
	 */
	public static String getValueByKey(String key) {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(key)) {
			return prop.getProperty(key);
		} else {
			return "";
		}
	}
}
