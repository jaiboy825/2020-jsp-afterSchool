<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String type = request.getParameter("type");
if(type == null){
	return;
}
%>
<br>
<div>
	&copy; 양영디지털고등학교. <%=type %> 페이지 입니다.
</div>