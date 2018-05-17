package priv.cx.carl.encryption;

import org.apache.commons.codec.binary.Base64;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月19日 上午11:35:06
 */
public class Base64Util {

	/**
	 * 字符编码
	 */
	public final static String ENCODING = "UTF-8";

	/**
	 * Base64编码
	 * 
	 * @param data
	 *            待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static String encode(String data) throws Exception {

		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));

		return new String(b, ENCODING);
	}

	/**
	 * Base64安全编码<br>
	 * 遵循RFC 2045实现
	 * 
	 * @param data
	 *            待编码数据
	 * @return String 编码数据
	 * 
	 * @throws Exception
	 */
	public static String encodeSafe(String data) throws Exception {

		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING), true);

		return new String(b, ENCODING);
	}

	/**
	 * Base64解码
	 * 
	 * @param data
	 *            待解码数据
	 * @return String 解码数据
	 * @throws Exception
	 */
	public static String decode(String data) throws Exception {

		byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));

		return new String(b, ENCODING);
	}
}
