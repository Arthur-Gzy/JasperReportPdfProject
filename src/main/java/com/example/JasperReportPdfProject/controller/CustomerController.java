package com.example.JasperReportPdfProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JasperReportPdfProject.domain.dto.CustomerDto;
import com.example.JasperReportPdfProject.domain.entity.Customer;
import com.example.JasperReportPdfProject.service.CustomerService;
import com.example.JasperReportPdfProject.service.ProducerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProducerService producerService;
	
	@PostMapping(value="/add")
	public String addNewCustomer(@RequestBody CustomerDto customerDto) {
		customerService.customerAdd(customerDto);
		Customer customer = new Customer(customerDto.getFirstName(), customerDto.getSecondName());
		producerService.sendCustomer(customer);
		return "Saved";
	}
	
	@GetMapping(
			value="/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
		Customer customer = new Customer();
		customer = customerService.getCustomerById(id);
		producerService.sendCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public String deleteCustomerById(@PathVariable("id") Long id) {
		customerService.deleteById(id);
		return "Customer Deleted (Customer Id: " + id + ")";
	}
	
	@GetMapping(value="/all")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
}
