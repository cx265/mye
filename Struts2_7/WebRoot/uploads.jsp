<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Uploads</title>
<script type="text/javascript">
function addMore(){
	var td = document.getElementById("more");
	var br = document.createElement("br");
	var input = document.createElement("input");
	var button = document.createElement("input");
	input.type = "file";
	input.name = "file";
	button.type = "button";
	button.value = "-";
    button.onclick = function() {
    td.removeChild(br);
	td.removeChild(input);
	td.removeChild(button);
}
		td.appendChild(br);
		td.appendChild(input);
		td.appendChild(button);
	}
</script>
</head>
<body>
	<s:form action="uploads" method="post" enctype="multipart/form-data">
		<table align="center" width="60%" border="1">
			<tr>
				<td>选择上传的文件:</td>
				<td id="more">
				<input type="file" name="file"> 
				<input type="button" value="添加"
					onclick="addMore()" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit value="上传" align="center"></s:submit></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
