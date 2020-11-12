<%@page import="vo.ArtistVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ArtistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
	ArtistDAO dao = new ArtistDAO();
	ArrayList<ArtistVO> list = dao.getMemberList();
%>

<br>
<h1 align="center">참가자목록조회</h1>
<br>
<table border="1" align="center">
	<tr>
		<th>참가번호</th>
		<th>참가자명</th>
		<th>생년월일</th>
		<th>성별</th>
		<th>특기</th>
		<th>소속사</th>

	</tr>
	<%
		if (list != null) {
			for (ArtistVO a : list) {
	%>


	<tr>
		<th><%=a.getArtist_id()%></th>
		<th><%=a.getArtist_name()%></th>
		<%
			String birth = a.getArtist_birth().substring(0, 4) + "년" + a.getArtist_birth().substring(4, 6) + "월"
							+ a.getArtist_birth().substring(6) + "일";
		%>
		<th><%=birth%></th>
		<%if (a.getArtist_gender().equals("F")) {%>
		<th>남성</th>
		<%} else {%>
		<th>여성</th>
		<%}%>
		<%
			if (a.getTalent().equals("1")) {
		%>
		<th>보컬</th>
		<%
			} else if (a.getTalent().equals("2")) {
		%>
		<th>댄스</th>

		<%
			} else {
		%>
		<th>랩</th>

		<%
			}
		%>
		<th><%=a.getAgency()%></th>

	</tr>


	<%
		}
		}
	%>

</table>



<%@ include file="/footer.jsp"%>