<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" name="joinForm" 
	method="POST" enctype="Multipart/form-data"
	onsubmit="return checkJoin();">
	<table id="joinArea">
		<tr>
			<th id="joinTitle">
				Get Started
			</th>
		</tr>
		<tr>
			<td align="center">
				<input id="memberJoinID" name="joinId" class="joinInput" placeholder="ID" autofocus="autofocus" autocomplete="off" maxlength="10">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="joinPw" class="joinInput" placeholder="Password" type="password" maxlength="10">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="joinPwc" class="joinInput" placeholder="Password Check" type="password" maxlength="10">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input id="memberJoinBCN" style="border:red solid 3px; font-size:9pt; cursor:pointer;" name="joinBcn" class="joinInput" placeholder="Block Chain No." maxlength="70" autocomplete="off" style="font-size:6pt"
				value="0x95b67ef448e248996a8cfeec200e4f5b423e2898ecc007d4b5b5b7b96fd8bbbe" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="joinName" class="joinInput" placeholder="Name" maxlength="10" autocomplete="off">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="joinBirth1" class="birthInput1" placeholder="Birthday" maxlength="6" autocomplete="off"> - <input name="joinBirth2" maxlength="1" autocomplete="off" class="birthInput2" placeholder="X"> XXXXXX
			</td>
		</tr>
		<tr>
			<td align="center">
				<input id="memberJoinAddr1" name="joinAddr1" class="joinInput" placeholder="우편번호" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input id="memberJoinAddr2" name="joinAddr2" class="joinInput" placeholder="기본주소" readonly="readonly">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="joinAddr3" class="joinInput" placeholder="상세주소">
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="joinPhoto" type="file" style="margin-top: 5px">
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>JOIN</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>