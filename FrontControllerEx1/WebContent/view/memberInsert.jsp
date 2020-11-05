<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>
<%
	String error = (String)request.getAttribute("error");
if (error != null){
	out.print("<script>alert('"+ error +"'); history.go(-1);</script>");
}
%>
	<div class="notice_box">

		<h3>회원 가입</h3>
		<br>
		<form action="/dev/memberInsert.do" method="post">
			<label for="id"> 아이디 </label> <input type="text" name="id"> <br>
			<label for="passwd"> 비밀번호 </label> <input type="password" name="passwd"> <br>
			<label for="name"> 이름 </label> <input type="text" name="name"> <br>
			<label for="mail"> 메일 </label> <input type="text" name="mail"> <br>
			<input type="submit" value="추가"> 
			<input type="reset" value="취소"> 
		</form>
	</div>

<%@ include file="../footer.jsp" %>