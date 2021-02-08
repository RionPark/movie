<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
List<Map<String,String>> addrList = new ArrayList<>();
Map<String,String> addr1 = new HashMap<>();
addr1.put("번호","1");
addr1.put("지역","서울");
addr1.put("인구수","20000000");
addrList.add(addr1);
Map<String,String> addr2 = new HashMap<>();
addr2.put("번호","2");
addr2.put("지역","경기");
addr2.put("인구수","10000000");
addrList.add(addr2);
%>
<table border="1">
    <tr>
        <th>번호</th>
        <th>지역</th>
        <th>인구수</th>
    </tr>
    <%
    	int sum = 0;
        for(Map<String,String> addr : addrList){
           sum += Integer.parseInt(addr.get("인구수"));
    %>
    <tr>
        <td><%=addr.get("번호")%></td>
        <td><%=addr.get("지역")%></td>
        <td><%=addr.get("인구수")%></td>
    </tr>
    <%
        }
    %>
    <tr>
    	<td colspan="3">총 인구수 : <%=sum %></td>
    </tr>
</table>
</body>
</html>