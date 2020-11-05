<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>

	<div class="notice_box">
<%
	String error = (String)request.getAttribute("error");
if (error != null){
	out.print("<script>alert('"+ error +"'); history.go(-1);</script>");
}
%>
		<h3>회원 정보 검색</h3>
		<br>
		<form action="/dev/memberSearch.do" method="post">
			<label for="id"> 아이디 </label>
			<input type="text" name="id">
			<input type="submit" value="검색">
			<input type="hidden" name="job" value="search">
		</form>
	</div>

<%@ include file="../footer.jsp" %>