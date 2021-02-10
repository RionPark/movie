<%@page import="java.util.List"%>
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
List<Map<String,String>> theaterList = (List<Map<String,String>>)request.getAttribute("theaterList");
%>
<div class="container">
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>영화관</th>
				<th>주소</th>
				<th>전화번호1</th>
				<th>전화번호2</th>
			</tr>
		</thead>
		<tbody>
<%
for(Map<String,String> theater:theaterList){
%>
			<tr style="cursor:pointer" onclick="goView(<%=theater.get("ti_num") %>)">
				<td><%=theater.get("ti_num") %></td>
				<td><%=theater.get("ti_name") %></td>
				<td><%=theater.get("ti_address") %></td>
				<td><%=theater.get("ti_phone1") %></td>
				<td><%=theater.get("ti_phone2") %></td>
			</tr>
<%
}
%>
		</tbody>
	</table>
</div>
<script>
function goView(tiNum){
	location.href='/theater/view?ti_num=' + tiNum;
}
</script>
</body>
</html>