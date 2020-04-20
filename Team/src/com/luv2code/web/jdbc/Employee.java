package com.luv2code.web.jdbc;



public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String state;

	public Employee(String firstName, String lastName, String email,String state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.state = state;
	}

	public Employee(int id, String firstName, String lastName, String email,String state) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", state="
				+ state + "]";
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		
}

