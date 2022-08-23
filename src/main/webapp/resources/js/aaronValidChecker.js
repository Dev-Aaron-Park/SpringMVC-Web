function isEmpty(input) {
	return !input.value;
}

function isLessThan(input, len) {
	return input.value.length < len;
}

function isUnValidString(input) {
	var validString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_@."
	for (var i = 0; i < input.value.length; i++) {
		if (validString.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

function isNotEquals(input1, input2) {
	return input1.value != input2.value;
}

function isNotIncluded(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

function isNotNumber(input) {
	return isNaN(input.value);
}

function isNegativeNumber(input) {
	return input.value <= 0;
}

function isNotType(input, type) {
	return input.value.toLowerCase().indexOf("." + type) == -1
}