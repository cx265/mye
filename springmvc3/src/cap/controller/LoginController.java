package cap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(String redirectUrl, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("redirectURL", redirectUrl);
		mv.setViewName("/login");
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			//@RequestParam(value = "redirectURL") String redirectUrl, 
			Model model,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		if (StringUtils.isNotBlank(username)
				&& StringUtils.isNotBlank(password) && username.equals("admin")
				&& password.equals("123")) {
			HttpSession session = request.getSession();
			session.setAttribute("u", "admin123");
			model.addAttribute("username",session);
			mv.addObject("user",username);
			mv.setViewName("/user/admin");
		} else {
			mv.setViewName("redirect:/login.do");
		}
		return mv;

	}
}
