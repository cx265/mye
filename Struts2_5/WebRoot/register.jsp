<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="register.page" /></title>
</head>
<body>
        <h2>
		<s:text name="register.title" />
		</h2>
		<s:form action="register" method="post">
			<s:textfield name="user.username" label="%{getText('username')}" />
			<s:password name="user.password" label="%{getText('password')}" />
			<s:password name="repassword" label="%{getText('repassword')}" />
			<s:submit value="%{getText('submit')}" />
		</s:form>
</body>
</html>
