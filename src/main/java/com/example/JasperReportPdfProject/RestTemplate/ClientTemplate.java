package com.example.JasperReportPdfProject.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.JasperReportPdfProject.domain.dto.CustomerLoanDto;

public class ClientTemplate {
	
	private final HttpHeaders headers = new HttpHeaders();
	
	public static String GET_LOAN_BY_ID_API = "http://localhost:8080/getloanbyid";
	
	static RestTemplate restTemplate = new RestTemplate();

	public static Long getCustomerLoanByIdAPI(Long id) {
		//CustomerLoanDto customerLoanDto = restTemplate.getForObject(GET_LOAN_BY_ID_API+"/"+id, CustomerLoanDto.class);
		/*ResponseEntity<CustomerLoanDto> loanEntity = restTemplate.getForEntity(GET_LOAN_BY_ID_API + "/"+id, CustomerLoanDto.class);
		System.out.println("  _________________________________");
		System.out.println(" |                                 |");
		System.out.println(" |                                 |");
		System.out.println(" |\t\t"+loanEntity.getStatusCodeValue());
		System.out.println(" |                                 |");
		System.out.println(" |                                 |");
		System.out.println(" |                                 |");
		System.out.println(" |                                 |");
		System.out.println(" |_________________________________|");
		if(loanEntity.getBody().getLoanQuantity() == null || loanEntity.getBody().getLoanQuantity() == 0L) {
			return 0L;
		}
		return loanEntity.getBody().getLoanQuantity();*/
		ResponseEntity<String> json = restTemplate.getForEntity(GET_LOAN_BY_ID_API + "/"+id,String.class);
		String str = json.getBody().replace("{", "").replace("}", "").replaceAll("\"", "");
		String[] customer = str.split(",");
		for(int i=0; i<2; i++) {
			customer[i] = customer[i].split(":")[1];
		}
		Long cusId = Long.valueOf(customer[0]);
		Long cusLoan = Long.valueOf(customer[1]);
		return cusLoan;
		/*
		System.out.println("  _______________________________________");
		System.out.println(" |                                       |");
		System.out.println(" |                                       |");
		System.out.println(" | "+          json.getBody()       +"   |");
		System.out.println(" |                                       |");
		System.out.println(" |                                       |");
		System.out.println(" |                                       |");
		System.out.println(" |                                       |");
		System.out.println(" |_______________________________________|");
		return 0L;*/
	}
}
