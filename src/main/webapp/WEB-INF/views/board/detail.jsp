<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Writing Content Area -->
	<table id="writingArea">
		<tr id="titleTr">
			<td id="no" align="center">
				${bw.spb_no }
			</td>
			<td  align="center">
				${bw.spb_title }
			</td>
			<td id="writer" align="center">
				${bw.spb_writer }
			</td>
		</tr>
		<tr id="dateTr">
			<td colspan="3" align="right">
				<fmt:formatDate value="${bw.spb_date }" type="date" pattern = "yyyy-MM-dd (E) HH:mm:ss"/>
			</td>
		</tr>
		<tr>
			<td id="content" colspan="3">
				${bw.spb_content }
			</td>
		</tr>
		<c:if test="${sessionScope.loginMember.spm_id == bw.spb_writer }">
			<tr>
				<td id="btn" colspan="3" align="right">
					<a onclick="boardEditGo(${bw.spb_no });">Edit</a>
					<a onclick="boardDeleteDo(${bw.spb_no });">Delete</a>
				</td>
			</tr>
		</c:if>
	</table>
	
	<!-- Comment Area -->
	<table id="commentArea">
		<tr id="commentShowArea">
			<td colspan="2">
				<c:forEach var="c" items="${comments }">
				<table>
					<tr>
						<td id="commentId" align="center">
							${c.spc_writer }
						</td>
						<td id="commentContent" align="center">
							${c.spc_content }
						</td>
						<td id="commentDate" align="center">
							<fmt:formatDate value="${c.spc_date }" type="date" pattern = "yyyy-MM-dd HH:mm:ss"/>
						</td align="center">
						<c:if test="${c.spc_writer == sessionScope.loginMember.spm_id }">
						<form action="board.comment.delete.do" method="POST">
						<td id="commentDeleteBtn">
							<input name="spc_no" value="${c.spc_no }" type="hidden" readonly="readonly">
							<input name="spc_board_no" value="${c.spc_board_no }" type="hidden" readonly="readonly">
							<button>Delete</button>
						</td>
						</form>
						</c:if>
					</tr>
				</table>
				</c:forEach>		
			</td>
		</tr>
	<form action="board.comment.do" method="POST">
		<tr id="commentInputArea">
			<td id="commentInput" align="center">
				<textarea id="commentInputTextarea" name="spc_content" placeholder="Comment" maxlength="180"></textarea>
				<input name="spc_board_no" value="${bw.spb_no }" readonly="readonly" type="hidden">
				<input name="spc_writer" value="${sessionScope.loginMember.spm_id }"  readonly="readonly" type="hidden">
				<input name="token" value="${token }" readonly="readonly" type="hidden">
			</td>
			<td id="commentInputBtn" align="center">
				<button>Input</button>
			</td>
		</tr>
	</form>
	</table>
</body>
</html>