package cap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cap.bean.Admin;
import cap.service.AdminService;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "/login";

	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public @ResponseBody Admin login(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		Admin admin = new Admin(username, password);
		return adminService.login(admin);

	}
}
