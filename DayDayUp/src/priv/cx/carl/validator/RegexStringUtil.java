package priv.cx.carl.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月6日 下午2:04:38
 */
public class RegexStringUtil {

	/**
	 * 以某些字符分割字符串
	 * 
	 * @param str
	 * @param separator
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static String[] spiltStr(String str, String separator) {
		Pattern pattern = Pattern.compile("[" + separator + "]+");
		return pattern.split(str);
	}

	/**
	 * 验证是否含有某个字符
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean containWithSign(String str, String sign) {
		Matcher matcher = Pattern.compile("[" + sign + "]+").matcher(str);
		return matcher.find();
	}
	
	/**
	 * 验证汉字
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean containWithChinese(String str) {
		return Pattern.matches("^[\\u4e00-\\u9fa5]+$", str);
	}

	/**
	 * 验证IP地址
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean validatedIP(String str) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
		return Pattern.matches(regex, str);
	}

	/**
	 * 验证网址Url
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean validatedUrl(String str) {
		String regex = "^([hH][tT]{2}[pP]:/*|[hH][tT]{2}[pP][sS]:/*|[fF][tT][pP]:/*)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\/])+(\\?{0,1}(([A-Za-z0-9-~]+\\={0,1})([A-Za-z0-9-~]*)\\&{0,1})*)$";
		return Pattern.matches(regex, str);
	}

	public static void main(String[] args) {
		for (String string : spiltStr("Java Hello | World  Java,Hello,,World", ",|")) {
			System.out.println(string);
		}
		System.out.println(containWithSign("Java Hello | World  Java,Hello,,World|Sun", ","));
		System.out.println(containWithChinese("你好呀"));
		System.out.println(validatedIP("10.10.12.102"));
		System.out.println(validatedUrl("http://v3.bootcss.com/silentjesse/p/3242701.html"));
	}
}
