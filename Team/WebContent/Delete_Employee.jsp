<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>Delete Student</title>

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
		<h3>DELETE Employee</h3>

		<form action="EmployeeControllerServlet" method="GET">

			<input type="hidden" name="command" value="DELETE" />

			<table>
				<tbody>


					<tr>
						<td><label>ID:</label></td>
						<td><input type="text" name="id" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Delete" class="save" 
						onclick="if(!('Are You sure you want to delete this employee?'))return false"/></td>
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