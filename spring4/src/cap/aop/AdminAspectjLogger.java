package cap.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

public class AdminAspectjLogger {
	
	public static final String AAP= "execution(* cap.dao.impl.AdminDAOImpl.*(..))";
	@Before(AAP)
	public void logBefore() {
		System.out.println("前时间：" + (new Date()).toString());
	}
	@After(AAP)
	public void logAfter() {
		System.out.println("后时间：" + (new Date()).toString());
	}
	@Around(AAP)
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
