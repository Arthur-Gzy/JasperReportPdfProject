package com.example.JasperReportPdfProject.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	NewTopic customerTopic;
	
	public void sendMessage(String msg) {
		kafkaTemplate.send(customerTopic.name(), msg);
	}

}
