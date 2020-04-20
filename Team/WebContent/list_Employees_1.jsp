<%@ page import="java.util.*" %>
<%@ page import="com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Employee Tracker App</title>
	<link rel = "stylesheet" type = "text/css" href = "style.css" />	
</head>


       
<%
	// get the students from the request object (sent by servlet)
	List<Employee> theStudents = 
					(List<Employee>) request.getAttribute("STUDENT_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Employee System</h2>
		</div>
	</div>

           
	<div id="container">
	
		<div id="content">
		
		        
			<table border="3">
			
				<tr bgcolor="GREEN">
				    <th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>State</th>
				</tr>
				
				<% for (Employee tempStudent : theStudents) { %>
				
					<tr>
					    <td> <%= tempStudent.getId() %> </td>
						<td> <%= tempStudent.getFirstName() %> </td>
						<td> <%= tempStudent.getLastName() %> </td>
						<td> <%= tempStudent.getEmail() %> </td>
						<td> <%= tempStudent.getState() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
	
	
	<div style="clear: both;"></div>

		<p>
			<a href="EmployeeControllerServlet">Back to List</a>
		</p>
	
</body>


</html>





