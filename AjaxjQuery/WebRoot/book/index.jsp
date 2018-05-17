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
			var isHasCart = "${sessionScope.shoppingCart == null}";
			if(isHasCart == "true"){
				$("#cart").hide();
			}else{
				$("#cart").show();
				$("#bookNumber").text(sessionScope.shoppingCart.bookName);
				$("#totalBookNumber").text(sessionScope.shoppingCart.totalBookNumber);
				$("#totalMoney").text(sessionScope.shoppingCart.totalMoney);
			}
			$("a").click(function(){
				$("#cart").show();
				var url = this.href;
				var args = {"time":new Date()};
				$.getJSON(url, args, function(data){
					$("#bookNumber").text(data.bookName);
					$("#totalBookNumber").text(data.totalBookNumber);
					$("#totalMoney").text(data.totalMoney);
				})
				return false;
			})
		})
	</script>
  </head>
  
  <body>
  	<div id="cart">你已将 <span id="bookNumber"></span> 加入到购物车。购物车一共有 <span id="totalBookNumber"></span> 本书。总价格 <span id="totalMoney"></span> 元。</div><br>
    Java<a href="<%=path %>/servlet/addToCart?id=Java&price=12">加入购物车</a><br>
    PHP<a href="<%=path %>/servlet/addToCart?id=PHP&price=15">加入购物车</a><br>
    ASP<a href="<%=path %>/servlet/addToCart?id=ASP&price=17">加入购物车</a><br>
  </body>
</html>
