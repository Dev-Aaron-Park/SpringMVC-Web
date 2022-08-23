<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="profileCard">
		<tr>
			<td id="cardImg" align="center">
				<img src="resources/img/profilePhoto/${sessionScope.loginMember.spm_photo }"> 
			</td>
			<td id="cardId"align="center">
				${sessionScope.loginMember.spm_id }
			</td>
		</tr>
	</table>	
	<table id="userMenu">
		<tr>
			<td align="center">
				<a href="edit.go">회원정보</a>
			</td>
		</tr>
		<tr>
			<td align="center">
				<a href="logout.do">로그아웃</a>
			</td>
		</tr>
	</table>
</body>
</html>