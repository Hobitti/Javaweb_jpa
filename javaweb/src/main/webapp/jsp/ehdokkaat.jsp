<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ehdokkaat</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
function readEhdokkaat(){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var ehdokkaatListJSON = this.responseText;
		  var ehdokkaat = JSON.parse(ehdokkaatListJSON);
		  //print fish by function printOneFish.
		  printEhdokkaat(ehdokkaat);
	  } else {
		  document.getElementById("ehdokkaat").innerHTML = "lol";
	  }
	};
	xmlhttp.open("GET", "/rest/ehdokasService/readEhdokkaat", true);
	xmlhttp.send();	
}

function printEhdokkaat(list){
	var s = "";
	for (i in list) {
		s = s + "<div><h1>" + list[i].nimi + "</h1></div>";
	}
	document.getElementById("ehdokkaat").innerHTML = s;
}


$(document).ready(function() {
	readEhdokkaat();
});
</script>
</head>
<body>
	<div id="ehdokkaat">
	
	</div>
	<p>Kakkaa</p>
</body>
</html>