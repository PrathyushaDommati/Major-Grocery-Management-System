package com.example.demo.dto;

public class CustomerDTO {
	private int id;
	private String firstname;
	private String lastName;
	private String address;
	private String email;
	private String password;
	public CustomerDTO() {
		super();
	}
	public CustomerDTO(int id, String firstname, String lastName,  String address,
			String email, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastName = lastName;

		this.address = address;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName 
				+  ", address=" + address + ", email=" + email + ", password=" + password + "]";
	}
	

	
	
}
