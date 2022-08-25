<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to My WebSite</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member/join.css">
<link rel="stylesheet" href="resources/css/member/login.css">
<link rel="stylesheet" href="resources/css/member/afterLogin.css">
<link rel="stylesheet" href="resources/css/member/edit.css">
<link rel="stylesheet" href="resources/css/board/main.css">
<link rel="stylesheet" href="resources/css/board/write.css">
<link rel="stylesheet" href="resources/css/board/detail.css">
<link rel="stylesheet" href="resources/css/board/edit.css">
<script type="text/javascript" src="resources/js/validChecker.js"></script>
<script type="text/javascript" src="resources/js/aaronValidChecker.js"></script>
<script type="text/javascript" src="resources/js/rechecker.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/smp_jQuery.js"></script>
<script type="text/javascript" src="resources/js/link.js"></script>
</head>
<body>
	<table id="headerArea">
		<tr>
			<td align="center">
				<table id="titleArea">
					<tr>
						<td id="title" align="center">
							<a href="index.do"><img src="resources/img/structImg/webTitle.png" width="1200px"></a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td id="menuArea" align="center">
				<table id="menuArea">
					<tr>
						<td id="menuBtn">
							<a href="board.go?page=1">Board</a>
						</td>
						<td id="menuBtn">
							<a href="">Gallery</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="contentsArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentsPage }"></jsp:include>
			</td>
		</tr>
	</table>
	
	<button id="startBtn">login</button>
	
	<table id="loginArea">
		<tr>
			<td align="center">
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>