<%@page import="vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<h2>사원정보 수정</h2>
<form method="post" action="/updateEmp">
	<%
		request.setCharacterEncoding("utf-8");
		EmpVO empVo = (EmpVO) request.getAttribute("select_data");

		if (empVo != null) {

	%>
	사원번호 : <input type="text" name="num" value="<%=empVo.getNum() %>" readonly="readonly"> <br>
	이름 : <input type="text" name="name" value="<%=empVo.getName() %>" readonly="readonly"> <br>
	나이 : <input type="text" name="age" value="<%=empVo.getAge() %>"> <br>
	점수 : <input type="text" name="score" value="<%=empVo.getScore() %>">  <br>
	<%
		
		}
	%>
	<br> <br> 
	<input type="submit" value="수정"> 
	<input type="reset" value="취소">
</form>
</body>
</html>