<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'list.jsp' starting page</title>

</head>

<body>
	<table>
		<tr>
			<td width="50">Id</td>
			<td width="150">Username</td>
			<td width="150">Password</td>
		</tr>
		<c:forEach items="${admins }" var="admin">
			<tr>
				<td><c:out value="${admin.id }"></c:out></td>
				<td><c:out value="${admin.username }"></c:out></td>
				<td><c:out value="${admin.password }"></c:out></td>
				<td><a href="edit.do?id=${admin.id }">Edit</a></td>
				<td><a href="delete.do?id=${admin.id }">Delete</a></td>
			</tr><br/>
		</c:forEach>
	</table>
</body>
</html>
