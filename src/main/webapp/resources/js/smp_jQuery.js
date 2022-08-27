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

$(function(){
	connectGalleryMemoColorChangeEvent();
	connectSummonStartMenuEvent();
	connectFoldMenuEvnet();
	showTitle();
});