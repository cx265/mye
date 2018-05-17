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
	<script type="text/javascript">
		$(function(){
			$(":input[name='userName']").change(function(){
				var val = $(this).val();
				val = $.trim(val);
				if(val != ""){
					var url = "<%=path%>/servlet/valiateUsername";
					var args = {"userName":val,"time":new Date()};
					$.post(url,args,function(data){
						$("#message").html(data);
					})
				}
			})
		})
	</script>
  </head>
  
  <body>
    <form action="" method="post">
    	name:<input type="text" name="userName"><br>
    	<div id="message"></div><br>
    	<input type="submit" value="login">
    </form>
  </body>
</html>
