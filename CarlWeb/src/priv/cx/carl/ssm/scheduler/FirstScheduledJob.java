package priv.cx.carl.ssm.scheduler;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import priv.cx.carl.ssm.bean.ScheduledJobBean;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年8月31日 上午10:09:59
 */
public class FirstScheduledJob extends QuartzJobBean {

	@Autowired
	private ScheduledJobBean scheduledJobBean;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("打印 FirstScheduledJob 类");
		this.scheduledJobBean.printMessage();
	}

	public void setScheduledJobBean(ScheduledJobBean scheduledJobBean) {
		this.scheduledJobBean = scheduledJobBean;
	}
}
