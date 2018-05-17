package cap.action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() {
		return SUCCESS;
	}

	public String sayHello() {
		username = "你好" + username;
		return SUCCESS;
	}

}
