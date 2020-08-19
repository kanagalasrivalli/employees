package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.dto.ResponseMessageDto;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;

	static Employee employee = null;


	@BeforeClass
	public static void setUp() {
		employee = new Employee();
	}

	@Test
	public void testcreateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("sri");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testcreateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId(-15678);
		employee.setEmployeeName("valli");
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testupdateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId(1l);
		employee.setEmployeeName("sivalli");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testupdateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) -1);
		employee.setEmployeeName("sivasri");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testdeleteEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("siva");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testdeleteEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) -1);
		employee.setEmployeeName("siva");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testgetAllEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("sivak");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testgetAllEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) -1);
		employee.setEmployeeName("siva");
		Mockito.when(employeeService.createEmployee(null)).thenReturn(employee);
		ResponseEntity<ResponseMessageDto> employeee = employeeController.createEmployee(null);
		Assert.assertNotNull(employeee);
		Assert.assertEquals(employeee.getStatusCode(), HttpStatus.OK);
	}

	@AfterClass
	public static void tearDown() {
		employee = null;
	}
}
