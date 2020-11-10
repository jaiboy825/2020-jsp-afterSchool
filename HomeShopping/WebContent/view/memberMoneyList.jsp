<%@page import="vo.MemberMoneyVO"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
	ArrayList<MemberMoneyVO> list = (ArrayList<MemberMoneyVO>) request.getAttribute("list");
%>
<section>
	<div class="container">
		<p class="title">회원목록조회/수정</p>
		<table border="2">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						MemberMoneyVO vo = new MemberMoneyVO();
						vo = list.get(i);
			%>
			<tr>
				<td><%=vo.getCustNo()%></td>
				<td><%=vo.getCustName()%></td>
				<td><%=vo.getGrade()%></td>
				<td><%=vo.getTotal()%></td>
			</tr>
			<%
				}
				}
			%>
		</table>

	</div>

</section>

<%@ include file="/footer.jsp"%>