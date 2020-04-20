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
		
		        <a href="Add_Employee.jsp">Add Employee</a>
		        |
		        <a href="Update_Employee.jsp">Update Employee</a>
		        |
		        <a href="Delete_Employee.jsp">Delete Employee</a>
		        |
		        <a href="Search_Employee.jsp">Search Employee</a>
		        

			<table border="3">
			
				<tr bgcolor="RED">
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
</body>


</html>





