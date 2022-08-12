package com.example.JasperReportPdfProject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JasperReportPdfProject.RestTemplate.ClientTemplate;
import com.example.JasperReportPdfProject.domain.dto.CustomerDto;
import com.example.JasperReportPdfProject.domain.entity.Customer;
import com.example.JasperReportPdfProject.repository.CustomerRepository;
import com.example.JasperReportPdfProject.service.CustomerService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value="/add")
	public String addNewCustomer(@RequestBody CustomerDto customerDto) {
		customerService.customerAdd(customerDto);
		return "Saved";
	}
	
	@GetMapping(
			value="/customers/{id}",
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
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
