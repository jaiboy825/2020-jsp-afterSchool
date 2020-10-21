<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	p{
		color: green; font-weight: bold; font-size: 30px;
	}
	
	body{
		margin:0; padding: 0;
	}
	#menu{
		height: 100px; background-color: #eee;
	}
	
	#menu a{
		display: inline-block; margin-top: 40px; text-decoration: none; font: bold; width: 200px; text-align: center;
	}
	#login_info{
		font-size : 12px;
	}

</style>
</head>
<body>
	<div id="menu">
		<a href="/index.jsp"> 처음화면 </a>
		<a href="/insert.jsp"> 사원정보 등록 </a>
		<a href="/listEmp"> 사원정보 목록 </a>
		<a href="/logout"> 로그아웃 </a>
		
		<span id="login_info">
			<b>관리자</b>님이 로그인하였습니다.
		</span>
	</div>