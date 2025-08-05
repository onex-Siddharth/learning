package com.example.java_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaGradleApplication.class, args);

		Company company = new Company();
		company.setCompanyName("Onextel");
		company.setNumberOfEmployees(100);

		System.out.printf("Company Name: %s \n",company.getCompanyName());
		System.out.printf("Number of Employees: %s \n",company.getNumberOfEmployees());
	}
}
