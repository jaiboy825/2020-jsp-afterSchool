<%@page import="dao.HomeMemberDao"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
	Date joindate = Date.valueOf(LocalDate.now());
	HomeMemberDao dao = new HomeMemberDao();
	int next_num = dao.nextNum();
%>
<section>
	<div class="container">
		<form action="">
			<p class="title">홈쇼핑 회원 등록</p>
			<table>
				<tr>
					<th>회원번호(자동발생)</th>
					<td><input type="text" id="custno" value="<%=next_num %>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" id="name"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" id="phone"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" id="address"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" id="joindate" value="<%=joindate%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" id="grade"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" id="city"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="등록"> <a
						href="/view/memberList.jsp"> <input type="button" value="조회">
					</a></td>
				</tr>
			</table>
		</form>
	</div>
</section>

<%@ include file="/footer.jsp"%>