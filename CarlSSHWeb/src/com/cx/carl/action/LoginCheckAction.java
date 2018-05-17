package com.cx.carl.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.cx.carl.model.Teacher;
import com.cx.carl.service.ITeacherService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginCheckAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private ITeacherService teacherService;

	// 在处理完客户端数据后，将返回内容封装成JSON对象
	private JSONObject makeTeachertoJSON(Teacher t, String type) {
		JSONObject r = new JSONObject();
		if (type.equals("教师")) {
			JSONArray jsonArray = new JSONArray();
			Teacher teacher = new Teacher();
			teacher.setTName(t.getTName());
			teacher.setTPassword(t.getTPassword());
			teacher.setTId(t.getTId());
			jsonArray = JSONArray.fromObject(teacher);
			r.put("result", jsonArray);
		}
		return r;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}

	public ITeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(ITeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public void login() throws IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if (type.equals("教师")) {
			Teacher teacher = teacherService.searchTeacher(name, password);
			PrintWriter out = response.getWriter();
			out.print(makeTeachertoJSON(teacher, type).toString());
			out.flush();
			out.close();
		}
	}
}
