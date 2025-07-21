package com.example.java_gradle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

  @Test
  void testGetCompanyName() {
    Company company = new Company();
    company.setCompanyName("Avaya");
    assertEquals("Avaya", company.getCompanyName());
  }

  @Test
  void testSetCompanyName() {
    Company company = new Company();
    company.setCompanyName("Tech Solutions");
    assertEquals("Tech Solutions", company.getCompanyName());
  }

  @Test
  void testSetCompanyNameWithNull() {
    Company company = new Company();
    company.setCompanyName(null);
    assertNull(company.getCompanyName());
  }

  @Test
  void testSetCompanyNameWithEmptyString() {
    Company company = new Company();
    company.setCompanyName("");
    assertEquals("", company.getCompanyName());
  }

  @Test
  void testGetNumberOfEmployees() {
    Company company = new Company();
    company.setNumberOfEmployees(100);
    assertEquals(100, company.getNumberOfEmployees());
  }

  @Test
  void testSetNumberOfEmployees() {
    Company company = new Company();
    company.setNumberOfEmployees(50);
    assertEquals(50, company.getNumberOfEmployees());
  }

  @Test
  void testSetNumberOfEmployeesWithNull() {
    Company company = new Company();
    company.setNumberOfEmployees(null);
    assertNull(company.getNumberOfEmployees());
  }

  @Test
  void testSetNumberOfEmployeesWithZero() {
    Company company = new Company();
    company.setNumberOfEmployees(0);
    assertEquals(0, company.getNumberOfEmployees());
  }

  @Test
  void testSetNumberOfEmployeesWithNegative() {
    Company company = new Company();
    company.setNumberOfEmployees(-1);
    assertEquals(-1, company.getNumberOfEmployees());
  }
}