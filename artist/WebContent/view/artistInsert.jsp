<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>

<br>
<h1 align="center">오디션 등록</h1>
<br>


<form action="/insert.do" method="post" >
	<table border="1" width="600px" class="insertTable">
		<tr>

			<td colspan="2" align="center">오디션 등록</td>
		</tr>
		<tr>
			<td align="center">참가번호</td>
			<td><input type="text" name="artist_id" id="artist_id" required></td>
		</tr>
		<tr>
			<td align="center">참가자명</td>
			<td><input type="text" name="artist_name" id="artist_name" required></td>
		</tr>
		<tr>
			<td align="center">생년월일</td>
			<td><input type="text" size="15" name="artist_birth" id="artist_birth" required>
				</td>
		</tr>
		<tr>
			<td align="center">성별</td>
			<td><input type="radio" value="F" name="artist_gender" checked>남<input
				type="radio" value="M" name="artist_gender">여</td>
		</tr>
		<tr>
			<td align="center">특기</td>
			<td><select name='talent' id="talent">
					<option value='0' selected>특기 선택</option>
					<option value='1'>보컬</option>
					<option value='2'>댄스</option>
					<option value='3'>랩</option>
			</select></td>
		</tr>
		<tr>
			<td align="center">소속사</td>
			<td><input type="text" name="agency" id="agency"></td>
		</tr>
		<tr>

			<td colspan="2" align="center"><input type="submit"
				value="오디션 등록" id="add"><input type="reset" value="다시 쓰기"></td>
		</tr>

	</table>
	<script type="text/javascript">
		add.addEventListener("click", function(){
			if(artist_id.value.trim() == ""){
				alert("참가번호가 비었습니다. 값을 넣어주세요");
				return;
			}
			if(artist_name.value.trim() == ""){
				alert("참가자명이 비었습니다. 값을 넣어주세요");
				return;
			}
			if(artist_birth.value.trim() == ""){
				alert("생년월일이 비었습니다. 값을 넣어주세요");
				return;
			}
			if(talent.value.trim() == "1"){
				alert(특기를 선택해주세요.");
				return;
			}
			if(agency.value.trim() == ""){
				alert("소속사가 비었습니다. 값을 넣어주세요");
				return;
			}
		});
	</script>
</form>

<%@ include file="/footer.jsp"%>