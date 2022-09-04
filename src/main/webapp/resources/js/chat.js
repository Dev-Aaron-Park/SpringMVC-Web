$(function(){
	$("#chatInputArea input").keyup(function(e){
		if (e.keyCode == 13) {
			$("#chatInputArea button").trigger("click");
		}
	});
	
	var socket = null;
	var isFirstChat = true;
	var chatWriter = null;
	var myID = null;
	
	$("#chatInputArea button").click(function(){
		var chatMsg = $("#chatInput").val();
		myID = $("#chatID").val();
		
		if (myID == "") {
			alert("Please Login First.");
			return;
		}
		
		if (isFirstChat) {
			socket = io.connect("http://192.168.1.3:5244");
			isFirstChat = false;
			socket.on("yourData", function(msg){
				if (msg.id == myID) {
					$("#chatShowArea textarea").append(" [ 나 ] : "+ msg.msg + "\r\n");
				} else {
					$("#chatShowArea textarea").append(" [ "+ msg.id + " ] : "+ msg.msg + "\r\n");
				}
			});
		}
		
		socket.emit("myData", {id: myID, msg: chatMsg});
		$("#chatInput").val("");
	});
	
});