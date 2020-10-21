<%@page import="vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<h2>사원정보 출력</h2>
<%
	request.setCharacterEncoding("utf-8");
	List<EmpVO> list = (List<EmpVO>) request.getAttribute("emp_data");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>점수</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<%
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				EmpVO empVo = new EmpVO();
				empVo = list.get(i);
	%>
	<tr>
		<td><%=empVo.getNum()%></td>
		<td><%=empVo.getName()%></td>
		<td><%=empVo.getAge()%></td>
		<td><%=empVo.getScore()%></td>
		<td><a href="/updateEmp?num=<%=empVo.getNum()%>">수정하기</a></td>
		<td><a href="/deleteEmp?num=<%=empVo.getNum()%>">삭제하기</a></td>
	</tr>
	<%
		}
		}
	%>
</table>
</body>
</html>