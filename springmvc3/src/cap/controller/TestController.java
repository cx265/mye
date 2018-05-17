package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class TestController {
	
	@RequestMapping("/test")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/user/err");
		return mv;
	}
}
