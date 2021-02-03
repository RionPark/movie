<%@page import="java.util.Map"%>
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
Map<String,String> rMap = (Map<String,String>)request.getAttribute("rMap");
String msg = rMap.get("msg");
out.println("<h3>" + msg + "</h3>");
%>
</body>
</html>