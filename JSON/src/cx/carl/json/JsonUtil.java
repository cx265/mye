package cx.carl.json;

import java.io.StringReader;

import com.google.gson.stream.JsonReader;

public class JsonUtil {
	public void parseJson(String jsonData){
		try {
			JsonReader jsonReader = new JsonReader(new StringReader(jsonData));
			jsonReader.beginArray();
			while (jsonReader.hasNext()) {
				jsonReader.beginObject();
				while (jsonReader.hasNext()) {
					String tagName = jsonReader.nextName();
					if (tagName.equals("name")) {
						System.out.println("name:"+jsonReader.nextString());
					}else if (tagName.equals("age")) {
						System.out.println("age:"+jsonReader.nextInt());
					}
				}
				jsonReader.endObject();
			}
			jsonReader.endArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
