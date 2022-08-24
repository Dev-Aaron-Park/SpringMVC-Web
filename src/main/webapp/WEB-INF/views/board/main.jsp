<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="boardArea">
		<tr>
			<th id="boardTitle" colspan="4">
				Board Title
			</th>
		</tr>
		<tr>
			<td id="boardWriteBtn" colspan="4" align="right">
				<a onclick="boardWriteCheck('${sessionScope.loginMember}');">Write</a>
			</td>
		</tr>
		<tr id="boardSubTitle" align="center">
			<td id="subTitleNo">
				No
			</td>
			<td id="subTitleWriter">
				Writer
			</td>
			<td id="subTitleTitle">
				Title
			</td>
			<td id="subTitleDate">
				Date
			</td>
		</tr>
		<c:forEach var="bw" items="${bwArr }">
			<tr onclick="boardDetailGo(${bw.spb_no});" id="boardWriting" align="center">
				<td>
					${bw.spb_no }
				</td>
				<td>
					${bw.spb_writer }
				</td>
				<td>
					${bw.spb_title }
				</td>
				<td>
					<fmt:formatDate value="${bw.spb_date }" dateStyle="short" type="date"/>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="center">
				<c:forEach var="p" begin="1" end="${pageCount }">
					<a href="board.go?page=${p }">&nbsp;${p }&nbsp;</a>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<form action="board.search">
					<input name="keyword"> <button>Search</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>