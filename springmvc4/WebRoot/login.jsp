<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>json</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<script type="text/javascript">
	function login() {
		$.ajax({
			type : "get",
			url : "login.do",
			data:{username:$('#uname').val(),password:$('#upass').val()},
			dataType : "json",
			success : function(msg) {
				alert(msg.id + ':' + msg.username + ':' + msg.password);
			}
		});
	}

</script>

<body>
	<input type="text" name="username" id="uname"/>
	<input type="text" name="password" id="upass"/>
	<input type="button" value="login" onclick="login()"/>
</body>
</html>
