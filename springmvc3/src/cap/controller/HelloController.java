package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("data", "cx");
		return "welcome";

	}

	@RequestMapping("/test")
	public String hello1(Model model) {
		model.addAttribute("data", "cx1");
		return "welcome";

	}

}
