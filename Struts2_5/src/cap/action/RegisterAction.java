package cap.action;
import cap.bean.User;
import com.opensymphony.xwork2.ActionSupport;
public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private User user;
		
	/*
	public void validateRegister(){
		if(user.getUsername()==null || user.getUsername().equals("")){
			//this.addFieldError("user.name","用户名不能为空");			        
			this.addFieldError("user.name",getText("name.null"));
		}		
	}*/
	public String register()
	{
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

