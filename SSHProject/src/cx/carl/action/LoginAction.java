package cx.carl.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cx.carl.entity.Admin;

@Controller(value="LoginAction")
@Scope(value="prototype")
public class LoginAction extends ActionSupport {

	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getCharacterEncoding());
		if ("root".equals(admin.getName()) && "123".equals(admin.getPassword())) {
			Map session = ActionContext.getContext().getSession();
			session.put("name", admin.getName());
			System.out.println("name=" + admin.getName());
			return "success";
		}

		System.out.println("name=" + admin.getName());
		return "fail";
	}

}
