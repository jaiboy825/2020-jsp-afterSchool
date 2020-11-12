<%@page import="vo.MentoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ArtistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
	ArtistDAO dao = new ArtistDAO();
	ArrayList<MentoVO> list = dao.getMentoList();
%>

<br>
<h1 align="center">멘토 점수 조회</h1>
<br>

<table border="1" align="center">
	<tr>
		<th>참가번호</th>
		<th>참가자명</th>
		<th>생년월일</th>
		<th>점수</th>
		<th>등급</th>
		<th>멘토</th>

	</tr>
	<%
		if (list != null) {
			for (MentoVO m : list) {
	%>


	<tr>
		<th><%=m.getArtist_id()%></th>
		<th><%=m.getArtist_name()%></th>
		<%
		String birth= m.getArtist_birth().substring(0, 4)+"년"+m.getArtist_birth().substring(4, 6)+"월"+m.getArtist_birth().substring(6)+"일";
		
		%>
		<th><%=birth%></th>
		<th><%=m.getPoint()%></th>
		<%
			int p = m.getPoint();
					if (p >= 90) {
		%>
		<th>A</th>

		<%
			} else if (p >= 80) {
		%>
		<th>B</th>

		<%
			} else if (p >= 70) {
		%>
		<th>C</th>

		<%
			} else if (p >= 60) {
		%>
		<th>D</th>

		<%
			} else {
		%>
		<th>F</th>

		<%
			}
		%>
		<th><%=m.getMento_name()%></th>
	</tr>


	<%
		}
		}
	%>

</table>





<%@ include file="/footer.jsp"%>