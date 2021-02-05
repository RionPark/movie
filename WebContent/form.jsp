<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
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
Map<String,String[]> params = request.getParameterMap();
Map<String,String> param = new HashMap<>();
Iterator<String> it = params.keySet().iterator();
while(it.hasNext()){
	String key = it.next();
	String[] values = params.get(key);
	String value ="";
	for(int i=0;i<values.length;i++){
		value += values[i] + ",";
	}
	value = value.substring(0,value.length()-1);
	param.put(key,value);
}
out.println(param);
%>
	<form>
		<input type="text" name="input1"><br>
		<input type="text" name="input2"><br>
		<input type="text" name="input3"><br>
		<input type="text" name="input4"><br>
		<button>전송</button>
	</form>
</body>
</html>