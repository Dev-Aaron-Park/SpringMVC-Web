<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" name="loginForm" 
		onsubmit="return checkLogin();" method="POST">
	<table id="loginTable">
		<tr>
			<th align="center" id="loginTitle">
				Login	
			</th>
		</tr>
		<tr>
			<td align="center">
				<input name="spm_id" placeholder="User ID">	
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="spm_pw" placeholder="User Password">	
			</td>
		</tr>
		<tr>
			<td align="center">
				<input name="spm_bcn" placeholder="Block Chain Number">	
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>Login</button>	
			</td>
		</tr>
	</table>
	</form>
	<div align="center" id="loginJoinBtn">
		<a href="join.go">Join</a>
	</div>	
</body>
</html>