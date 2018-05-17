package web.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import web.core.CP_SpringContext;

/*
 * 所有实现了WebApplicationInitializer接口的类都会在容器启动时自动被加载运行，用@Order注解设定加载顺序
 * 这是servlet3.0+后加入的特性，web.xml中可以不需要配置内容，都硬编码到WebApplicationInitializer的实现类中
 */
@Order(3)
// spring DispatcherServlet的配置,其它servlet和监听器等需要额外声明，用@Order注解设定启动顺序
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	/*
	 * DispatcherServlet的映射路径
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/*
	 * 应用上下文，除web部分
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class[] getRootConfigClasses() {
		return new Class[] { AppConfig.class, SpringSecurityConfig.class };
	}

	/*
	 * web上下文
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected Class[] getServletConfigClasses() {
		return new Class[] { MvcConfig.class };
	}

	/*
	 * 注册过滤器，映射路径与DispatcherServlet一致，
	 * 路径不一致的过滤器需要注册到另外的WebApplicationInitializer中
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}

	/*
	 * 可以注册DispatcherServlet的初始化参数，等等
	 */
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		// registration.setInitParameter("spring.profiles.active", "default");

	}

	/*
	 * 创建一个可以在非spring管理bean中获得spring管理的相关bean的对象：CP_SpringContext.getBean(String
	 * beanName)
	 */
	@Override
	protected WebApplicationContext createRootApplicationContext() {
		// TODO Auto-generated method stub
		WebApplicationContext ctx = super.createRootApplicationContext();
		CP_SpringContext.getInstance().setApplicationContext(ctx);
		return ctx;
	}

}
