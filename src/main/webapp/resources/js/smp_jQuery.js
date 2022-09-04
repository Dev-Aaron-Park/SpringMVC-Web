var startBtnSwitch = true;
var galleryUploadSwitch = true;

// 나중에 이 기능 옮겨야 함 Memo 위에 새로운 색상 선택 칸 만들어서
function connectGalleryMemoColorChangeEvent() {
	$("#galleryColorInput").keyup(function(){
		var c = $(this).val();
		$(".galleryMemoColor").css("color", c);
	});
}

function connectFoldMenuEvnet() {
	$("#contentsArea").click(function() {
		startBtnSwitch = true;
		$("#loginArea").css("right", "-300px").css("opacity", "1");
		$("#startBtn").css("right", "-4px")
	})
}

function connectSummonStartMenuEvent() {
	$("#startBtn").click(function(){
		if (startBtnSwitch) {
			$("#loginArea").css("right", "10px").css("opacity", "1");
			$("#startBtn").css("right", "306px");
		} else {
			$("#loginArea").css("right", "-300px").css("opacity", "1");
			$("#startBtn").css("right", "-4px");
		}
		startBtnSwitch = !startBtnSwitch;
	});
}

function showTitle() {
	// setInterval(콜백함수, 시간); 시간마다 함수를 반복적으로 자동 호출
	// setTimeout(콜백함수, 시간); 시간지나면 함수 자동호출
	
	setTimeout(function(){
		$("#headerArea").css("opacity", "1");
	}, 100);
}

function showGalleryUpload() {
	if (galleryUploadSwitch) {
		$("#uploadGalleryTable").css("opacity", "1").css("right", "820px");
	} else {
		$("#uploadGalleryTable").css("opacity", "0").css("right", "-300px");
	}
	galleryUploadSwitch = !galleryUploadSwitch;
}

function connectMemberJoinIDInputKeyEvent() {
	$("#memberJoinID").keyup(function(e){
		var id = $(this).val();
		$.getJSON("member.get?spm_id=" + id, function(memberData){
			if (memberData.member[0] == null) {
				$("#memberJoinID").css("color", "black");
			} else {
				$("#memberJoinID").css("color", "red");
			}
		});
	});
}

function connectMemberJoinBCNInputEvent() {
	var bcn = $("#memberJoinBCN").val();
	$("#memberJoinBCN").mousedown(function() {
		$(this).val("820");
		$(this).css("font-size", "15pt");
	});
	$("#memberJoinBCN").mouseup(function() {
		$(this).val(bcn);
		$(this).css("font-size", "9pt");
		$(this).css("border-color", "#00E676");
	});
}

function connectMemberJoinAddrSearchEvent() {
	$("#memberJoinAddr1, #memberJoinAddr2").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#memberJoinAddr1").val(data.zonecode);
	        	$("#memberJoinAddr2").val(data.roadAddress);
	        }
	    }).open();
	});
}

function connectMemberEditAddrSearchEvent() {
	$("#memberEditAddr1, #memberEditAddr2").click(function(){
		new daum.Postcode({
			oncomplete: function(data) {
				$("#memberEditAddr1").val(data.zonecode);
				$("#memberEditAddr2").val(data.roadAddress);
			}
		}).open();
	});
}

/////////////////////////////////////////////////////////////////////////////////////////

//function connectFoodFinderLocationEvent() {
//	// http의 한계로 인해 장소 지정(사용자 위치 받아와서 검색할 수 있는 기능은 보안상 https로 가능)
//	var position = new kakao.maps.LatLng(37.497952, 127.027619);
//	
//	var mapArea = document.getElementById('map');
//	var map = new kakao.maps.Map(mapArea, {level : 3, center: position});
//	
//
//	// 로드뷰
//	var roadviewArea = document.getElementById('roadview');
//	var roadview = new kakao.maps.Roadview(roadviewArea);
//	var roadviewClient = new kakao.maps.RoadviewClient();
//
//	roadviewClient.getNearestPanoId(position, 50, function(panoId) {
//	    roadview.setPanoId(panoId, position);
//	});
//	
//	$("#mapSearch1").keyup(function(e){
//		if (e.keyCode == 13) {
//			$.ajax({
//				url: "https://dapi.kakao.com/v2/local/search/address.json",
//				data: {query: $(this).val() },
//				beforeSend: function(req) {
//					req.setRequestHeader("Authorization", "KakaoAK 738a2e2afc750eba83dce81847a5fa16")
//				},
//				success: function(addrData) {
//					var there = new kakao.maps.LatLng(addrData.documents[0].address.y, addrData.documents[0].address.x);
//					map.setCenter(there);
//					roadviewClient.getNearestPanoId(there, 100, function(photoSpot) {
//						roadview.setPanoId(photoSpot, there);
//					});
//				}
//			});
//		}
//	});
//	
//	$("#mapSearch2").keyup(function(e){
//		if (e.keyCode == 13) {
//			var keyword = $(this).val();
//			$.ajax({
//				url: "https://dapi.kakao.com/v2/local/search/keyword.json",
//				data: {query: keyword, x: map.getCenter().getLng(), y: map.getCenter().getLat(), radius: 10000},
//				beforeSend: function(req) {
//					req.setRequestHeader("Authorization", "KakaoAK 738a2e2afc750eba83dce81847a5fa16")
//				},
//				success: function(searchData) {
//					$("#searchResult").empty();
//					$(searchData.documents).each(function(i, s){
//						$("#searchResult").append(
//								"<tr id='searchResultTr'><td id='roadAddressName' align='center'>"
//								+s.place_name
//								+"</td><td id='phone' align='center'>"
//								+s.phone
//								+"</td><td id='placeName' align='center'>"
//								+s.road_address_name
//								+"</td></tr>");
//					});
//				}
//			});
//		}
//	});
//}
//
//function moveMap(lat, lng) {
//	alert("asdasd");
//}


////////////////////////////////////////////////////////////////////////////////////////////////////////////


$(function(){
	connectGalleryMemoColorChangeEvent();
	connectSummonStartMenuEvent();
	connectMemberEditAddrSearchEvent();
	connectMemberJoinAddrSearchEvent();
	connectMemberJoinBCNInputEvent();
	connectMemberJoinIDInputKeyEvent();
	connectFoldMenuEvnet();
	showTitle();
	connectMapEvent();
});








