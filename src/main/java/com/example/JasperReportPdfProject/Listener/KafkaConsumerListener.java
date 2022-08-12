package com.example.JasperReportPdfProject.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {
	
	@KafkaListener(topics="Customer", groupId="1")
	public void listen(String data) {
		System.out.println(String.format("Received Message -> {%s}", data));
	}

}
