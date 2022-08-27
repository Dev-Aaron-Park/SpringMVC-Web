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
	<table id="galleryTable">
		<tr>
			<td align="right">
				<a id="uploadGalleryBtn" onclick="showGalleryUpload();">Upload</a>
			</td>
		</tr>
		<tr>
			<td>
				<c:forEach var="p" items="${photos }">
				<table id="galleryCard" style="float: left">
					<tr>
						<td colspan="3" id="galleryCardPhoto" align="center">
							<img src="resources/img/galleryPhoto/${p.spg_photo }">
						</td>
					</tr>
					<tr>
						<td id="galleryCardId" align="center">
							${p.spg_writer }
						</td>
						<td id="galleryCardDate" align="center">
							<fmt:formatDate value="${p.spg_date }" type="date" pattern = "yyyy-MM-dd (E)"/>
						</td>
						<c:if test="${ p.spg_writer == sessionScope.loginMember.spm_id}">
						<td colspan="3" id="galleryCardDeleteBtn" align="center">
							<a href="gallery.delete.do?spg_no=${p.spg_no }">Delete</a>
						</td>
						</c:if>
					</tr>
					<tr>
						<td colspan="3" id="galleryCardMemo" align="center">
							${p.spg_memo }
						</td>
					</tr>
				</table>
				</c:forEach>
			</td>
		</tr>
	</table>
	
	<form action="gallery.upload.do" method="POST" enctype="Multipart/form-data">
	<table id="uploadGalleryTable" border="1">
		<tr>
			<td id="uploadGalleryCloseBtn" align="right">
				<input name="token" value="${token }">
				<a onclick="showGalleryUpload();">X&nbsp;&nbsp;</a>
			</td>		
		</tr>
		<tr>
			<td id="uploadGalleryFile" align="center">
				<input name="spg_photo" type="file">
			</td>		
		</tr>
		<tr>
			<td id="uploadGalleryMemo" align="center">
				<input id="galleryMemoInput" class="galleryMemoColor" name="spg_memo" placeholder="Memo">
			</td>	
		</tr>
		<tr>
			<td id="uploadGalleryUploadBtn" align="center">
				<button>Upload</button>
			</td>	
		</tr>
	</table>
	</form>
</body>
</html>