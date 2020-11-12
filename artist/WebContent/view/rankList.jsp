<%@page import="vo.RankVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ArtistDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<br>
<h1 align="center">참가자 등수 조회</h1>
<br>
<%
	ArtistDAO dao = new ArtistDAO();
	ArrayList<RankVO> list = dao.getRankList();
%>
<table border="1">

	<tr>
		<th>참가번호</th>
		<th>참가자명</th>
		<th>점수</th>
		<th>평균</th>
		<th>순위</th>
	</tr>
	<%
		if (list != null) {
			for (RankVO r : list) {
	%>
	<tr>
		<th><%=r.getArtist_id()%></th>
		<th><%=r.getArtist_name()%></th>
		<th><%=r.getPoint()%></th>
		<th><%=r.getAvg()%></th>
		<th><%=r.getRank()%></th>
	</tr>
	<%
		}
		}
	%>
</table>

<%@ include file="/footer.jsp"%>