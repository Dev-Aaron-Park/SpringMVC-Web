<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board.write.do" name="writeForm" method="POST">
	<input name="token" value="${token }" type="hidden" readonly="readonly">
	<table id="writeTable">
		<tr>
			<td id="writeTitle" align="center">
				<input name="spb_title" placeholder="Title" maxlength="30">
			</td>
		</tr>
		<tr>
			<td id="writeContent" align="center">
				<textarea name="spb_content" placeholder="Content" maxlength="450"></textarea>
			</td>
		</tr>
		<tr>
			<td align="center">
				<button>Write</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>