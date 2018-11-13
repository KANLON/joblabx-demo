package com.kanlon.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * ��־������
 *
 * @author zhangcanlong
 * @date 2018��11��12��
 */
public class LoggerUtil {

	public static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

	static {
		try {
			// �����ڿ���̨���
			logger.setUseParentHandlers(true);
			// ������־����ȼ�
			logger.setLevel(Level.INFO);
			FileHandler fileHandler = null;
			fileHandler = new FileHandler(Constant.CLASS_PATH + "/logs/"
					+ new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".log");
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			fileHandler.setFormatter(new Formatter() {
				@Override
				public String format(LogRecord arg0) {
					return String.format("%-8s", arg0.getLevel().getLocalizedName())
							+ sdf.format(new Date(arg0.getMillis())) + "  : " + arg0.getMessage() + "\n";
				}
			});
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
