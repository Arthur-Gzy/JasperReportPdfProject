package com.example.JasperReportPdfProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.example.JasperReportPdfProject.service.ProducerService;

@SpringBootApplication
public class JasperReportPdfProjectApplication {

	//@Autowired
	//private ProducerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(JasperReportPdfProjectApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
				service.sendMessage("Deneme");
		};
	}*/
}
