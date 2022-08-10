package com.example.JasperReportPdfProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.JasperReportPdfProject.FileHandler.FileHandler;

@SpringBootApplication
public class JasperReportPdfProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JasperReportPdfProjectApplication.class, args);
		//FileHandler file = new FileHandler();
		//file.setFileName("JasperDesign.jrxml");
		//file.findFileInProject(file.getFileName());
		
	}
}
