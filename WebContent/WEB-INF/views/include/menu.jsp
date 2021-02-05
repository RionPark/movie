<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Map<String,String> user = (Map<String,String>)session.getAttribute("user");
%> 
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="/">SERFLIX</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
           <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">영화</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">영화차트</a>
              <a class="dropdown-item" href="#">영화찾기</a>
            </div>
          </li> <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">예매</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">빠른예매</a>
              <a class="dropdown-item" href="#">상영시간표</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">극장</a>
            <div class="dropdown-menu" aria-labelledby="dropdown01">
              <a class="dropdown-item" href="#">2D</a>
              <a class="dropdown-item" href="#">3D</a>
              <a class="dropdown-item" href="#">4D</a>
            </div>
          </li>
          <li class="nav-item">
<%
if(user==null){
%>
          	<a class="nav-link" href="/views/user/login">로그인</a>
<%
}else{
%>
			<a class="nav-link" href=""><%=user.get("ui_name")%>님 정보 보기</a>
			
          </li>
          <li class="nav-item">
			<a class="nav-link" href="/user/logout">로그아웃</a>
		  </li>
<%
}
%>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="검색어.." aria-label="검색어..">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
        </form>
      </div>
    </nav>