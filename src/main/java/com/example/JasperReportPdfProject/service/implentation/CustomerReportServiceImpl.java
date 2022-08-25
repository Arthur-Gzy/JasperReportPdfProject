package com.example.JasperReportPdfProject.service.implentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JasperReportPdfProject.FileHandler.FileHandler;
import com.example.JasperReportPdfProject.RestTemplate.ClientTemplate;
import com.example.JasperReportPdfProject.domain.dto.CustomerDto;
import com.example.JasperReportPdfProject.domain.entity.Customer;
import com.example.JasperReportPdfProject.service.CustomerReportService;
import com.example.JasperReportPdfProject.service.CustomerService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class CustomerReportServiceImpl implements CustomerReportService{

	@Autowired
	CustomerService customerService;
	
	public String generatePdf(String fileName) {
		String rootPath = System.getProperty("user.dir");
		FileHandler jrxmlFile = new FileHandler("JasperDesign.jrxml");
		FileHandler pdfFile = new FileHandler(fileName);
		//String savePath = "/app/pdfreports/"; -> For container path!
		String savePath = "\\src\\main\\resources\\compiledPdfReports\\";// -> For windows path!
		jrxmlFile.findFileInProject(jrxmlFile.getFileName());
		String jrxmlPath = jrxmlFile.getFilePath();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy", "Necmeddin Güzey");
		List<Customer> customers = customerService.getAllCustomers();
		List<CustomerDto> customerDto = new ArrayList<CustomerDto>();
		for(Customer customer: customers) {
			Long customerLoan = ClientTemplate.getCustomerLoanByIdAPI(customer.getId()).getLoanQuantity();
			customerDto.add(new CustomerDto(customer.getId(), customer.getFirstName(), customer.getSecondName(), customerLoan));
		}
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);
			JRBeanCollectionDataSource customersJrBean = new JRBeanCollectionDataSource(customerDto);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, customersJrBean);
			JasperExportManager.exportReportToPdfFile(jasperPrint, rootPath+savePath+pdfFile.getFileName());
		}
		catch(JRException ex) {
			System.out.println(ex);
		}
		return "Generated";
	}
	
}
