<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
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
boolean isFileUpload = ServletFileUpload.isMultipartContent(request);
if(isFileUpload){
	out.println("업로드 로직을 만들면 됨~~");
}else{
	out.println("아 난 파일 업로드 요청이 아니군 그럼 그냥 일반적인 요청 처리를 해주면 됨~");
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
}
%>
	<form method="post" action="/form.jsp">
		<input type="text" name="name" value="test">
		<button>일반 POST전송</button>
	</form>
	<br>
	<form method="post" action="/form.jsp" enctype="multipart/form-data">
		<input type="file" name="name" value="test">
		<button>파일 POST전송</button>
	</form>
	
</body>
</html>