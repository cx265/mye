<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'form4.jsp' starting page</title>

</head>

<body>
	<s:form action="form4.do" method="post" commandName="admin">
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
				<td>Agree?</td>
				<td><s:checkbox path="selected" />同意？</td>
			</tr>
			<tr>
				<td>Roles:</td>
				<td><s:checkbox path="roles" value="role1" />role1
				<s:checkbox path="roles" value="role2" />role2
				<s:checkbox path="roles" value="role3" />role3</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
