package cx.carl.json2;

public class JsonData {
	private static String jsonData = "[{\"name\":\"zhangsan\",\"age\":19},{\"name\":\"lisi\",\"age\":18}]";;
	public static void main(String[] args) {
		JsonUtil jsonUtil = new JsonUtil();
		jsonUtil.parseUserJson(jsonData);
	}
}
