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

  </head>
  
  <body>
    <a href="admin/form1.do">form1</a>
    <a href="admin/form2.do">form2</a>
    <a href="admin/form3.do">form3</a>
    <a href="admin/form4.do">form4</a>
    <a href="admin/form5.do">form5</a>
    <a href="admin/form6.do">form6</a>
    <a href="admin/form7.do">form7</a>
    <a href="admin/form8.do">form8</a>
    <a href="admin/form9.do">form9</a>
    <a href="admin/form10.do">form10</a>
  </body>
</html>
