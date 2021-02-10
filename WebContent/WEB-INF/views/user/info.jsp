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
Map<String,String> user = (Map<String,String>)session.getAttribute("user");
Map<String,String> rMap = (Map<String,String>)request.getAttribute("rMap");
%>
	<div class="container">
		<div><img src="/upload/<%=user.get("ui_img")%>" class="rounded-circle" style="width:100px;float:left"><h3><%=user.get("ui_name")%>님, 안녕하세요.</h3></div>
		<div style="clear:both">주소 : <%=user.get("ui_address")%></div>
		<div>E-mail : <%=user.get("ui_email")%></div>
		<div>휴대폰번호 : <%=user.get("ui_phone1")%>-<%=user.get("ui_phone2")%></div>
		<div>좋아하시는 장르 : <%=user.get("ui_genre")%></div>
		<button class="btn btn-outline-success my-2 my-sm-0" onclick="goPage('/views/user/update')">수정하기</button>
		<button class="btn btn-outline-danger my-2 my-sm-0" onclick="doShow(this)">탈퇴하기</button>
		<div id="pass" style="visibility:hidden">
			<form method="post" action="/user/delete">
				<input type="password" name="ui_pwd" placeholder="비밀번호"><button>탈퇴</button>

			</form>
		</div>
<%
if(rMap!=null && rMap.get("msg")!=null){
%>
				<div><%=rMap.get("msg")%></div>
<%
}
%>
	</div>
<script>
function goPage(url){
	location.href=url;
}
function doShow(btn){
	var obj = document.querySelector('#pass');
	if(obj.style.visibility=='hidden'){
		obj.style.visibility = 'visible';
		btn.innerText = '탈퇴취소';
	}else{
		obj.style.visibility = 'hidden';
		btn.innerText = '탈퇴하기';
	}
}
</script>
</body>
</html>