<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>

	<div class="notice_box">

		<h3>삭제 정보 검색</h3>
		<br>
		<form>
			<label for="id"> 아이디 </label>
			<input type="text" name="id">
			<input type="submit" value="검색">
			<input type="hidden" name="job" value="delete">
		</form>
		<br><br>

		<h3>검색 정보 결과</h3>
	</div>

<%@ include file="../footer.jsp" %>