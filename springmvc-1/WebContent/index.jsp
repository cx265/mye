<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="helloworld">Hello World</a><br>
	<a href="springmvc/testRequestMapping">testRequestMapping</a><br>
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="testMethod">
	</form><br>
	<a href="springmvc/testParamsAndHeaders?username=cx&age=11">testParamsAndHeaders</a><br>
	<a href="springmvc/testAntPath/cccc/abc">testAntPath</a><br>
	<a href="springmvc/testPathVariable/2">testPathVariable</a><br>
	<!-- REST -->
	<a href="springmvc/testRest/2">testRest Get</a><br>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="testRest Post">
	</form><br>
	<form action="springmvc/testRest/2" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="testRest DELETE">
	</form><br>
	<form action="springmvc/testRest/2" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="testRest PUT">
	</form><br>
	<a href="springmvc/testRequestParam?username=cx&age=21">Test RequestParam</a><br>
	<a href="springmvc/testRequestHeader">testRequestHeader</a><br>
	<a href="springmvc/testCookieValue">Test CookieValue</a><br>
	<a href="springmvc/testServletAPI">Test ServletAPI</a><br>
	<form action="springmvc/testPojo" method="post">
		username: <input type="text" name="username"/>
		<br>
		password: <input type="password" name="password"/>
		<br>
		email: <input type="text" name="email"/>
		<br>
		age: <input type="text" name="age"/>
		<br>
		province: <input type="text" name="address.province"/>
		<br>
		city: <input type="text" name="address.city"/>
		<br>
		<input type="submit" value="Submit"/>
	</form><br>
	<a href="springmvc/testModelAndView">Test ModelAndView</a><br>
	<a href="springmvc/testMap">Test Map</a><br>
	<a href="springmvc/testSessionAttributes">Test SessionAttributes</a><br>
	<!--  
		模拟修改操作
		1. 原始数据为: 1 , Tom , 123456 , tom@163.com , 12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
	<form action="springmvc/testModelAttribute" method="post">
		<input type="hidden" name="id" value="1"/>
		username: <input type="text" name="username" value="Tom"/>
		<br>
		email: <input type="text" name="email" value="tom@163.com"/>
		<br>
		age: <input type="text" name="age" value="12"/>
		<br>
		<input type="submit" value="Submit"/>
	</form><br>
	<a href="springmvc/testView">Test ViewAndViewResolver</a><br>
	<a href="springmvc/testView">Test View</a><br>
	<a href="springmvc/testRedirect">Test Redirect</a><br>
</body>
</html>