<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="edit.do" name="editForm" 
	method="POST" enctype="Multipart/form-data"
	onsubmit="return checkEdit();">
	<table id="joinArea">
		<tr>
			<th id="joinTitle">
				Get Edit
			</th>
		</tr>
		<tr>
			<td align="center">
				<input value=${sessionScope.loginMember.spm_id } name="editId" class="joinInput" placeholder="ID" autofocus="autofocus" autocomplete="off" maxlength="10" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input value=${sessionScope.loginMember.spm_pw } name="editPw" class="joinInput" placeholder="Password" type="password" maxlength="10">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="editPwc" class="joinInput" placeholder="Password Check" type="password" maxlength="10">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="editBcn" class="joinInput" placeholder="Block Chain No." maxlength="70" autocomplete="off" style="font-size:6pt"
				value="0x95b67ef448e248996a8cfeec200e4f5b423e2898ecc007d4b5b5b7b96fd8bbbe" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input value=${sessionScope.loginMember.spm_name } name="editName" class="joinInput" placeholder="Name" maxlength="10" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input value=${birth } name="editBirth1" class="birthInput1" placeholder="Birthday" maxlength="6" autocomplete="off"> - <input name="editBirth2" maxlength="1" autocomplete="off" class="birthInput2" placeholder="X"> XXXXXX
			</td>
		</tr>
		<tr>
			<td align="center">
				<input value="${addr1 }" name="editAddr1" class="joinInput" placeholder="우편번호">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input value="${addr2 }" name="editAddr2" class="joinInput" placeholder="기본주소">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input value="${addr3 }" name="editAddr3" class="joinInput" placeholder="상세주소">
			</td>
		</tr>
		<tr>
			<td align="center">
				<img src="resources/img/profilePhoto/${sessionScope.loginMember.spm_photo }" width="80px" style="border-radius: 4px">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="editPhoto" type="file" style="margin-top: 5px">
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>JOIN</button>
			</td>
		</tr>
		<tr>
			<td align="center" id="deleteBtn">
				<a onclick="memberDeleteCheck();">회원 탈퇴</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>