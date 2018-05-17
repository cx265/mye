package priv.cx.carl.encryption;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月19日 上午11:37:10
 */
public class MD5Util {

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[]
	 */
	public static byte[] encodeMD5(String data) throws Exception {
		return DigestUtils.md5(data);
	}

	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[]
	 */
	public static String encodeMD5Hex(String data) {
		return DigestUtils.md5Hex(data);
	}
}
