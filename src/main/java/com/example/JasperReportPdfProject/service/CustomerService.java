package com.example.JasperReportPdfProject.service;

import java.util.List;

import com.example.JasperReportPdfProject.domain.dto.CustomerDto;
import com.example.JasperReportPdfProject.domain.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	void customerAdd(CustomerDto customerDto);
	Customer getCustomerById(Long id);
	void deleteById(Long id);
}
