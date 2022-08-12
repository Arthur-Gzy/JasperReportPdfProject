package com.example.JasperReportPdfProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.JasperReportPdfProject.domain.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
