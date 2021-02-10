<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/include/head.jsp"></jsp:include>
</head>
<body>
	
<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
<form class="form-signin" method="post" action="/theater/insert">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">극장 등록</h1>
		</div>
		<div class="form-label-group">
			<input type="text" id="ti_name" class="form-control" placeholder="극장명"
				required autofocus name="ti_name"> <label for="ui_id">극장명</label>
		</div>
		<div class="form-label-group">
			<input type="text" id="ti_address" class="form-control" placeholder="극장주소"
				required autofocus name="ti_address"> <label for="ui_id">극장주소</label>
		</div>
		<div class="form-label-group">
			<input type="text" id="ti_phone1" class="form-control" placeholder="전화번호1"
				required autofocus name="ti_phone1"> <label for="ui_id">전화번호1</label>
		</div>
		<div class="form-label-group">
			<input type="text" id="ti_phone2" class="form-control" placeholder="전화번호2"
				required autofocus name="ti_phone2"> <label for="ui_id">전화번호2</label>
		</div>
		<div class="checkbox mb-3">
<%
Map<String,String> rMap = (Map<String,String>)request.getAttribute("rMap");
if(rMap!=null){
	out.println("<br><b><code>" + rMap.get("msg") + "</code></b>");
}
%>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">등록</button>
	</form>
</body>
</html>