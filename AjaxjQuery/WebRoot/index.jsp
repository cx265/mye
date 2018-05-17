<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=path %>/asset/js/jquery-1.12.4.min.js"></script>
	<!-- <script type="text/javascript">
		$(function (){
			$("a").click(function(){
				var url = this.href + " h2";
				var args = {"time":new Date()};
				$("#details").load(url,args);
				return false;
			})
		})
	</script> -->
	<script type="text/javascript">
		$(function (){
			$("a").click(function(){
				var url = this.href;
				var args = {"time":new Date()};
				/* $.get(url, args, function(data){
					var name = $(data).find("name").text();
					var email = $(data).find("email").text();
					$("#details").empty().append("<h2><a href=\"mailto:"+ email +"\">"+name+"</a></h2>");
				}) */
				$.get(url, args, function(data){
					var name = data.person.name;
					var email = data.person.email;
					$("#details").empty().append("<h2><a href=\"mailto:"+ email +"\">"+name+"</a></h2>");
				},"JSON")
				return false;
			})
		})
	</script>
  </head>
  
  <body>
  	<a href="1.html">1</a>
	<a href="2.html">2</a>
	<a href="3.html">3</a>
	<a href="span.xml">span</a>
	<a href="json.json">json</a>
	<div id="details"></div>
  </body>
</html>
