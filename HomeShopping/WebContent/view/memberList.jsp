<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("list");
	String grade = "";
%>
<section>
	<div class="container">
		<p class="title">회원목록조회/수정</p>
		<table border="2">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						MemberVO vo = new MemberVO();
						vo = list.get(i);
			%>
			<tr>
				<td><a href="/view/memberUpdate.jsp?custNo=<%=vo.getCustno()%>"><%=vo.getCustno()%></a></td>
				<td><%=vo.getCustname()%></td>
				<td><%=vo.getPhone()%></td>
				<td><%=vo.getAddress()%></td>
				<td><%=vo.getJoindate()%></td>
				<%
					switch (vo.getGrade()) {

							case "A":
								grade = "VIP";
								break;

							case "B":
								grade = "일반";
								break;

							case "C":
								grade = "직원";
								break;

							}
				%>
				<td><%=grade%></td>
				<td><%=vo.getCity()%></td>
			</tr>
			<%
				}
				}
			%>
		</table>

	</div>

</section>

<%@ include file="/footer.jsp"%>