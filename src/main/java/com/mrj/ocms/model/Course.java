package com.mrj.ocms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course_101")
public class Course {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "Course_id")
	private int cid;
	
	@Column(name = "Course_name")
	private String cname;
	
	@Column(name = "Course_duration(in mins)")
	private int cdur;
	
	@Column(name = "Cost(in $)")
	private int cost;

	public Course() {
		super();
	}

	public Course(int cid, String cname, int cdur, int cost) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdur = cdur;
		this.cost = cost;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCdur() {
		return cdur;
	}

	public void setCdur(int cdur) {
		this.cdur = cdur;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cdur=" + cdur + ", cost=" + cost + "]";
	}
}
