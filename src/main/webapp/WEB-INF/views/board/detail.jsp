<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Writing Content Area -->
	<table id="writingArea" border="1">
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
				${bw.spb_date }
			</td>
		</tr>
		<tr>
			<td id="content" colspan="3">
				${bw.spb_content }
			</td>
		</tr>
		<tr>
			<td id="btn" colspan="3" align="right">
				<a onclick="boardEdit(${bw.spb_no });">Edit</a>
				<a onclick="boardDelete(${bw.spb_no });">Delete</a>
			</td>
		</tr>
	</table>
	
	<!-- Comment Area -->
	<table id="commentArea" border="1">
		<tr id="commentShowArea">
			<td colspan="2">
				<table border="1">
					<tr>
						<td id="commentPhoto">
							Photo1
						</td>
						<td id="commentId">
							ID1
						</td>
						<td>
							Content1
						</td>
					</tr>
				</table>			
				<table border="1">
					<tr>
						<td id="commentPhoto">
							Photo2
						</td>
						<td id="commentId">
							ID2
						</td>
						<td>
							Content2
						</td>
					</tr>
				</table>			
				<table border="1">
					<tr>
						<td id="commentPhoto">
							Photo3
						</td>
						<td id="commentId">
							ID3
						</td>
						<td>
							Content3
						</td>
					</tr>
				</table>			
			</td>
		</tr>
		<tr id="commentInputArea">
			<td id="commentInput">
				Input
			</td>
			<td id="commentInputBtn">
				Button
			</td>
		</tr>
	</table>
	
	${bw.spb_color }
</body>
</html>