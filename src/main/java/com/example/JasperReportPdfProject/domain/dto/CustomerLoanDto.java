package com.example.JasperReportPdfProject.domain.dto;

public class CustomerLoanDto {
	
	private Long customerId;
	private Long loanQuantity;
	
	public CustomerLoanDto() {}
	
	public CustomerLoanDto(Long customerId, Long loanQuantity) {
		this.customerId = customerId;
		this.loanQuantity = loanQuantity;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getLoanQuantity() {
		return loanQuantity;
	}
	public void setLoanQuantity(Long loanQuantity) {
		this.loanQuantity = loanQuantity;
	}
}
