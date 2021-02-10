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
<%
Map<String,String> theater = (Map<String,String>) request.getAttribute("theater");
%>

		<div class="container">
			<div class="text-center mb-4">
				<h1 class="h3 mb-3 font-weight-normal">극장 정보</h1>
			</div>
			<div class="text-center">
			극장명 : <%=theater.get("ti_name")%><br>
			극장주소 : <%=theater.get("ti_address")%><br>
			전화번호1 : <%=theater.get("ti_phone1")%><br>
			전화번호2 : <%=theater.get("ti_phone2")%><br>
			</div>
			<div class="text-center">
				<button class="btn btn-outline-success my-2 my-sm-0" onclick="goPage('/theater/update?ti_num=<%=theater.get("ti_num")%>')">수정하기</button>
				<button class="btn btn-outline-danger my-2 my-sm-0" onclick="doDelete()">삭제하기</button>
			</div>
		</div>
		<form id="deleteForm" action="/theater/delete" method="post">
			<input type="hidden" name="ti_num" value="<%=theater.get("ti_num")%>">
		</form>
<script>
function doDelete(){
	var isDelete = confirm("해당 극장 정보를 정말로 삭제 하시겠습니까?");
	if(isDelete){
		var deleteForm = document.querySelector('#deleteForm');
		deleteForm.submit();
	}
}
</script>
</body>
</html>