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
	<form class="form-signin" method="post" action="/user/login">
		<div class="text-center mb-4">
			<h1 class="h3 mb-3 font-weight-normal">로그인</h1>
			<p>
				저희
				<code style="font-size: 18px">
					<b>SERVLIX</b>
				</code>
				에 오신것을 환영합니다.<br>가입을 하시려면 <a href="/views/user/join">회원가입</a>을
				클릭해주세요.
			</p>
		</div>
		<div class="form-label-group">
			<input type="text" id="ui_id" class="form-control" placeholder="아이디"
				required autofocus name="ui_id"> <label for="ui_id">회원
				아이디</label>
		</div>
		<div class="form-label-group">
			<input type="password" id="ui_pwd" class="form-control"
				placeholder="비밀번호" required name="ui_pwd"> <label
				for="ui_pwd">비밀번호</label>
		</div>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				아이디 기억하기
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		<p class="mt-5 mb-3 text-muted text-center">&copy; 2021</p>
	</form>
</body>
</html>