<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 프로젝트</title>
<style>
	* {
		box-sizing:border-box;
		margin:0;
		padding:0;
	}
	body {
		min-height:100vh;
		display:grid;
		grid-template-columns:1fr;
		grid-template-rows:50px 1fr 50px;
		grid-gap:20px;
		
	}
	nav{ width: 100%; height: 50px; background-color: #eee; padding: 0px 20px; margin-bottom: 40px;}
	#menu { 
		height:100%; list-style: none; width:100%;
		display:flex;
		align-items:center;
		justify-content:space-between;
	}
	#menu > li { 
		flex:1;
		transition: all 0.4s;
		
		height:100%;
	}
	#menu>li:hover{background-color: #4298cc; color:#FFF;}
	li > a{
	 text-decoration: none; color: inherit;
	 
	 width:100%;
	 height:100%;
	 display:flex;
		align-items:center;
		justify-content:center;
	} 
	.clear { clear: both; position: inherit; }

	.container{
		width: 100%; margin: 0 auto; 
	}
	
	.notice_box{
		width: 80%; min-height: 100px; padding: 30px; margin: 0 auto;
		display: flex; flex-direction: column;
		background-color: #eee;
	}
	.notice_box > * { align-items: center; }
	.notice_box input { margin-bottom: 10px; }
	p{
		color: green; font-weight : bold; font-size: 30px;
	}	
	
	footer{
		
	    width: 100%; padding: 5px 20px;
	    background-color: #4298cc; color: #FFFFFF;
	    overflow: hidden;
	}
	
	footer p{margin: 0 auto; color:#FFFFFF; text-align: center; font-size: 15px; line-height: 50px;}
	
</style>
</head>
<body>
    <nav>
        <ul id="menu">
            <li><a href="/dev/index.jsp">처음화면</a></li>
            <li><a href="/dev/view/memberInsert.jsp">회원가입</a></li>
            <li><a href="/dev/view/memberSearch.jsp">회원검색</a></li>
            <li><a href="/dev/view/memberUpdate.jsp">회원수정</a></li>
            <li><a href="/dev/view/memberDelete.jsp">회원삭제</a></li>
            <li><a href="#">모든회원보기</a></li>
        </ul>
    </nav>
    

	<div class="container">
