
$(document).ready(function(){
	$("#addAttribute").click(function(){
		$.post("/MiniTracker/Attribute.do",
				{
					category : "add",
					group : $("#attribGroup").val(),
					name : $("#attribName").val(),
					dataType : $("#attribGroup").val(),
					length : $("#attribGroup").val()
				},
				function(data, status) {
					alert(data);
				})				
	})
})


/*
function addAttribute(value) {
	var buttonType = value;
	
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			alert("Ok");
		}
	};
	
	xhttp.open("POST", "MiniTracker/");
	xhttp.send();
}

*/