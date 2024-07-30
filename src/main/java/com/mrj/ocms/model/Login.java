package com.mrj.ocms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Login_101")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Login_id")
	private int logId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Username")
	private String userName;

	@Column(name = "password")
	private String password;
	
	public Login() {
		super();
	}

	public Login(int logId, String name, String userName, String password) {
		super();
		this.logId = logId;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
