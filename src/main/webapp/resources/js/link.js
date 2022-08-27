function boardDetailGo(no) {
	location.href = "board.detail.go?no=" + no;
}

function boardDeleteDo(no) {
	location.href = "board.delete.do?no=" + no;
}

function boardEditGo(no) {
	location.href = "board.edit.go?no=" + no;
}

function galleryDeleteDo(no) {
	var really = confirm("Are you sure you want to delete the photo ?");
	if (really) {
		location.href = "gallery.delete.do?spg_no=" + no;
	}
}