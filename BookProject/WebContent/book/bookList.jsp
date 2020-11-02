<%@page import="vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/menu.jsp"%>
<%
	ArrayList<BookVO> list = (ArrayList<BookVO>) request.getAttribute("booklist");
%>
<h1>도서 전체 확인</h1>
<table border="1" align="center" width="800px">
	<tr>
		<td>도서코드</td>
		<td>책이름</td>
		<td>저자</td>
		<td>출판사</td>
		<td>가격</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<%
	if(list != null){
		for(BookVO data : list){
			
	%>
	<tr>
	<td><%=data.getIsBn() %></td>
	<td><%=data.getTitle() %></td>
	<td><%=data.getAuthor() %></td>
	<td><%=data.getCompany() %></td>
	<td><%=data.getPrice() %></td>
	<td><a href="/">수정</a></td>
	<td><a href="/">삭제</a></td>
	</tr>
	<%
		}		
	}
	
	%>
</table>
<%@ include file="/footer.jsp"%>