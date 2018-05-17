package cx.carl.json1;

import com.google.gson.Gson;

public class JsonUtil {
	public void parseUserJson(String jsonData){
		Gson gson = new Gson();
		User user = gson.fromJson(jsonData, User.class);
		System.out.println("name:"+user.getName());
		System.out.println("age:"+user.getAge());
	}
}
