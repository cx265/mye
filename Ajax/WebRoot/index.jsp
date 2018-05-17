<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'index.jsp' starting page</title>

<script type="text/javascript">
	window.onload = function() {
		document.getElementsByTagName("a")[0].onclick = function() {
			var request = new XMLHttpRequest();
			var url = this.href + "?time=" + new Date();
			var method = "GET";
			request.open(method, url);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200 || request.status == 304) {
						alert(request.responseText);
					}
				}
			};
			return false;
		}
		//解析HTML
		var aNodes = document.getElementsByTagName("a");
		for (var i = 0; i < aNodes.length; i++) {
			aNodes[i].onclick = function() {
				var request = new XMLHttpRequest();
				var url = this.href + "?time=" + new Date();
				var method = "GET";
				request.open(method, url);
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4) {
						if (request.status == 200 || request.status == 304) {
							document.getElementById("details").innerHTML = request.responseText;
						}
					}
				};
				return false;
			}
		}
		//解析XML
		var spanNodes = document.getElementsByTagName("a");
		spanNodes[4].onclick = function() {
			var request = new XMLHttpRequest();
			var url = this.href + "?time=" + new Date();
			var method = "GET";
			request.open(method, url);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200 || request.status == 304) {
						var result = request.responseXML;
						var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
						var email = result.getElementsByTagName("email")[0].firstChild.nodeValue;
						var aNode = document.createElement("a");
						aNode.appendChild(document.createTextNode(name));
						aNode.href = "mailto:" + email;
						var h2Node = document.createElement("h2");
						h2Node.appendChild(aNode);
						var detailsNode = document.getElementById("details");
						detailsNode.innerHTML = "";
						detailsNode.appendChild(h2Node);
					}
				}
			};
			return false;
		}
		//解析JSON
		var jsonNodes = document.getElementsByTagName("a");
		jsonNodes[5].onclick = function() {
			var request = new XMLHttpRequest();
			var url = this.href + "?time=" + new Date();
			var method = "GET";
			request.open(method, url);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4) {
					if (request.status == 200 || request.status == 304) {
						var result = request.responseText;
						var object = eval("("+result+")");
						var name = object.person.name;
						var email = object.person.email;
						var aNode = document.createElement("a");
						aNode.appendChild(document.createTextNode(name));
						aNode.href = "mailto:" + email;
						var h2Node = document.createElement("h2");
						h2Node.appendChild(aNode);
						var detailsNode = document.getElementById("details");
						detailsNode.innerHTML = "";
						detailsNode.appendChild(h2Node);
					}
				}
			};
			return false;
		}
	}
</script>
<script type="text/javascript">
	var jsonObject = {
		"name" : "cx",
		"fun" : function() {
			alert("fun....");
		}
	}
	//eval()方法
	var testStr = "{alert('hello...')}";
	eval(testStr);
	//把一个字符串转为json对象
	var jsonStr = "{'name':'lalalala'}";
	var testObject = eval("(" + jsonStr + ")");
	alert(testObject.name);
</script>
</head>

<body>
	<a href="helloAjax.txt">hello</a>
	<a href="1.html">1</a>
	<a href="2.html">2</a>
	<a href="3.html">3</a>
	<a href="span.xml">span</a>
	<a href="json.json">json</a>
	<div id="details"></div>
</body>
</html>
