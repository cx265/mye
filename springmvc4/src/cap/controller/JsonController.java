package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cap.bean.Admin;

@Controller
public class JsonController {

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	@ResponseBody
	public Admin json() {
		Admin admin = new Admin("ccc", "111");
		return admin;
	}
}
