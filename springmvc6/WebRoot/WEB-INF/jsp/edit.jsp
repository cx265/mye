<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>My JSP 'edit.jsp' starting page</title>
</head>
<body>
	<form action="update.do" method="post">
		<input type="hidden" name="id" value="${admin.id }">
		<input type="text" name="username" value="${admin.username }">
		<input type="text" name="password" value="${admin.password }">
		<input type="submit" value="修改">
	</form>
</body>
</html>
