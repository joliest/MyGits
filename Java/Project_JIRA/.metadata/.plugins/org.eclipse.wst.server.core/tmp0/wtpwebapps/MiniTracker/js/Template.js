/*
var TEMPLATE_ID = (function(id){
	var _templateId = id;
	
	return function() {
		return _templateId;
	}
});
*/

var TEMPLATE_ID = (function(id) {
	var _templateId = id;
	return {
		getTemplateId : function() {
			return _templateId;
		}
	}
});

$(document).ready(function() {
	
	var templateController = "/MiniTracker/Template.do";
	var id = "";
	
	loadTemplatePage();
	$("#attributeListBox").hide();
	
	//automatically generates the list of Attribute Groups
	$.post(templateController, { category : "loadAttributeGroups" } , function(data, status) {
		$("#attributeListBox").html(data);ENtry
		
	})
	
	//when you click one template row
	$(this).on("click", "#templateListRow", function(){
		
		var templateId = $(this).attr("templateId");
		
		$("li").css("color", "black");
		$(this).css("color", "red");
		$("#attributeListBox").show();
		
		id = TEMPLATE_ID(templateId);
		console.log(id.getTemplateId());
		
		//generate template attribute
		$.post(templateController, { category : "loadTemplateAttribute", templateId : id.getTemplateId() }, function(data, status) {
			$("#templateAttribute").html(data);
		})
		
	})
	
	//adding checked boxes into the template
	$("#addAttributeButton").click(function(){
		var myObj = { "attributeId[]" : [] };
		var templateId = id.getTemplateId();
		
		//adding selected checkbox attributeId into the obj[] array
		$(":checked").each(function(i) {
			myObj["attributeId[]"].push($(this).attr("attributeId"));			
		})
		
		//check if there are checkbox selected
		if(myObj["attributeId[]"].length > 0) {
			//check if templateId is true
			if(templateId) {
				//send request and get response from MiniTracker\TemplateServlet.java
				$.post(templateController, { category : "addTemplateAttribute", selectedCheckboxes : myObj["attributeId[]"],  templateId : templateId}, function(data, status) {
					//alert(data);
				})
			} 
		} else {
			alert("No attributes selected");
		}
		
		
		
		
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
	
	
	
	
	//refreshes the page 
	//generates the list of Templates
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