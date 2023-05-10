package com.advancejava.assignment5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorid;
	private String authorname;
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorsname(String authorname) {
		this.authorname = authorname;
	}
	public Authors(int authorid, String authorname) {
		super();
		this.authorid = authorid;
		this.authorname = authorname;
	}
	public Authors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
