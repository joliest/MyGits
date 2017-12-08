$(document).ready(function() {
	
	var templateController = "/MiniTracker/Template.do";
	
	loadTemplatePage();
	//$("#attributeListBox").hide();
	
	//automatically generates the list of Attribute Groups
	$.post(templateController, { category : "loadAttributeGroups" } , function(data, status) {
		$("#attributeListBox").html(data);
	})
	
	//clicking the Add Attribute button toggles the list of Attribute Groups.
	$("#addAttributeButton").click(function(){
		$("#attributeListBox").toggle();
	})
	
	//adds new Template
	$("#addTemplateButton").click(function() {
		var value = $("#templateName").val();
		$.post(templateController, { category : "addTemplate", templateName : value }, function(data, status){
			alert(data);
			loadTemplatePage();
			clearFields();
		});		
	})
	
	$("#deleteAttributeButton").click(function(){
		$.each([ 52, 97 ], function(index, value){
			alert(index + " : " + value);
		})
	})
	
	//Shows the list of attributes when an Attribute Group gets clicked.
	$(this).on("click", "#attributeGroupList", function(){
		var name = $(this).text();
		var id = $(this).attr("attributeGroupId");
		//generates attributeList by attributeGroupId
		$.post(templateController, { category : "getAttributeList", attributeGroupName : name, attributeGroupId : id }, function(data, status) {
			$("div[attributeGroupId='" + id +"']").html(data);
		})
		$("div[attributeGroupId='" + id +"']").toggle();
	})
	
	
	//when you click one template row
	$(this).on("click", "#templateListRow", function(){

		
	})
	
	//refreshes the page
	function loadTemplatePage() {
		$.post(templateController, { category : "loadTemplateList" }, function(data, status) {
			$("#templateList").html(data);
		})		
	}
	
	//clears the page
	function clearFields() {
		$("input[type='text']").val("");
	}
})