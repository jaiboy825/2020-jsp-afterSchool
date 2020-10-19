<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	요청 처리과정에서 에러가 발생했습니다. <br>
	error type : <%= exception.getClass().getName() %><br>
	error msg : <%= exception.getMessage() %>
</body>
</html>