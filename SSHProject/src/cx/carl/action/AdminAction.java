package cx.carl.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import cx.carl.entity.Admin;
import cx.carl.service.AdminService;

@Controller(value="adminAction")
@Scope(value="prototype")
public class AdminAction extends ActionSupport{
	
	private Admin admin;
	
	@Resource
	private AdminService adminService;

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public String addAdmin(){
		System.out.println("-------AdminAction.addAdmin--------"+admin.getName());
		adminService.addAdmin(admin);
		return "addAdmin";
	}
	
	public String modifyAdmin(){
		System.out.println("-------AdminAction.modifyAdmin--------"+admin.getName());
		adminService.modifyAdmin(admin);
		return "modifyAdmin";
	}
	
	public String deleteAdmin(){
		System.out.println("-------AdminAction.deleteAdmin--------"+admin.getName());
		adminService.deleteAdmin(admin);
		return "deleteAdmin";
	}
	
	public String pageLogin() {
		return "pageLogin";
	}
	
}
