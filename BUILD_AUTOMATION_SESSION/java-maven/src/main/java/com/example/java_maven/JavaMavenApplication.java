package com.example.java_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaMavenApplication.class, args);

		Company company = new Company();
		company.setCompanyName("Onextel");
		company.setNumberOfEmployees(150);

		System.out.printf("Company Name: %s \n", company.getCompanyName());
		System.out.printf("Number of Employees: %s", company.getNumberOfEmployees());
	}

}
