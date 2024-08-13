function showSidebar() {
	document.getElementsByClassName("sidebar")[0].style.display = "block";
}


function hideSidebar() {
	document.getElementsByClassName("sidebar")[0].style.display = "none";
}

function toggleSidebar() {
	if (document.getElementsByClassName("sidebar")[0].style.display === "none") {
		document.getElementsByClassName("sidebar")[0].style.display = "block";
	} else {
		document.getElementsByClassName("sidebar")[0].style.display = "none";
	}

}
