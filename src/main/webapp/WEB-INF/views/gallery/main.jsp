<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="galleryTable" border="1">
		<tr>
			<td align="right">
				<a onclick="showGalleryUpload();">Upload</a>
			</td>
		</tr>
		<tr>
			<td>
				<table id="galleryCard" style="float: left">
					<tr>
						<td colspan="2" id="galleryCardPhoto" align="center">
							Photo
						</td>
					</tr>
					<tr>
						<td id="galleryCardId" align="center">
							IDasd
						</td>
						<td id="galleryCardDate" align="center">
							Date
						</td>
					</tr>
					<tr>
						<td colspan="2" id="galleryCardMemo" align="center">
							Memo
						</td>
					</tr>
				</table>
				<table id="galleryCard" border="1" style="float: left">
					<tr>
						<td colspan="2">
							Photo
						</td>
					</tr>
					<tr>
						<td>
							ID
						</td>
						<td>
							Date
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Memo
						</td>
					</tr>
				</table>
				<table id="galleryCard" border="1" style="float: left">
					<tr>
						<td colspan="2">
							Photo
						</td>
					</tr>
					<tr>
						<td>
							ID
						</td>
						<td>
							Date
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Memo
						</td>
					</tr>
				</table>
				<table id="galleryCard" border="1" style="float: left">
					<tr>
						<td colspan="2">
							Photo
						</td>
					</tr>
					<tr>
						<td>
							ID
						</td>
						<td>
							Date
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Memo
						</td>
					</tr>
				</table>
				<table id="galleryCard" border="1" style="float: left">
					<tr>
						<td colspan="2">
							Photo
						</td>
					</tr>
					<tr>
						<td>
							ID
						</td>
						<td>
							Date
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Memo
						</td>
					</tr>
				</table>
				<table id="galleryCard" border="1" style="float: left">
					<tr>
						<td colspan="2">
							Photo
						</td>
					</tr>
					<tr>
						<td>
							ID
						</td>
						<td>
							Date
						</td>
					</tr>
					<tr>
						<td colspan="2">
							Memo
						</td>
					</tr>
				</table>
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
				<input name="spg_memo" placeholder="Memo">
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