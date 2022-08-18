package com.example.JasperReportPdfProject.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.JasperReportPdfProject.domain.entity.Customer;

@Service
public class ProducerService {
	
	@Autowired
	KafkaTemplate<String, Customer> customerTemplate;
	
	@Autowired
	NewTopic customerTopic;

	public void sendCustomer(Customer customer) {
		customerTemplate.send(customerTopic.name(), customer);
	}

}
