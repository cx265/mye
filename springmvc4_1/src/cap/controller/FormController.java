package cap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cap.bean.Admin;

import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/admin")
public class FormController {

	@RequestMapping(value = "/form1", method = RequestMethod.GET)
	public ModelAndView form1() {
		return new ModelAndView("form1").addObject(new Admin());
	}

	@RequestMapping(value = "/form2", method = RequestMethod.GET)
	public ModelAndView form2() {
		return new ModelAndView("form2").addObject(new Admin());
	}

	@RequestMapping(value = "/form3", method = RequestMethod.GET)
	public ModelAndView form3() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		admin.setSelected(true);
		return new ModelAndView("form3").addObject(admin);
	}
	
	@RequestMapping(value = "/form4", method = RequestMethod.GET)
	public ModelAndView form4() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		admin.setSelected(true);
		List<String> roles = new ArrayList<String>();
		roles.add("role3");
		admin.setRoles(roles);
		return new ModelAndView("form4").addObject(admin);
	}
	
	@RequestMapping(value = "/form5", method = RequestMethod.GET)
	public ModelAndView form5() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		List<String> roles = new ArrayList<String>();
		roles.add("role3");
		admin.setRoles(roles);
		List<String> roleList = new ArrayList<String>();
		roleList.add("role1");
		roleList.add("role2");
		roleList.add("role3");
		ModelAndView mv = new ModelAndView();
		mv.addObject("roleList",roleList);
		mv.setViewName("form5");
		mv.addObject(admin);
		return mv;
	}
	
	@RequestMapping(value = "/form6", method = RequestMethod.GET)
	public ModelAndView form6() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		List<String> roles = new ArrayList<String>();
		roles.add("role3");
		admin.setRoles(roles);
		Map<String, String> roleMap = new HashMap<String, String>();
		roleMap.put("role1", "角色1");
		roleMap.put("role2", "角色2");
		roleMap.put("role3", "角色3");
		ModelAndView mv = new ModelAndView();
		mv.addObject("roleMap",roleMap);
		mv.setViewName("form6");
		mv.addObject(admin);
		return mv;
	}
	
	@RequestMapping(value = "/form7", method = RequestMethod.GET)
	public ModelAndView form7() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		admin.setSex(0);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form7");
		mv.addObject(admin);
		return mv;
	}
	
	@RequestMapping(value = "/form8", method = RequestMethod.GET)
	public ModelAndView form8() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		admin.setSex(0);
		admin.setFavorite(3);
		Map<Integer, String> ballMap = new HashMap<Integer, String>();
		ballMap.put(1, "篮球");
		ballMap.put(2, "足球");
		ballMap.put(3, "网球");
		ballMap.put(4, "羽毛球");
		ModelAndView mv = new ModelAndView();
		mv.addObject("ballMap",ballMap);
		mv.setViewName("form8");
		mv.addObject(admin);
		return mv;
	}
	
	@RequestMapping(value = "/form9", method = RequestMethod.GET)
	public ModelAndView form9() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		admin.setSex(0);
		admin.setFavorite(3);
		Map<Integer, String> ballMap = new HashMap<Integer, String>();
		ballMap.put(1, "篮球");
		ballMap.put(2, "足球");
		ballMap.put(3, "网球");
		ballMap.put(4, "羽毛球");
		ModelAndView mv = new ModelAndView();
		mv.addObject("ballMap",ballMap);
		mv.setViewName("form9");
		mv.addObject(admin);
		return mv;
	}
	
	@RequestMapping(value = "/form10", method = RequestMethod.GET)
	public ModelAndView form10() {
		Admin admin = new Admin();
		admin.setUsername("cx");
		admin.setAge(22);
		admin.setIntroduction("我是。。。");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form10");
		mv.addObject(admin);
		return mv;
	}

	@RequestMapping(value = "/form1", method = RequestMethod.POST)
	public ModelAndView testForm1(String username, int age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", username);
		mv.addObject("age", age);
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(value = "/form2", method = RequestMethod.DELETE)
	public ModelAndView testForm2(String username, int age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", username);
		mv.addObject("age", age);
		mv.setViewName("result");
		return mv;
	}


}
