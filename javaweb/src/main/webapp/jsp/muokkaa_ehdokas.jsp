<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<title>Ehdokkaan muokkaus</title>
<script>
function readEhdokas(id){
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
		  var html = this.responseText;
		  document.getElementById("ehdokasForm").innerHTML = html;
	  }
	};
	xmlhttp.open("GET", "/rest/ehdokasService/readEhdokas?id=" + id, true);
	xmlhttp.send();	
}

$(document).ready(function () {
	let searchParams = new URLSearchParams(window.location.search)
	searchParams.has('id') 
	let id = searchParams.get('id')
	readEhdokas(id);
	
    $("form").submit(function (event) {



        var formData = {
            id: $("input[name='id']").val(),
            nimi: $("input[name='nimi']").val(),
            kuvaus: $("textarea[name='kuvaus']").val(),
            slogan: $("input[name='slogan']").val(),
            kunta: $("select[name='kunta']").val(),
            puolue: $("select[name='puolue']").val(),
        };
        var formDataJson = JSON.stringify(formData);
        $.ajax({
            type: "PUT",
            url: "/rest/ehdokasService/muokkaaEhdokas",
            data: formDataJson,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            error: function (e) {
            	$("input[name='nimi']").val(formData.nimi);
            	$("textarea[name='kuvaus']").val(formData.kuvaus);
            	$("input[name='slogan']").val(formData.slogan);
            	$("select[name='kunta']").val(formData.kunta);
            	$("select[name='puolue']").val(3);
            	document.getElementById("result").innerHTML = "Muokkaus epäonnistui";
                console.log(e);
            },
            success: function (ehdokasData) {
            	$("input[name='nimi']").val(ehdokasData.nimi);
            	$("textarea[name='kuvaus']").val(ehdokasData.kuvaus);
            	$("input[name='slogan']").val(ehdokasData.slogan);
            	$("select[name='kunta']").val(ehdokasData.kunta);
            	$("select[name='puolue']").val(ehdokasData.puolue);
            	document.getElementById("result").innerHTML = "Muokkaus onnistui!";
            }
        });
        event.preventDefault();
    });
});
</script>
</head>
<body>
	<form accept-charset="UTF-8" method="post">
		<div id="ehdokasForm"><p>Ladataan ehdokkaan tietoja</p></div>
	</form>
	
	<p id="result"></p>
	<a href="./ehdokkaat.jsp">Takaisin</a>
</body>
</html>