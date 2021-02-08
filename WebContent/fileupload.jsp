<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
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
boolean upload = ServletFileUpload.isMultipartContent(request);
if(upload){
	DiskFileItemFactory dfiFactory = new DiskFileItemFactory();
	
	ServletFileUpload sfu = new ServletFileUpload(dfiFactory);
	
	List<FileItem> fiList = sfu.parseRequest(request);
	for(int i=0;i<fiList.size();i++){
		FileItem fi = fiList.get(i);
		//해당 fi의 isFormField가 true값이면
		//해당 fi는 file이 아님!!!!
		if(fi.isFormField()){
			String name = fi.getFieldName();
			String value = fi.getString("UTF-8");
			out.println("니가 입력한 " + name + " : " + value + "<br>");
		}else{
			String name = fi.getFieldName();
			out.println("니가 전송한 파일태그의 name : " + name + "<br>");
			String fileName = fi.getName();
			out.println("니가 전송할려는 파일 이름 : " + fileName + "<br>");
		}
	}
}else{
	String id = request.getParameter("id");
	if(id!=null){
		out.println("니가 입력한 아이디 : " + id);
	}
}
%>
<form method="post" enctype="multipart/form-data">
	<input type="text" name="id" placeholder="아이디"><br>
	<input type="text" name="name" placeholder="이름"><br>
	<input type="file" name="img" placeholder="프사"><br>
	<button>회원가입</button>
</form>
</body>
</html>