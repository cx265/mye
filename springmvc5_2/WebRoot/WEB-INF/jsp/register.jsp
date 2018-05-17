<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册</title>
<style type="text/css">
	.error{
		color:red;
	}
	.errorblock{
		color:#000;
		background-color:#ffeeee;
		border:3px solid #ff0000;
		padding:8px;
		margin:16px;
	}
</style>
</head>
<body>
	<s:form action="reg.do" method="post" commandName="admin">
	<s:errors path="*" cssClass="errorblock" element="div"></s:errors>
		<table>
			<tr>
				<th>Username：</th>
				<td><s:input path="username" /> <s:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Age：</th>
				<td><s:input path="age" /> <s:errors path="age" cssClass="error"/></td>
			</tr>
			<tr>
				<th>Email：</th>
				<td><s:input path="email" /> <s:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				
				<td> <input type="submit" value="注册"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
