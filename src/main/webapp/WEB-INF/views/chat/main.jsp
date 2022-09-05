<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://192.168.1.3:5244/socket.io/socket.io.js"></script>
</head>
<body>
	<table id="chatArea">
		<tr>
			<td id="chatShowArea" align="center">
				<textarea id="chatTextArea" readonly="readonly"></textarea>
			</td>
		</tr>
		<tr>
			<td id="chatInputArea" align="center">
				<input id="chatID" value="${sessionScope.loginMember.spm_id }" type="hidden" readonly="readonly">
				<input id="chatInput" autocomplete="off" placeholder="Write Message">
				<button>SEND</button>
			</td>
		</tr>
	</table>
</body>
</html>