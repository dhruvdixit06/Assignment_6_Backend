package com.advancejava.assignment5.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aid")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Authors author;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
	private LocalDateTime date;
	
	@PrePersist
	public void PrePersist() {
		this.date=LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime dateAdded) {
		this.date = dateAdded;
	}

	public Books(int id, String name, Authors author, LocalDateTime dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.date = dateAdded;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
