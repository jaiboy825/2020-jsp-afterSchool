<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp"%>

<div class="notice_box">
	<%
		String id = (String) request.getAttribute("id");
	%>
	<h3><%=id%>님의 정보 수정이 완료되었습니다.</h3>
</div>

<%@ include file="../footer.jsp"%>