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
    <main role="main" class="container">
      <div class="starter-template">
        <h1>로그인</h1>
        <p class="lead">
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="text" name="pwd"><br>
			<button>로그인</button>
        </p>
      </div>
    </main>
</body>
</html>