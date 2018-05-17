package cap.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdminLogger {

	public void logBefore() {
		System.out.println("前时间：" + (new Date()).toString());
	}
	
	public void logAfter() {
		System.out.println("后时间：" + (new Date()).toString());
	}
	
	public Object logAround(ProceedingJoinPoint joinPoint) {
		System.out.println("中时间：" + (new Date()).toString());
		Object[] args = joinPoint.getArgs();
		Object object =null;
		try {
			object = joinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return object;
	}
}
