<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'form9.jsp' starting page</title>

</head>

<body>
	<s:form action="form10.do" method="post" commandName="admin">
		<table>
			<tr>
				<td>Name:</td>
				<td><s:input path="username" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><s:input path="age" /></td>
			</tr>
			<tr>
				<td>Introduction:</td>
				<td><s:textarea path="introduction" cols="20" rows="10"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
