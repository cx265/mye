<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'form8.jsp' starting page</title>

</head>

<body>
	<s:form action="form8.do" method="post" commandName="admin">
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
				<td>Sex:</td>
				<td><s:radiobutton path="sex" value="1"/>男
				<s:radiobutton path="sex" value="0"/>女</td>
			</tr>
			<tr>
				<td>球类:</td>
				<td><s:radiobuttons path="favorite" items="${ballMap }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
