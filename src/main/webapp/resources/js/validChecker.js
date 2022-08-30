function checkJoin() {
	var id = document.joinForm.joinId;
	var pw = document.joinForm.joinPw;
	var pwc = document.joinForm.joinPwc;
	var bcn = document.joinForm.joinBcn;
	var name = document.joinForm.joinName;
	var birth1 = document.joinForm.joinBirth1;
	var birth2 = document.joinForm.joinBirth2;
	var addr1 = document.joinForm.joinAddr1;
	var addr2 = document.joinForm.joinAddr2;
	var addr3 = document.joinForm.joinAddr3;
	var photo = document.joinForm.joinPhoto;

	// ID 중복검사, 블록체인 관련 유효성 검사 추가 예정
	// alert($("#memberJoinBCN").css("border"));
	// 3px solid rgb(255, 0, 0)
	
	if (isEmpty(id) || isUnValidString(id)
			|| $("#memberJoinID").css("color") == "rgb(255, 0, 0)") {

		alert("Please Check Your ID.");
		id.value = "";
		id.focus();
		return false;
	}

	if (isEmpty(pw) || isNotEquals(pw, pwc) || isNotIncluded(pw, "1234567890")
			|| isNotIncluded(pw, "abcdefghijklmnopqrstuvwxyz")) {

		alert("Please Check Your Password.");
		pw.value = "";
		pwc.value = "";
		pw.focus();
		return false;
	}
	
	if ($("#memberJoinBCN").css("border-color") == "rgb(255, 0, 0)") {
		
		alert("Please Check Your Block Chain Number.")
		return false;
	}
	
	if (isEmpty(name)) {
		alert("Please Check Your Name.");
		name.value = "";
		name.focus();
		return false;
	}

	if (isEmpty(birth1) || isEmpty(birth2) || isNotNumber(birth1)
			|| isLessThan(birth1, 6) || birth1.value.indexOf("-") != -1
			|| birth1.value.indexOf(".") != -1 || isNotNumber(birth2)
			|| isLessThan(birth2, 1)) {

		alert("Please Check Your Resident Registration Number.");
		birth1.value = "";
		birth2.value = "";
		birth1.focus();
		return false;
	}

	if (isEmpty(addr1) || isEmpty(addr2) || isEmpty(addr3)) {

		alert("Please Check Your Address.");
		addr1.value = "";
		addr2.value = "";
		addr3.value = "";
		addr1.focus();
		return false;
	}

	if (isEmpty(photo)
			|| (isNotType(photo, "png") && isNotType(photo, "gif")
					&& isNotType(photo, "jpg") && isNotType(photo, "bmp"))) {

		alert("Please Check Your Photo.");
		photo.value = "";
		return false;
	}

	return true;
}

function checkLogin() {
	var id = document.loginForm.loginId;
	var pw = document.loginForm.loginPw;
	var bcn = document.loginForm.loginBcn;

	if (isEmpty(id) || isUnValidString(id)) {

		alert("Please Check Your ID.");
		id.value = "";
		id.focus();
		return false;
	}

	if (isEmpty(pw) || isNotIncluded(pw, "1234567890")
			|| isNotIncluded(pw, "abcdefghijklmnopqrstuvwxyz")) {

		alert("Please Check Your Password.");
		pw.value = "";
		pwc.value = "";
		pw.focus();
		return false;
	}

	return true;
}

function checkEdit() {
	var id = document.editForm.editId;
	var pw = document.editForm.editPw;
	var pwc = document.editForm.editPwc;
	var name = document.editForm.editName;
	var birth1 = document.editForm.editBirth1;
	var birth2 = document.editForm.editBirth2;
	var addr1 = document.editForm.editAddr1;
	var addr2 = document.editForm.editAddr2;
	var addr3 = document.editForm.editAddr3;
	var photo = document.editForm.editPhoto;

	if (isEmpty(pw) || isNotEquals(pw, pwc) || isNotIncluded(pw, "1234567890")
			|| isNotIncluded(pw, "abcdefghijklmnopqrstuvwxyz")) {

		alert("Please Check Your Password.");
		pw.value = "";
		pwc.value = "";
		pw.focus();
		return false;
	}

	if (isEmpty(name)) {
		alert("Please Check Your Name.");
		name.value = "";
		name.focus();
		return false;
	}

	if (isEmpty(birth1) || isEmpty(birth2) || isNotNumber(birth1)
			|| isLessThan(birth1, 6) || birth1.value.indexOf("-") != -1
			|| birth1.value.indexOf(".") != -1 || isNotNumber(birth2)
			|| isLessThan(birth2, 1)) {

		alert("Please Check Your Resident Registration Number.");
		birth1.value = "";
		birth2.value = "";
		birth1.focus();
		return false;
	}

	if (isEmpty(addr1) || isEmpty(addr2) || isEmpty(addr3)) {

		alert("Please Check Your Address.");
		addr1.value = "";
		addr2.value = "";
		addr3.value = "";
		addr1.focus();
		return false;
	}

	if (isEmpty(photo)) {
		return true;
	}

	if (isNotType(photo, "png") && isNotType(photo, "gif")
			&& isNotType(photo, "jpg") && isNotType(photo, "bmp")) {

		alert("Please Check Your Photo.");
		photo.value = "";
		return false;
	}

	return true;
}

function checkGalleryUpload() {
	var photo = document.galleryUploadForm.spg_photo;
	var memo = document.galleryUploadForm.spg_memo;
	
	if (isEmpty(memo)) {
		
		alert("Please Check Your Memo.");
		memo.value = "";
		memo.focus();
		return false;
	}
	
	if (isEmpty(photo) ||
		(isNotType(photo, "png") && isNotType(photo, "gif")
		&& isNotType(photo, "jpg") && isNotType(photo, "bmp"))) {
		
		alert("Please Check Your Photo.");
		photo.value = "";
		photo.focus();
		return false;
	}
	
	return true;
}

