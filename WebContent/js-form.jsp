<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="f1">
	이름 : <input type="text" name="name"><br>
</form>
<button onclick="doSubmit()">전송</button>
<script>
function doSubmit(){
	var f1 = document.querySelector('#f1');
	f1.method="POST";
	f1.action="/test";
	f1.submit();
}
</script>
</body>
</html>