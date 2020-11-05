<%@page import="vo.MemberVO"%>
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

		<h3>수정 정보 검색</h3>
		<br>
		<form action="/dev/memberSearch.do" method="post">
			<label for="id"> 아이디 </label>
			<input type="text" name="id">
			<input type="submit" value="검색">
			<input type="hidden" name="job" value="update">
		</form>

		<br><br>
		<%
		MemberVO member = (MemberVO)request.getAttribute("member");
					if(member != null){
						
		%>		
		<h3>회원 정보 수정</h3>
		<form action="/dev/memberUpdate.do" method="post">
			<label for="id">아이디</label>
			<input type="text" name="id" value="<%=member.getId()%>" readonly>
			<br>
			<label for="passwd">비밀번호</label>
			<input type="text" name="passwd" value="<%=member.getPasswd() %>" >
			<br>
			<label for="name">이름</label>
			<input type="text" name="name" value="<%=member.getName() %>" >
			<br>
			<label for="mail">메일</label>
			<input type="text" name="mail" value="<%=member.getMail() %>" >
			<br>
			<input type="submit" value="수정">
		</form>
	</div>
<%
					}
%>
<%@ include file="../footer.jsp" %>