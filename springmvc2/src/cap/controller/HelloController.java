package cap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HelloController extends MultiActionController {
	
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String data = "add";
		return new ModelAndView("/add", "data", data);
	}
	
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String data = "list";
		return new ModelAndView("/list", "data", data);
	}
	
	
}
