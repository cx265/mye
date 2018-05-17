package priv.cx.carl.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年9月6日 上午9:26:19
 */
public class IdCardUtil {

	/** 
     * 省、直辖市代码表： 
     *     11 : 北京  12 : 天津  13 : 河北       14 : 山西  15 : 内蒙古   
     *     21 : 辽宁  22 : 吉林  23 : 黑龙江  31 : 上海  32 : 江苏   
     *     33 : 浙江  34 : 安徽  35 : 福建       36 : 江西  37 : 山东   
     *     41 : 河南  42 : 湖北  43 : 湖南       44 : 广东  45 : 广西      46 : 海南   
     *     50 : 重庆  51 : 四川  52 : 贵州       53 : 云南  54 : 西藏   
     *     61 : 陕西  62 : 甘肃  63 : 青海       64 : 宁夏  65 : 新疆   
     *     71 : 台湾   
     *     81 : 香港  82 : 澳门   
     *     91 : 国外 
     */  
	private static String cityCode[] = { "11", "12", "13", "14", "15", "21", "22", "23", "31", "32", "33", "34", "35",
			"36", "37", "41", "42", "43", "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63", "64", "65",
			"71", "81", "82", "91" };

	/**
	 * 每位加权因子
	 */
	private static int POWER_LIST[] = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	final static String[] PARITY_BIT = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };

	/**
	 * 验证所有的身份证的合法性
	 * 
	 * @param idcard 身份证   传入时先trim()删除空格
	 * @return 合法返回true，否则返回false
	 */
	public static boolean validatedIdcard(String idcard) {
		if (idcard == null || "".equals(idcard)) {
			return false;
		}
		if (idcard.length() == 15) {
			return validate15IDCard(idcard);
		}
		return validate18Idcard(idcard);
	}

	/**
	 * 验证18位身份证的合法性
	 * 
	 * @param idcard 身份证   传入时先trim()删除空格
	 * @return 合法返回true，否则返回false
	 */
	public static boolean validate18Idcard(String idcard) {
		if (idcard == null) {
			return false;
		}

		// 非18位为假
		if (idcard.length() != 18) {
			return false;
		}
		// 获取前17位
		String idcard17 = idcard.substring(0, 17);

		// 前17位全部为数字
		if (!isDigital(idcard17)) {
			return false;
		}

		String provinceid = idcard.substring(0, 2);
		// 校验省份
		if (!checkProvinceid(provinceid)) {
			return false;
		}

		// 校验出生日期
		String birthday = idcard.substring(6, 14);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date birthDate = sdf.parse(birthday);
			String tmpDate = sdf.format(birthDate);
			if (!tmpDate.equals(birthday)) {// 出生年月日不正确
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		// 获取第18位
		String idcard18Code = idcard.substring(17, 18);
		char c[] = idcard17.toCharArray();
		int bit[] = converCharToInt(c);
		int sum17 = 0;
		sum17 = getPowerSum(bit);

		// 将和值与11取模得到余数进行校验码判断
		String checkCode = getCheckCodeBySum(sum17);
		if (null == checkCode) {
			return false;
		}
		// 将身份证的第18位与算出来的校码进行匹配，不相等就为假
		if (!idcard18Code.equalsIgnoreCase(checkCode)) {
			return false;
		}
		return true;
	}

	/**
	 * 验证15位身份证的合法性
	 * 
	 * @param idcard 身份证   传入时先trim()删除空格
	 * @return 合法返回true，否则返回false
	 */
	public static boolean validate15IDCard(String idcard) {
		if (idcard == null) {
			return false;
		}
		// 非15位为假
		if (idcard.length() != 15) {
			return false;
		}

		// 15全部为数字
		if (!isDigital(idcard)) {
			return false;
		}

		String provinceid = idcard.substring(0, 2);
		// 校验省份
		if (!checkProvinceid(provinceid)) {
			return false;
		}

		String birthday = idcard.substring(6, 12);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		try {
			Date birthDate = sdf.parse(birthday);
			String tmpDate = sdf.format(birthDate);
			if (!tmpDate.equals(birthday)) {// 身份证日期错误
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 将15位的身份证转成18位身份证
	 * 
	 * @param idcard
	 * @return
	 */
	public static String convertIdcarBy15bit(String idcard) {
		if (idcard == null) {
			return null;
		}

		// 非15位身份证
		if (idcard.length() != 15) {
			return null;
		}

		// 15全部为数字
		if (!isDigital(idcard)) {
			return null;
		}

		String provinceid = idcard.substring(0, 2);
		// 校验省份
		if (!checkProvinceid(provinceid)) {
			return null;
		}

		String birthday = idcard.substring(6, 12);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date birthdate = null;
		try {
			birthdate = sdf.parse(birthday);
			String tmpDate = sdf.format(birthdate);
			if (!tmpDate.equals(birthday)) {// 身份证日期错误
				return null;
			}
		} catch (ParseException e1) {
			return null;
		}

		Calendar cday = Calendar.getInstance();
		cday.setTime(birthdate);
		String year = String.valueOf(cday.get(Calendar.YEAR));
		String idcard17 = idcard.substring(0, 6) + year + idcard.substring(8);
		char c[] = idcard17.toCharArray();
		String checkCode = "";

		// 将字符数组转为整型数组
		int bit[] = converCharToInt(c);
		int sum17 = 0;
		sum17 = getPowerSum(bit);

		// 获取和值与11取模得到余数进行校验码
		checkCode = getCheckCodeBySum(sum17);

		// 获取不到校验位
		if (null == checkCode) {
			return null;
		}
		// 将前17位与第18位校验码拼接
		idcard17 += checkCode;
		return idcard17;
	}
	
	/**
	 * 将18位的身份证转成15位身份证
	 * 
	 * @param idcard
	 * @return
	 */
	public static String convertIdcarBy18bit(String idcard) {
		if (idcard == null) {
			return null;
		}

		// 非18位为假
		if (idcard.length() != 18) {
			return null;
		}
		// 获取前17位
		String idcard17 = idcard.substring(0, 17);

		// 前17位全部为数字
		if (!isDigital(idcard17)) {
			return null;
		}

		String provinceid = idcard.substring(0, 2);
		// 校验省份
		if (!checkProvinceid(provinceid)) {
			return null;
		}

		// 校验出生日期
		String birthday = idcard.substring(6, 14);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date birthDate = sdf.parse(birthday);
			String tmpDate = sdf.format(birthDate);
			if (!tmpDate.equals(birthday)) {// 出生年月日不正确
				return null;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

		// 获取第18位
		String idcard18Code = idcard.substring(17, 18);
		char c[] = idcard17.toCharArray();
		int bit[] = converCharToInt(c);
		int sum17 = 0;
		sum17 = getPowerSum(bit);

		// 将和值与11取模得到余数进行校验码判断
		String checkCode = getCheckCodeBySum(sum17);
		if (null == checkCode) {
			return null;
		}
		// 将身份证的第18位与算出来的校码进行匹配，不相等就为假
		if (!idcard18Code.equalsIgnoreCase(checkCode)) {
			return null;
		}
		
		return idcard.substring(0, 6) + idcard.substring(8, 17);
	}

	/**
	 * 校验省份
	 * 
	 * @param provinceid
	 * @return 合法返回TRUE，否则返回FALSE
	 */
	private static boolean checkProvinceid(String provinceid) {
		for (String id : cityCode) {
			if (id.equals(provinceid)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 数字验证
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isDigital(String str) {
		return str.matches("^[0-9]*$");
	}

	/**
	 * 将身份证的每位和对应位的加权因子相乘之后，再得到和值
	 * 
	 * @param bit
	 * @return
	 */
	private static int getPowerSum(int[] bit) {
		int sum = 0;
		if (POWER_LIST.length != bit.length) {
			return sum;
		}

		for (int i = 0; i < bit.length; i++) {
			for (int j = 0; j < POWER_LIST.length; j++) {
				if (i == j) {
					sum = sum + bit[i] * POWER_LIST[j];
				}
			}
		}
		return sum;
	}

	/**
	 * 将和值与11取模得到余数进行校验码判断
	 * 
	 * @param checkCode
	 * @param sum17
	 * @return 校验位
	 */
	private static String getCheckCodeBySum(int sum17) {
		return PARITY_BIT[sum17 % 11];
	}
	
	/**
	 * 将字符数组转为整型数组
	 * 
	 * @param 
	 * @return
	 * @throws NumberFormatException
	 */
	private static int[] converCharToInt(char[] c) throws NumberFormatException {
		int[] a = new int[c.length];
		int k = 0;
		for (char temp : c) {
			a[k++] = Integer.parseInt(String.valueOf(temp));
		}
		return a;
	}

	public static void main(String[] args) throws Exception {
		String idcard18 = "330411199404213618";
		// 18位身份证
		System.out.println(validatedIdcard(idcard18));
	}

}
