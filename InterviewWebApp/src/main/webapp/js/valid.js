"use strict"
function validateForm() {
	// alert("hello javascript");
	var status = false;
	if (document.myForm.userId.value == "") {
		// alert("PLEASE PASS YR user id NONSENCE");
		document.getElementById("nameloc").innerHTML = "PLEASE PASS YOUR USER-ID";
		status = false;
	} else {
		document.getElementById("nameloc").innerHTML = "";
		status = true;
	}// if

	if (document.myForm.pass.value == "") {
		// alert("PLEASE PASS YR password NONSENCE");
		document.getElementById("passloc").innerHTML = "PLEASE PASS YOUR PASSWORD";
		status = false;
	}// if
	else {
		document.getElementById("passloc").innerHTML = "";
		status = true;
	}
	return status;
}