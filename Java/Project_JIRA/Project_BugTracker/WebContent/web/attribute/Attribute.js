$(document).ready(function(){
	$("button#addAttribute").click(function(){
		$.post("/Project_BugTracker/Attribute.do",
				{
					selectAttributeGroup : $("#selectAttributeGroup").val(),
					attributeName : $("#attributeName").val(),
					attributeDescription : $("#attributeDescription").val(),
					selectAttributeType : $("#selectAttributeType").val(),
					attributeLength : $("#attributeLength").val()
				},
				function(data, status) {
					alert(data);
				}				
				)
	})
});
/*
function addAttribute() {
	var xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
		}
	};

	xhttp.open("POST", "/Project_Bugtracker/Attribute.do", true);
	xhttp.send();
}
*/

