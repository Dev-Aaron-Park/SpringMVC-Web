function memberDeleteCheck() {
	var really = confirm("Are you sure you want to cancel your membership ?");
	if (really == true) {
		location.href = "delete.do";
	} else {
		location.href = "edit.go";
	}
}

function boardWriteCheck(member) {
	if (member == "") {
		alert("This service requires login.");
	} else {
		location.href = "board.write.go";
	}
}
