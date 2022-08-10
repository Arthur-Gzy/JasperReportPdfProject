package com.example.JasperReportPdfProject.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private  Long id;
	
	@Column(name="firstname")
	private  String firstName;
	
	@Column(name="secondname")
	private  String secondName;
	
	public Customer() {}
	
	public Customer(String firstname, String secondname) {
		
		this.firstName = firstname;
		this.secondName = secondname;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	
	public void setSecondName(String secondname) {
		this.secondName = secondname;
	}
	
	@Override
	public String toString() {
		return "Customer{" + "id=" + this.id + ", firstname=" + this.firstName + ", secondname=" + this.secondName + "}";
	}
	
}
