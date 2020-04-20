<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>Search Student</title>

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
		<h3>SEARCH Employee</h3>

		<form action="EmployeeControllerServlet" method="GET">

			<input type="hidden" name="command" value="SEARCH" />

			<table>
				<tbody>


					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Search" class="save" /></td>
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