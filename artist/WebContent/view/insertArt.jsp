<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<!-- section -->
<section>

	<div class="container">
		<form action="/artInsert.do" method="POST">
			<table border="2">
				<tr>
					<th colspan="2">오디션 등록</th>
				</tr>
				<tr>
					<th>참가번호</th>
					<td><input type="text" name="aid"></td>
				</tr>
				<tr>
					<th>참가자명</th>
					<td><input type="text" name="aname"></td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td><input type="text" name="year"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="FM" value="M">남 <input
						type="radio" name="FM" value="F">여</td>
				</tr>
				<tr>
					<th>특기</th>
					<td><select name="talent">
							<option value="1">보컬</option>
							<option value="2">댄스</option>
							<option value="3">랩</option>
					</select></td>
				</tr>
				<tr>
					<th>소속사</th>
					<td><input type="text" name="agency" required></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="오디션 등록"> <input
						type="reset" value="다시 쓰기"></td>
				</tr>
			</table>
		</form>
	</div>
</section>

<%@ include file="/footer.jsp"%>