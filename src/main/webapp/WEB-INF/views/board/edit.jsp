<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board.edit.do">
	<table id="boardEditForm" border="1">
		<tr>
			<td id="editTitle" align="center">
				<input name="spb_no" value="${bw.spb_no }" readonly="readonly" type="hidden">
				<input name="spb_title" value="${bw.spb_title }">
				<input name="spb_writer" value="${bw.spb_writer }" readonly="readonly" type="hidden">
			</td>
		</tr>
		<tr>
			<td id="editContent" align="center">
				<textarea name="spb_content">${bw.spb_content }</textarea>
				<input name="spb_color" value="${bw.spb_color }" readonly="readonly" type="hidden">
			</td>
		</tr>
		<tr>
			<td id="editBtn" align="right">
				<a onclick="">Cancel</a>
				<button>Edit</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>