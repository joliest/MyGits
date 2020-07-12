<!-- Using directive -->
<%@  page import="com.example.packages.*" %>
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>My Scriptlet JSP</title>
 </head>
 <body>

   This shows how we use Scriptlet, Directive and Expressions and Declarations <br>
	<ul>
		<li>Scriptlet: < % %></li>
		<li>Directive: < %@ %></li>
		<li>Expressions: < %= %></li>
		<li>Declarations: < %! %></li>
	</ul> 
	<!-- Simple scriptlet -->  
   <% Dog dog = new Dog("Jolibogs"); %>
   The dog name is:
   <!-- Using expression -->
   <%= dog.getName() %> <br>
   The surname is:
   <%= setDogSurname(dog.getName(), dog) %>
   
   <br>
   
   <%= getServletConfig().getInitParameter("email") %>
   
   <!-- Using declaration -->
   <%! public String setDogSurname(String name, Dog dog) {
			return dog.getName() + " Estampador";
   }
	%>
   

 </body>
</html>