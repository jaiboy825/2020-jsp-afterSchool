<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="menu.jsp"%>
<h2>사원 정보 추가하기</h2>
<br>
<br>
<form action="/InsertEmp" method="post">
	이름<input type="text" name="name"><br> 나이<input type="text"
		name="age"><br> 점수<input type="text" name="score"><br>

	<br> <br> <input type="submit" value="전송"> <input
		type="reset" value="취소">

</form>
<br>
<a href="index.jsp">처음으로</a>
</body>
</html>