<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ognl示例</title>
</head>
<body>
	欢迎
	<s:property value="username" />
	学习OGNL案例

	<b>对象使用</b>
	<br>
	<hr>
	<b>用户名 :</b>
	<s:property value="user.username" />
	<br>
	<b>密码 :</b>
	<s:property value="user.password" />
	<br>
	<br>

	<b>数组使用</b>
	<br>
	<hr>
	<b>fruits :</b>
	<s:property value="fruits" />
	<br>
	<b>水果的种类 :</b>
	<s:property value="fruits.length" />
	<br>
	<b>第一种水果 :</b>
	<s:property value="fruits[0]" />
	<br>
	<br>

	<b>List使用示例</b>
	<br>
	<hr>
	<b>folowersList :</b>
	<s:property value="folowersList" />
	<br>
	<b>folowersList.size :</b>
	<s:property value="folowersList.size" />
	<br>
	<b>folowersList[0] :</b>
	<s:property value="folowersList[0]" />
	<br>
	<br>

	<b>Map使用示例</b>
	<br>
	<hr>
	<b>provincesMap[1] :</b>
	<s:property value="provincesMap[1]" />
	<br>
	<b>provincesMap.size :</b>
	<s:property value="provincesMap.size" />
	<br>
	<br>
</body>
</html>
