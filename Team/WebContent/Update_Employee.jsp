<!DOCTYPE html>
<html>

<head>
	<title>Add Student</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Employee System</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Employee Details</h3>
		
		<form action="EmployeeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />
			
			<table>
				<tbody>
				
				   <tr>
						<td><label>ID:</label></td>
						<td><input type="text" name="id" /></td>
					</tr>
				    				    
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					
					<tr>
						<td><label>State:</label></td>
						<td><select id="state" name="state">
								<option value="">None</option>
								<option value="Maharastra">Maharastra</option>
								<option value="Bihar">Bihar</option>
								<option value="UP">UP</option>
								<option value="MP">MP</option>
						</select></td>
					</tr>					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="EmployeeControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>