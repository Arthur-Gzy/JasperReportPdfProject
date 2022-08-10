package com.example.JasperReportPdfProject.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.JasperReportPdfProject.FileHandler.FileHandler;
import com.example.JasperReportPdfProject.domain.dto.FileDto;
import com.example.JasperReportPdfProject.service.CustomerReportService;

@RestController
public class CustomerReportController {
	
	@Autowired
	CustomerReportService customerReportService;
	
	FileHandler file = new FileHandler();
	
	@GetMapping(value="/generatepdf")
	public String generateCustomerPdf
	(@RequestParam(value="fileName", defaultValue="Customers.pdf", required=true) String fileName) {
		file.setFileName(fileName);
		return customerReportService.generatePdf(fileName);
	}
	
	@GetMapping(value="/generatepdf/showpdf")
	public ResponseEntity<InputStreamResource> showCustomerReportPdf() throws IOException{
		file.findFileInProject(file.getFileName());
		if(file.doesFileExist()) {
			File pdfFile = new File(file.getFilePath());
			HttpHeaders headers = new HttpHeaders();
			headers.add("content-disposition", "inline; filename="+ file.getFileName());
			InputStreamResource resource = new InputStreamResource(new FileInputStream(pdfFile));
			return ResponseEntity
					.ok()
					.headers(headers)
					.contentLength(pdfFile.length())
					.contentType(MediaType.parseMediaType("application/pdf"))
					.body(resource);
		}
		else {
			return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(value="/generatepdf/showpdf/downloadpdf")
	public ResponseEntity<InputStreamResource> downloadCustomerReportPdf
	(@RequestParam(value="saveName", defaultValue="Customers.pdf", required=true) String saveName) throws FileNotFoundException{
		file.findFileInProject(file.getFileName());
		if(file.doesFileExist()) {
			File pdfFile = new File(file.getFilePath());
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "attachment; filename=" + saveName);
			InputStreamResource resource = new InputStreamResource(new FileInputStream(pdfFile));
			return ResponseEntity
					.ok()
					.headers(headers)
					.contentLength(pdfFile.length())
					.contentType(MediaType.parseMediaType("application/pdf"))
					.body(resource);
		}
		else {
			return new ResponseEntity<InputStreamResource>(HttpStatus.NOT_FOUND);
		}
	}
}
