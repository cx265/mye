<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'employee.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="<%=path %>/asset/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=path %>/asset/js/jquery.blockUI.2.7.0.js"></script>
<script type="text/javascript">
	$(function(){
		//blockUI
		$(document).ajaxStart(function() {
	        $.blockUI({
	            message: $('#loading'),
	            css: {
	                top:  ($(window).height() - 800) /2 + 'px',
	                left: ($(window).width() - 800) /2 + 'px',
	                width: '200px',
	                boeder: 'none' ,
	                backgroundColor: '#fff'
	            },
	            overlayCSS:{
	            	backgroundColor: '#fff'
	            }
	        })
	    }).ajaxStop($.unblockUI);
		
		$("#city").change(function(){
			$("#department option:not(:first)").remove();
			var city = $(this).val();
			if(city != ""){
				var url = "servlet/EmployeeServlet?method=listDepartments";
				var args = {"locationId":city,"time":new Date()};
				$.getJSON(url,args, function(data) {
					if(data.length == 0){
						alert("没有部门");
					}else{
						for(var i = 0; i<data.length;i++){
							var deptId = data[i].departmentId;
							var deptName = data[i].departmentName;
							$("#department").append("<option value='"+deptId+"'>"+deptName+"</option>")
						}
					}
				});
			}
		});
		
		$("#department").change(function(){
			$("#employee option:not(:first)").remove();
			var department = $(this).val();
			if(department != ""){
				var url = "servlet/EmployeeServlet?method=listEmployees";
				var args = {"departmentId":department,"time":new Date()};
				$.getJSON(url,args, function(data) {
					if(data.length == 0){
						alert("没有员工");
					}else{
						for(var i = 0; i<data.length;i++){
							var emplId = data[i].employeeId;
							var emplName = data[i].employeeName;
							$("#employee").append("<option value='"+emplId+"'>"+emplName+"</option>")
						}
					}
				});
			}
		})
	})
</script>

</head>

<body>
	<img alt="" id="loading" style="display: none;" src="<%=path %>/asset/images/load.gif">
	<center>
		<br> City: <select id="city"><option value="">请选择...</option>
			<c:forEach items="${locations }" var="location">
				<option value="${location.locationId }">${location.city }</option>
			</c:forEach></select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Department: <select id="department">
			<option value="">请选择...</option>
		</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Employee: <select id="employee">
			<option value="">请选择...</option>
		</select><br>
		<br>
		<table id="details" border="1" cellspacing="0" cellpadding="5" style="display: none">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Salary</th>
			</tr>
			<tr>
				<td id="id"></td>
				<td id="name"></td>
				<td id="email"></td>
				<td id="salary"></td>
			</tr>
		</table>

	</center>
</body>
</html>
