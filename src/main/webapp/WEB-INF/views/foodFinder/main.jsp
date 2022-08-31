<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="mapArea">
		<tr>
			<td align="right">
				<input id="mapSearch1" autocomplete="off" placeholder="location keyword">
			</td>
			<td align="left">
				<input id="mapSearch2" autocomplete="off" placeholder="food keyword">
			</td>
		</tr>
		<tr>
			<td id="map" style="width:500px;height:400px;"></td>
			<td id="rv" style="width:500px;height:400px;"></td>
		</tr>
	</table>
	
	<table id="searchResult">
	</table>
</body>
</html>