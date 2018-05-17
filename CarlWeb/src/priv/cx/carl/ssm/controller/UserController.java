package priv.cx.carl.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import priv.cx.carl.ssm.common.ReturnMessage;
import priv.cx.carl.ssm.common.Code;
import priv.cx.carl.ssm.pojo.User;
import priv.cx.carl.ssm.service.UserService;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 下午9:32:21
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		boolean ret = userService.login(username, password);
		ModelAndView mv = new ModelAndView();
		if (ret) {
			mv.setViewName("index");
		} else {
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value = "loginAsUser", method = {RequestMethod.GET, RequestMethod.POST})
	public ReturnMessage loginAsUser(User user) {
		ReturnMessage returnMessage = new ReturnMessage();
		userService.login(user);
		returnMessage.setCode(Code.SUCCESS); 
		return returnMessage;
	}
	
}
