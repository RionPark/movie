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
<%
Map<String, String> user = (Map<String, String>)session.getAttribute("user");
%>
<script>
   function validation(id, min, max, msg) {
      var obj = document.querySelector(id);
      if ((min && obj.value.trim().length < min)
            || (max && obj.value.trim().length > max)) {
         alert(msg);
         obj.value = '';
         obj.focus();
         return false;
      }
      return true;
   }
   function check() {
      if (!validation('#name', 3, 10, '이름을 다시 입력해주세요.')) {
         return false;
      }
      if (!validation('#id', 4, 10, '아이디를 다시 입력해주세요.')) {
         return false;
      }
      if (!validation('#pwd', 6, 20, '비밀번호를 다시 입력해주세요.')) {
         return false;
      }
      var pwd2 = document.querySelector('#pwd2');
      if (pwd.value != pwd2.value) {
         alert('비밀번호를 다시 입력해주세요.');
         pwd2.value = "";
         pwd2.focus();
         return false;
      }
      if (!validation('#address', 10, 100, '주소를 다시 입력해주세요.')) {
         return false;
      }
      if (!validation('#phone2', 7, 10, '연락처를 다시 입력해주세요.')) {
         return false;
      }
      var phone2 = document.querySelector('#phone2');
      if (isNaN(phone2.value.trim())) {
         alert('연락처를 다시 입력해주세요.');
         phone2.value = "";
         phone2.focus();
         return false;
      }
      if (!validation('#hint', 1, 10, '질문을 다시 선택해주세요.')) {
         return false;
      }
      if (!validation('#answer', 2, 10, '답변을 다시 선택해주세요.')) {
         return false;
      }
      var genres = document.querySelectorAll('[name=ui_genre]:checked');
      if(genres.length==0){
         alert('좋아하는 장르를 1개 이상 선택해주세요.');
         document.querySelector('#genre1').focus();
         return false;
      }
      return true;
   }
   function goPage(url){
      location.href= url;
   }
</script>
<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
   <div class="container register">
      <div class="row">
         <div class="col-md-3 register-left">
            <img src="https://image.ibb.co/n7oTvU/logo_white.png" alt="" />
            <h3><%=user.get("ui_name")%>님<br> 안녕하세요</h3>
         </div>
         <div class="col-md-9 register-right">
            <ul class="nav nav-tabs nav-justified" id="myTab" role="tablist">

            </ul>
            <form action="/user/insert" method="post" onsubmit="return check()">
               <div class="tab-content" id="myTabContent">
                  <div class="tab-pane fade show active" id="home" role="tabpanel"
                     aria-labelledby="home-tab">
                     <h3 class="register-heading">회원정보수정</h3>
                     <div class="row register-form">
                        <div class="col-md-6">
                           <div class="form-group">
                              <input type="text" class="form-control" placeholder="이름"
                                 name="ui_name" id="name" value="<%=user.get("ui_name") %>" readonly/>
                           </div>
                           <div class="form-group">
                              <input type="text" class="form-control" placeholder="아이디 "
                                 name="ui_id" id="id" value="<%=user.get("ui_id") %>" readonly/>
                           </div>
                           <div class="form-group">
                              <input type="password" class="form-control" placeholder="비밀번호"
                                 name="ui_pwd" id="pwd" />
                           </div>
                           <div class="form-group">
                              <input type="password" class="form-control"
                                 placeholder="비밀번호 확인" id="pwd2" />
                           </div>
                           <div class="form-group">
                           <input type="text" class="form-control" placeholder="주소"
                                 name="ui_address" id="address" value="<%=user.get("ui_address") %>">
                           </div>
                           <div class="form-group">
                              <label for="genre1" style="float:left">스릴러</label>
                              <input type="checkbox" name="ui_genre" id="genre1" value="스릴러" <%=user.get("ui_genre").contains("스릴러")?"checked":""%>>
                              <label for="genre2">반전</label>  
                              <input type="checkbox" name="ui_genre" id="genre2" value="반전" <%=user.get("ui_genre").contains("반전")?"checked":""%>>
                              <label for="genre3">추리</label>  
                              <input type="checkbox" name="ui_genre" id="genre3" value="추리" <%=user.get("ui_genre").contains("추리")?"checked":""%>>
                              <label for="genre4">미스터리</label>  
                              <input type="checkbox" name="ui_genre" id="genre4" value="미스터리" <%=user.get("ui_genre").contains("미스터리")?"checked":""%>>
                           </div>
                        </div>
                        <div class="col-md-6">
                           <div class="form-group">
                              <input type="email" class="form-control" placeholder="이메일"
                                 name="ui_email" id="email" value="<%=user.get("ui_email") %>" />
                           </div>
                           <div class="form-group">
                              <select class="form-control" style="width: 74px; float: left"
                                 name="ui_phone1">
                                 <option value="010" <%="010".equals(user.get("ui_phone1"))?"selected":""%>>010</option>
                                 <option value="011" <%="011".equals(user.get("ui_phone1"))?"selected":""%>>011</option>
                                 <option value="018" <%="018".equals(user.get("ui_phone1"))?"selected":""%>>018</option>
                                 <option value="019" <%="019".equals(user.get("ui_phone1"))?"selected":""%>>019</option>
                              </select><input type="text" minlength="7" maxlength="10" class="form-control" placeholder="휴대폰번호" name="ui_phone2" id="phone2" style="width:215px;" value="<%=user.get("ui_phone2") %>"/>
                           </div>
                           <div class="form-group">
                              <select class="form-control" name="ui_hint" id="hint">
                                 <option class="hidden" selected>암호힌트를 선택하세요</option>
                                 <option value="birthday" <%="birthday".equals(user.get("ui_hint"))?"selected":""%>>생일이 언제입니까?</option>
                                 <option value="oldPhone" <%="oldPhone".equals(user.get("ui_hint"))?"selected":""%>>이전 연락처는 무엇입니까?</option>
                                 <option value="petName" <%="petName".equals(user.get("ui_hint"))?"selected":""%>>애완동물 이름이 무엇입니까?</option>
                              </select>
                           </div>
                           <div class="form-group">
                              <input type="text" class="form-control"
                                 placeholder="답변을 입력하세요" name="ui_answer" id="answer" value="<%=user.get("ui_answer")%>"/>
                           </div>
                           <input type="submit" class="btnRegister" value="정보수정" />
                        </div>
                     </div>
                  </div>
               </div>
            </form>
         </div>
      </div>

   </div>

</body>
</html>