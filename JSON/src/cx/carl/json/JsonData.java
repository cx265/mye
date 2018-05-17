package cx.carl.json;

public class JsonData {
	private static String jsonData = "[{\"name\":\"zhangsan\",\"age\":16},{\"name\":\"lisi\",\"age\":17}]";
	public static void main(String[] args) {
		JsonUtil jsonUtil = new JsonUtil();
		jsonUtil.parseJson(jsonData);
	}
}
