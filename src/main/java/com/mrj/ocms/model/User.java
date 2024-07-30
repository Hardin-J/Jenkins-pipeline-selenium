package com.mrj.ocms.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "User_101")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "User_id")
	private int uid;
	
	@Column(name = "User_name")
	private String uname;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "Qualification")
	private String qual;
	
	@ManyToOne(targetEntity = Course.class,cascade = CascadeType.MERGE)
	private Course course;

	public User() {
		super();
	}

	public User(int uid, String uname, int age, String qual, Course course) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.age = age;
		this.qual = qual;
		this.course = course;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", age=" + age + ", qual=" + qual + ", course=" + course + "]";
	}
}
