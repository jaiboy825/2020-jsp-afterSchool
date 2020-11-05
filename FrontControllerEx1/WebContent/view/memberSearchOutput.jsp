<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp"%>

<div class="notice_box">

	<h3>검색 결과</h3>
	<br>
	<%
		MemberVO member = (MemberVO) request.getAttribute("member");
		if (member == null) {
	%>
	<h3>등록된 회원 정보가 없습니다.</h3>
	<%
		}else{
	%>
		<h3><%=member.getId() %> / <%=member.getPasswd() %> / <%=member.getName() %> / <%=member.getMail() %></h3>
	<%
		}
	%>

</div>

<%@ include file="../footer.jsp"%>