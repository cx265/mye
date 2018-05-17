package priv.cx.carl.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月6日 下午1:57:02
 */
public class EmailUtil {

	public static boolean validatedEmail(String email) {
		String regex = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(validatedEmail("cxuan@citycloud.com.cn"));
	}
}
