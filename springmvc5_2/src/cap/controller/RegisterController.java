package cap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cap.bean.Admin;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/reg",method=RequestMethod.GET)
	public ModelAndView register(){
		return new ModelAndView("register","admin",new Admin());
	}
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public ModelAndView register(@Validated Admin admin ,BindingResult result){
		if (result.hasErrors()) {
			return new ModelAndView("register");
		}
		return new ModelAndView("welcome");
	}
}
