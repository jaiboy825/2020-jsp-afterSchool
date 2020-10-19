<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="/error/viewErrorMsg.jsp" %> --%>
<% 
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
if(id != null && id.equals("admin")){
	response.sendRedirect("/admin.jsp");
}else{
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 상세 화면입니다.</h2>
	아이디 :
	<%=request.getParameter("id")%>
	<br> 패스워드 :
	<%=request.getParameter("password")%>
	<br> 이름 :
	<%=request.getParameter("name")%>
	<br> 연락처 :
	<%=request.getParameter("phone")%>
	<br>
	error : <%= request.getParameter("error").toUpperCase() %>

	<form action="/index.html">
		<input type="submit" value="메인으로">
	</form>
</body>
</html>
<%
}
%>