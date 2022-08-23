var startBtnSwitch = true;
function connectFoldMenuEvnet() {
	$("#contentsArea").click(function() {
		startBtnSwitch = true;
		$("#loginArea").css("right", "-300px").css("opacity", "0");
	})
}

function connectSummonStartMenuEvent() {
	$("#startBtn").click(function(){
		if (startBtnSwitch) {
			$("#loginArea").css("right", "10px").css("opacity", "1");
		} else {dltj
			$("#loginArea").css("right", "-300px").css("opacity", "0");
		}
		startBtnSwitch = !startBtnSwitch;
	});
}

function showTitle() {
	// setInterval(콜백함수, 시간); 시간마다 함수를 반복적으로 자동 호출
	// setTimeout(콜백함수, 시간); 시간지나면 함수 자동호출
	
	setTimeout(function(){
		$("#headerArea").css("opacity", "1");
	}, 1000);
}

$(function(){
	connectSummonStartMenuEvent();
	connectFoldMenuEvnet();
	showTitle();
});