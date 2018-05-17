package com.cx.carl.springmvc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.cx.carl.springmvc.curd.dao.EmployeeDao;
import com.cx.carl.springmvc.curd.entities.Employee;

@Controller
public class SpringMVCTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping(value = "/testConversionServiceConverer")
	public String testConverter(@RequestParam("employee") Employee employee){
		System.out.println("save: " + employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@ResponseBody
	@RequestMapping(value = "/testJson")
	public Collection<Employee> testJson(){
		return employeeDao.getAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/testHttpMessageConverter")
	public String testHttpMessageConverter(@RequestBody String body){
		System.out.println(body);
		return "helloworld! " + new Date();
	}
	
	@RequestMapping(value = "/testResponseEntity")
	public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
		byte [] body = null;
		ServletContext servletContext = session.getServletContext();
		InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
		body = new byte[in.available()];
		in.read(body);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
		return response;
	}
	
	@RequestMapping(value = "/i18n")
	public String testI18n(Locale locale){
		String val = messageSource.getMessage("i18n.user", null, locale);
		System.out.println(val);
		return "i18n";
	}
	
	@RequestMapping(value = "/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc, 
			@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("desc: " + desc);
		System.out.println("OriginalFilename: " + file.getOriginalFilename());
		System.out.println("InputStream: " + file.getInputStream());
		return "success";
	}
	
	@RequestMapping(value = "/testExceptionHandlerExceptionResolver")
	public String testExceptionHandlerExceptionResolver(@RequestParam(value = "i") int i){
		System.out.println("result: " + (10 / i));
		return "success";
	}
	
	/**
	 * 1. 在 @ExceptionHandler 方法的入参中可以加入 Exception 类型的参数, 该参数即对应发生的异常对象
	 * 2. @ExceptionHandler 方法的入参中不能传入 Map. 若希望把异常信息传导页面上, 需要使用 ModelAndView 作为返回值
	 * 3. @ExceptionHandler 方法标记的异常有优先级的问题. 
	 * 4. @ControllerAdvice: 如果在当前 Handler 中找不到 @ExceptionHandler 方法来出来当前方法出现的异常, 
	 * 则将去 @ControllerAdvice 标记的类中查找 @ExceptionHandler 标记的方法来处理异常. 
	 */
//	@ExceptionHandler( {ArithmeticException.class} )
//	public ModelAndView handlerArithmeticException(Exception e){
//		System.out.println("出异常了：" + e);
//		ModelAndView mv = new ModelAndView("error");
//		return mv;
//	}
	
	@ResponseStatus(reason = "测试",value = HttpStatus.NOT_FOUND)
	@RequestMapping("/testResponseStatusExceptionResolver")
	public String testResponseStatusExceptionResolver(@RequestParam(value = "i") int i){
		if(i == 13){
			throw new UserNameNotMatchPasswordException();
		}
		System.out.println("testResponseStatusExceptionResolver...");
		return "success";
	}
	
	@RequestMapping(value = "/testDefaultHandlerExceptionResolver",method = RequestMethod.POST)
	public String testDefaultHandlerExceptionResolver(){
		System.out.println("testDefaultHandlerExceptionResolver...");
		return "success";
	}
	
	@RequestMapping(value = "/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam(value = "i") int i){
		String [] vals = new String[10];
		System.out.println(vals[i]);
		return "success";
	}
	
}
