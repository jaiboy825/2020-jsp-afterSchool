<%@page import="vo.MemberVO"%>
<%@page import="dao.HomeMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
	int custno = Integer.parseInt(request.getParameter("custNo"));
	HomeMemberDao dao = new HomeMemberDao();
	MemberVO vo = dao.findUser(custno);
	if (vo != null) {
%>

<section>
	<div class="container">
		<form action="/memberUpdate.do" method="post">
			<p class="title">홈쇼핑 회원 등록</p>
			<table>
				<tr>
					<th>회원번호</th>
					<td><input type="text" name="custno"
						value="<%=vo.getCustno()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>회원성명</th>
					<td><input type="text" name="custname" id="custname" required
						value="<%=vo.getCustname()%>"></td>
				</tr>
				<tr>
					<th>회원전화</th>
					<td><input type="text" name="phone" id="phone" required
						value="<%=vo.getPhone()%>"></td>
				</tr>
				<tr>
					<th>회원주소</th>
					<td><input type="text" name="address" id="address" required
						value="<%=vo.getAddress()%>"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="text" name="joindate"
						value="<%=vo.getJoindate()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<th>고객등급[A:VIP,B:일반,C:직원]</th>
					<td><input type="text" name="grade" id="grade" required
						value="<%=vo.getGrade()%>"></td>
				</tr>
				<tr>
					<th>도시코드</th>
					<td><input type="text" name="city" id="city" required
						value="<%=vo.getCity()%>"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" id="add">
						<a href="/memberList.do"> <input type="button"
							value="조회">
					</a></td>
				</tr>
			</table>
			<script type="text/javascript">
				add.addEventListener("click", function(){
					if(custname.value.trim() == ""){
						alert("회원성명이 입력되지 않았습니다");
						return
					} 
					if(phone.value.trim() == ""){
						alert("전화번호가 입력되지 않았습니다");
						return
					}
					if(address.value.trim() == ""){
						alert("주소가 입력되지 않았습니다");
						return
					}
					if(grade.value.trim() == ""){
						alert("등급이 입력되지 않았습니다");
						return
					}
					if(city.value.trim() == ""){
						alert("도시코드가 입력되지 않았습니다");
						return
					}
				});
			</script>
		</form>
	</div>

</section>
<%
	}
%>
<%@ include file="/footer.jsp"%>