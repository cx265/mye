package priv.cx.carl.ssm.util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月2日 下午8:29:23
 */
public class Log4jUtil {

	private static final String configFile = "log4j.xml";

	static {
		BasicConfigurator.configure();
	}

	public Log4jUtil() {
		super();
	}

	public static String getConfigFile() {
		return configFile;
	}

	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz);
	}

	public static Logger getLogger(String strClass) {
		return Logger.getLogger(strClass);
	}

	public static Logger getLogger(String strClass, LoggerFactory loggerFactory) {
		return Logger.getLogger(strClass, loggerFactory);
	}
}
