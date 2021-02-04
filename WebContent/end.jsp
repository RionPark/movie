<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String sessionStr = (String)session.getAttribute("str");
String str = (String)request.getAttribute("str");
%>
start.jsp에서 넘어온 str : <%=str%>
<br>
start.jsp에서 저장한 session str : <%=sessionStr%>
</body>
</html>