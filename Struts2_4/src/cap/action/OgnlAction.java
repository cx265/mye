package cap.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cap.bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport {
	private String username;
	private User user;
	private String[] fruits;
	private List<String> folowersList = new ArrayList<String>();
	private Map<Integer, String> provincesMap = new HashMap<Integer, String>();

	public OgnlAction() {
		username = "cdavtc";
		user = new User("starlee", "cdavtc");
		fruits = new String[] { "苹果", "梨子", "水蜜桃" };
		folowersList.add("太阳花");
		folowersList.add("海棠花");
		folowersList.add("风信子");
		provincesMap.put(1, "北京");
		provincesMap.put(2, "上海");
		provincesMap.put(3, "天津");
		provincesMap.put(4, "重庆");

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String[] getFruits() {
		return fruits;
	}

	public void setFruits(String[] fruits) {
		this.fruits = fruits;
	}

	public List<String> getFolowersList() {
		return folowersList;
	}

	public void setFolowersList(List<String> folowersList) {
		this.folowersList = folowersList;
	}

	public Map<Integer, String> getProvincesMap() {
		return provincesMap;
	}

	public void setProvincesMap(Map<Integer, String> provincesMap) {
		this.provincesMap = provincesMap;
	}

	public String execute() {
		return SUCCESS;
	}
}
