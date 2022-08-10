package com.example.JasperReportPdfProject.domain.dto;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerDto {
	
	private Long id;
	private String firstName;
	private String secondName;
	private Long loan;

	public CustomerDto() {
	}
	
	public CustomerDto(Long id, String firstName, String secondName, Long loan) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.loan = loan;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Long getLoan() {
		return loan;
	}
	public void setLoan(Long loan) {
		this.loan = loan;
	}
	
	
}
