package com.example.demo.entity;
import javax.persistence.*;

@Entity
@Table(name="admins")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	public Admin() {
		super();
	}
	public Admin(int id, String userName, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
