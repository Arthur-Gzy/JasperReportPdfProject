package com.example.JasperReportPdfProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.JasperReportPdfProject.service.ProducerService;

@SpringBootApplication
public class JasperReportPdfProjectApplication {

	@Autowired
	private ProducerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(JasperReportPdfProjectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
				service.sendMessage("Hello Kafka");
		};
	}
}
