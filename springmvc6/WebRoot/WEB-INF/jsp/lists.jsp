<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'lists.jsp' starting page</title>

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
			</tr>
		</c:forEach>
	</table>

	<c:choose>
		<c:when test="${pageBean.page <=1 }">
			[<font style="text-decoration: line-through;">First</font>][<font
				style="text-decoration: line-through;">Previous</font>]
		</c:when>
		<c:otherwise>
			[<a href="lists.do?page=1">First</a>][<a href="lists.do?page=${page-1 }">Previous</a>]
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${pageBean.page >=pageBean.totalPages }">
			[<font style="text-decoration: line-through;">Next</font>][<font
				style="text-decoration: line-through;">Last</font>]
		</c:when>
		<c:otherwise>
			[<a href="lists.do?page=${page+1 }">Next</a>][<a
				href="lists.do?page=${pageBean.totalPages }">Last</a>]
		</c:otherwise>
	</c:choose>
	&nbsp;Page:${pageBean.page } / ${pageBean.totalPages }&nbsp;TotalPage:
	${pageBean.totalPages }<br>
	<a href="add.do">add</a>

</body>
</html>
