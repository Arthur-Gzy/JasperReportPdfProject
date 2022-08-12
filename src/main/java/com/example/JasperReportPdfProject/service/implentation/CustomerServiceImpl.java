package com.example.JasperReportPdfProject.service.implentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JasperReportPdfProject.domain.dto.CustomerDto;
import com.example.JasperReportPdfProject.domain.entity.Customer;
import com.example.JasperReportPdfProject.repository.CustomerRepository;
import com.example.JasperReportPdfProject.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepos;
	
	@Override
	public void customerAdd(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setSecondName(customerDto.getSecondName());
		customerRepos.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		customerRepos.findAll().forEach(customer -> customers.add(customer));
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		Optional<Customer> customer = customerRepos.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		customerRepos.deleteById(id);
	}
}
