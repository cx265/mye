<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>json</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
	function testJSON() {
		$.ajax({
			type : "get",
			url : "json.do",
			contentType:"application/json",
			dataType : "json",
			success : function(msg) {
				alert(msg.id + ':' + msg.username + ':' + msg.password);
			}
		});
	}

</script>
</head>

<body>
	<input value="json" type="button" onclick="testJSON()">
</body>
</html>
