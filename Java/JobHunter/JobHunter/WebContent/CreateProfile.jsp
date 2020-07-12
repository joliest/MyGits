<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
 <%@ page import="com.jobhunter.components.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="chunks/header.jsp">
			<jsp:param name="theTitle" value="Create your profile" />
	</jsp:include>
</head>
<body>
  <div class="container">
  <form method="POST" action="/JobHunter/home">
  	  <h3>Personal Details</h3>
	  <div class="well">	
		  <div class="pull-right">
		 	<button type="submit" class="btn btn-default btn-sm">
		       <span class="glyphicon glyphicon-ok"></span> Save 
		     </button>
		 	<button type="button" class="btn btn-default btn-sm">
		       <span class="glyphicon glyphicon-remove"></span> Cancel 
		     </button>
		 </div>
	 
  
	    <br>
	    <label>${account.emailAddress}</label>
		<label for="firstName">First Name</label>
		<input type="text" class="form-control" id="firstName" name="firstName">
		<label for="middleName">Middle Name</label>
		<input type="text" class="form-control" id="middleName" name="middleName">
		<label for="lastName">Last Name</label>
		<input type="text" class="form-control" id="lastName" name="lastName">
		
		<label for="jobTitle">Job Title</label>
		<input type="text" class="form-control" id="jobTitle" name="jobTitle">
		<label for="address">Address</label>
		<input type="text" class="form-control" id=""address" name="address">
		<label for="mobile">Mobile Number</label>
		<input type="text" class="form-control" id=""mobile" name="mobile">
	  </div>
	  
	  <h3>Job Preference</h3>
	  <div class="well">	    
	    <br>
	    
		<label for="desiredJobTitle">Desired Job Title</label>
		<input type="text" class="form-control" id="desiredJobTitle" name="desiredJobTitle">
		<label for="jobType">Job Type (select one):</label>
		<select class="form-control" id="jobType" name="jobType">
		  <option>Entry</option>
		  <option>Full Time</option>
		  <option>Part Time</option>
		  <option>Contract</option>
		</select>
		
	  </div>
	  
	 <h3>Work Experience</h3>
	  <div class="well">

		<label for="company">Company Name</label>
		<input type="text" class="form-control" id="company" name="company">
		<label for="jobTitle">Job Title</label>
		<input type="text" class="form-control" id="jobTitle" name="jobTitle">
	    <label for="fromWorkExperience">From</label>
		<select class="form-control" id="fromWorkExperience" name="fromWorkExperience">
		  <jsp:include page="chunks/year_list.jsp" />
		</select>
		<label for="toWorkExperience">To</label>
		<select class="form-control" id="toWorkExperience" name="toWorkExperience">
		  <jsp:include page="chunks/year_list.jsp" />
		</select>
		
		<label for="descriptionWorkExperience">Description:</label>
        <textarea class="form-control" rows="5" id="descriptionWorkExperience" name="descriptionWorkExperience"></textarea>
		
		<br>
		
	    <div class="pull-right">
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-plus"></span> Add 
	        </button>
	    </div>
	    
	    <br>
	    
	  </div>
	  
	  <h3>Education</h3>
	  <div class="well">
	  		    
		<label for="company">School Name</label>
		<input type="text" class="form-control" id="company" name="company">
		<label for="degree">Degree</label>
		<input type="text" class="form-control" id=""degree"" name=""degree"">
	    <label for="fromEducation">From</label>
		<select class="form-control" id="fromEducation" name="fromEducation">
		  <jsp:include page="chunks/year_list.jsp" />
		</select>
		<label for="toEducation">From</label>
		<select class="form-control" id="toEducation" name="toEducation">
		  <jsp:include page="chunks/year_list.jsp" />
		</select>
		
		<br>
		
		<label for="descriptionEducation">Description:</label>
        <textarea class="form-control" rows="5" id="descriptionEducation" name="descriptionEducation"></textarea>
		
		<br>
		
		
	    <div class="pull-right">
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-plus"></span> Add 
	        </button>
	    </div>
	    
	    <br>
	    
	  </div>
	  
	  <h3>Education</h3>
	  <div class="well">
	  	    
		<label for="skills">Skills (Separated in comma):</label>
        <textarea class="form-control" rows="5" id="skills" name="skills" placeholder="separated in comma"></textarea>
	    
	  </div>
	  
	  
	  	<div class="pull-right">
	    	<button type="submit" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-ok"></span> Save 
	        </button>
	    	<button type="button" class="btn btn-default btn-sm">
	          <span class="glyphicon glyphicon-remove"></span> Cancel 
	        </button>
	    </div>
	    
	    <br>
</div>
</form>
</body>
</html>