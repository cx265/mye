package cx.carl.json1;

public class JsonData {
	private static String jsonData = "{\"name\":\"wangwu\",\"age\":18}";
	public static void main(String[] args) {
		JsonUtil jsonUtil = new JsonUtil();
		jsonUtil.parseUserJson(jsonData);
	}
}
