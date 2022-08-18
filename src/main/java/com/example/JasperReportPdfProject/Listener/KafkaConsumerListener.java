package com.example.JasperReportPdfProject.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.JasperReportPdfProject.domain.entity.Customer;

@Component
public class KafkaConsumerListener {
	
	 @KafkaListener(topics="Customer", groupId="Group_Json", containerFactory="kafkaCustomerListenerContainerFactory")
	 public void consumeJson(Customer customer) {
		 System.out.println("Consumed Json Mesage -> " + customer.toString());
	 }
}
