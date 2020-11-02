<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	padding: 0;
}

#menu {
	height: 100px;
	background-color: #eee;
	margin: 0 auto;
	margin-bottom: 50px;
	padding: 0 100px;
}

#menu a {
	display: inline-block;
	line-height: 100px;
	text-decoration: none;
	font: bold;
	width: 100px;
	text-align: center;
}

#login_info {
	font-size: 12px;
}

.container {
	width: 100%;
	margin: 0 auto;
	text-align: center;
}

p {
	color: green;
	font-weight: bold;
	font-size: 30px;
}
</style>

</head>
<body>

	<div id="menu">
		<a href="/index.jsp">처음화면</a>
		<%
			MemberVO vo = (MemberVO) session.getAttribute("loginOk");
			if (vo == null) {
		%>
		<a href="/login/login.jsp">로그인화면</a>
		<%
			} else {
		%>
		<a href="/book/bookInsert.jsp">도서등록</a> <a href="/listBook">도서목록</a> <a
			href="/logout">로그아웃</a> <span id="login_info"><%=vo.getUserId()%>님이
			로그인하였습니다.
		</span>
		<%
			}
		%>
	</div>
	<div class="container">