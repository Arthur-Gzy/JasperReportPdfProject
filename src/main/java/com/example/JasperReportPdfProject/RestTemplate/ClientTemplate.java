package com.example.JasperReportPdfProject.RestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.JasperReportPdfProject.domain.dto.CustomerLoanDto;

public class ClientTemplate {
	
	public static String GET_LOAN_BY_ID_API = "http://localhost:8081/getloanbyid";
	
	static RestTemplate restTemplate = new RestTemplate();

	public static CustomerLoanDto getCustomerLoanByIdAPI(Long id) {
		CustomerLoanDto customerLoanDto = new CustomerLoanDto();
		ResponseEntity<String> json = restTemplate.getForEntity(GET_LOAN_BY_ID_API+"/"+id, String.class);
		String str = json.getBody().replace("{", "").replace("}", "").replaceAll("\"", "");
		String[] customer = str.split(",");
		for(int i=0; i<2; i++) {
			customer[i] = customer[i].split(":")[1];
		}
		customerLoanDto.setCustomerId(Long.valueOf(customer[0]));
		customerLoanDto.setLoanQuantity(Long.valueOf(customer[1]));
		return customerLoanDto;
	}
}
