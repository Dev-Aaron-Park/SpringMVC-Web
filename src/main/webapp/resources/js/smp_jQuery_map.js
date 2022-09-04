var rc = new kakao.maps.RoadviewClient();
var map = null;
var rv = null;
var marker = null;
function moveMap(lat, lng){
	var there = new kakao.maps.LatLng(lat, lng);
	map.setCenter(there);
	rc.getNearestPanoId(there, 100, function(photoSpot){
		alert("?");
		rv.setPanoId(photoSpot, there);
	});
	marker.setPosition(there);
}

function connectMapEvent() {
	var mapArea = document.getElementById("map");
	var rvArea = document.getElementById("rv");
	// http의 한계로 인해 장소 지정(사용자 위치 받아와서 검색할 수 있는 기능은 보안상 https로 가능)
	// navigator.geolocation.getCurrentPosition(function(loc){
		// var lat = loc.coords.latitude;
		// var lng = loc.coords.longitude;
	var lat = 37.497952;
	var lng = 127.027619;
	var position = new kakao.maps.LatLng(lat, lng);
	map = new kakao.maps.Map(mapArea, {center: position});
	rv = new kakao.maps.Roadview(rvArea);
	marker = new kakao.maps.Marker({
	    map: map,
	    position: position
	});
	// moveMap(lat, lng);
	
	// });
	
	$("#mapSearch1").keyup(function(){
		$.ajax({
			url : "https://dapi.kakao.com/v2/local/search/address.json",
			data : { query : $(this).val() },
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "KakaoAK 738a2e2afc750eba83dce81847a5fa16");
			},
			success : function(addrData) {
				alert(addrData.documents[0].y);
				alert(addrData.documents[0].x);
				moveMap(addrData.documents[0].y, addrData.documents[0].x);
			}
		});
	});
	
	$("#mapSearch2").keyup(function(){
		$.ajax({
			url : "https://dapi.kakao.com/v2/local/search/keyword.json",
			data : { 
				query : $(this).val(),
				x : map.getCenter().getLng(), y : map.getCenter().getLat(),
				radius : 5000, sort : "distance"
			},
			beforeSend : function(req) {
				req.setRequestHeader("Authorization", "KakaoAK 738a2e2afc750eba83dce81847a5fa16");
			},
			success : function(searchData) {
				$("#searchResult").empty();
				$.each(searchData.documents, function(i, loc) {
					var nTd = $("<td></td>").text(loc.place_name);
					var aTd = $("<td></td>").attr("align","right").text(loc.road_address_name+"("+loc.distance+"m)");
					var pTd = $("<td></td>").attr("align","right").text(loc.phone);
					var tr = $("<tr></tr>").attr("id", "searchResultTr").attr("onclick", "moveMap(" + loc.y + ", " + loc.x + ");").append(nTd, aTd, pTd);
					$("#searchResult").append(tr);
				});
			}
		});
	});
}