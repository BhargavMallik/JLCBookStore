package com.jlcindia.bookstore.to;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private String status;
	
	public User() {}
	
	public User(String fullName, String email, String phone, String dob, String gender, String username,String password) {
		
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.userName = username;
		this.password = password;
	
	}
	
	public User(int userId, String fullName, String email, String phone, String dob, String gender, String username,
			String password, String status) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.userName = username;
		this.password = password;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone + ", dob="
				+ dob + ", gender=" + gender + ", userName=" + userName + ", password=" + password + ", status="
				+ status + "]";
	}
	
	
	
	
	
}
