package com.luv2code.web.jdbc;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmployeeDbUtil {

	private DataSource dataSource;

	public EmployeeDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Employee> getEmployees() throws Exception {
		
		List<Employee> employees = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from employee_det order by id";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String state = myRs.getString("state");
				
				// create new student object
				Employee tempStudent = new Employee(id, firstName, lastName, email,state);
				
				// add it to the list of students
				employees.add(tempStudent);				
			}
			
			return employees;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addEmployee(Employee theEmployee) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into employee_det "
					   + "(first_name, last_name, email,state) "
					   + "values (?, ?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setString(4, theEmployee.getState());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public void updateEmployee(Employee theEmployee) throws Exception 
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for update
			String sql = "update employee_det set first_name=?, last_name=?, email=?, state=? where id= ? ";
			       
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theEmployee.getFirstName());
			myStmt.setString(2, theEmployee.getLastName());
			myStmt.setString(3, theEmployee.getEmail());
			myStmt.setString(4, theEmployee.getState());
			myStmt.setInt(5, theEmployee.getId());
			
			// execute sql insert
			myStmt.executeUpdate();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
		
	}

	public void deleteEmployee(String theEmployeeId) throws Exception 
	{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			//change employee id string to int
			int id = Integer.parseInt(theEmployeeId);
			
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for update
			String sql = "DELETE FROM employee_det WHERE id=?";
			       
			myStmt = myConn.prepareStatement(sql);
			
			//set param
			myStmt.setInt(1,id); 
					
			
			// execute sql insert
			myStmt.executeUpdate();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}

		
	}

	public List<Employee> searchEmployee(String theSearchName) throws Exception
	{
		
       List<Employee> employees = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int studentId;
		
		try {
			
			// get connection to database
			myConn = dataSource.getConnection();
			
	        //
	        // only search by name if theSearchName is not empty
	        //
			if (theSearchName != null && theSearchName.trim().length() > 0) {

				// create sql to search for students by name
				String sql = "select * from employee_det where lower(first_name) like ? or lower(last_name) like ?";

				// create prepared statement
				myStmt = myConn.prepareStatement(sql);

				// set params
				String theSearchNameLike = "%" + theSearchName.toLowerCase() + "%";
				myStmt.setString(1, theSearchNameLike);
				myStmt.setString(2, theSearchNameLike);
				
			} else {
				// create sql to get all students
				String sql = "select * from employee_det order by last_name";

				// create prepared statement
				myStmt = myConn.prepareStatement(sql);
			}
	        
			// execute statement
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String state = myRs.getString("state");
				
				// create new student object
				Employee tempStudent = new Employee(id, firstName, lastName, email, state);
				
				// add it to the list of students
				employees.add(tempStudent);			
			}
			
			return employees;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

}



















