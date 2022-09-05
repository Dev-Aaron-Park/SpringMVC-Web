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
	<table id="canvasTable">
		<tr>
			<td id="canvasDrawArea">
				<canvas id="canvasDrawPaper" width="930px" height="600px"></canvas>
			</td>
		</tr>
		<tr>
			<td id="canvasToolArea">
				<input id="canvasColor" value="FFFFFF">
			</td>
		</tr>
	</table>
</body>
</html>