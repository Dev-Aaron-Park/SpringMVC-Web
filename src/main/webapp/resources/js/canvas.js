function connectCanvasEvent() {
//	$("#canvasColor").keyup(function(){
//		
//	});
//	
	var paper = document.getElementById("canvasDrawPaper");
	var pen = paper.getContext("2d");
	
	var canvasX = $("canvas").offset().left;
	var canvasY = $("canvas").offset().top;
	
	$(window).resize(function(){
		var canvasX = $("canvas").offset().left;
		var canvasY = $("canvas").offset().top;
	});
	
	var socket = io.connect("http://192.168.1.3:5244");
	var isDraw = false;
	var startX = 0;
	var startY = 0;
	var endX = 0;
	var endY = 0;
	pen.lineWidth = 5;
	var color = null;
	
	$("canvas").mousedown(function(e){
		isDraw = true;
		startX = e.pageX - canvasX;
		startY = e.pageY - canvasY;
		color = "#EEEEEE";
		// pen.strokeStyle = "#" + $("#canvasColor").val();
	});
	
	$("canvas").mousemove(function(e){
		if (isDraw) {
			endX = e.pageX - canvasX;
			endY = e.pageY - canvasY;
			socket.emit("myDrawData", {
				color: color,
				startX: startX,
				startY: startY,
				endX: endX,
				endY: endY
			});
			startX = endX;
			startY = endY;
		}
	});
	
	$("canvas").mouseup(function(e){
		isDraw = false;
	});
	
	socket.on("yourDrawData", function(data){
		pen.strokeStyle = data.color;
		pen.beginPath();
		pen.moveTo(data.startX, data.startY);
		pen.lineTo(data.endX, data.endY);
		pen.closePath();
		pen.stroke();
	});
	
	

	
}
$(function(){
	connectCanvasEvent();
});