package priv.cx.carl.ssm.bean;

import org.springframework.stereotype.Component;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 上午10:21:08
 */
@Component("scheduledJobBean")
public class ScheduledJobBean {

	public void printMessage() {
		System.out.println("打印 scheduledJobBean.printMessage() 方法");
	}

}
