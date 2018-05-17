package cap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cap.bean.Admin;
import cap.service.AdminService;
import cap.util.PageBean;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<Admin> admins = adminService.findAdmins();
		mv.addObject("admins", admins);
		mv.setViewName("list");
		return mv;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public ModelAndView edit(
			@RequestParam(value = "id", required = true) Integer id) {
		Admin admin = adminService.findById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("admin", admin);
		mv.setViewName("edit");
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		Admin admin = new Admin(id, username, password);
		int res = adminService.updateAdmin(admin);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) Integer id) {
		int res = adminService.delAdmin(id);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {
		Admin admin = new Admin(username, password);
		int res = adminService.addAdmin(admin);
		if (res > 0) {
			return "redirect:list.do";
		} else {
			return "error";
		}
	}
	
	@RequestMapping(value = "lists", method = RequestMethod.GET)
	public ModelAndView lists(
			@RequestParam(value = "page", required = true,defaultValue="1") Integer page) {
		ModelAndView mv = new ModelAndView();
		List<Admin> admins = adminService.findAdmins();
		mv.addObject("admins", admins);
		PageBean pageBean = adminService.queryByPage(page, 5);
		mv.addObject("pageBean", pageBean);
		mv.addObject("page", page);
		mv.setViewName("lists");
		return mv;
	}

}
