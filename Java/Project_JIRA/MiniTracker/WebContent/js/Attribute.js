
/*
 	Add validation that detects blank values
 */

$(document).ready(function(){

	$.post("/MiniTracker/Attribute.do", 
			{category : ""},
			function(data, status) {
				$("#selectAttributeGroup").html(data);
			})
	
	
	$("#addAttribute").click(function(){
		$.post("/MiniTracker/Attribute.do",
				{
					category : "addAttribute",
					groupName : $("#attribGroup").val(),
					groupId : $("option:selected").attr("attributeid"),
					name : $("#attribName").val(),
					dataType : $("#attribDataType").val(),
					length : $("#attribLength").val()
				},
				function(data, status) {
					alert(data);
				})				
	})
	
	$("#addAttributeGroup").click(function(){
		$.post("/MiniTracker/Attribute.do", 
				{
					category : "addAttributeGroup",
					name : $("#attribGroupName").val()
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