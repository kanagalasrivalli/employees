package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.model.Employee;

import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceTest {
	@InjectMocks
	EmployeeService employeeService;
	@Mock
	EmployeeRepository employeeRepository;

	static Employee employee = null;

	@BeforeClass
	public static void setUp() {
		employee = new Employee();
	}
	@Test
	public void testupdateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("srivalli");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = employeeService.updateEmployee(employee);
		Assert.assertNotNull(employeess);
        Assert.assertEquals(employee.getEmployeeId(),employee.getEmployeeId());	
	}
	@Test
	public void testupdateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId(-(long) 1);
		employee.setEmployeeName("srivalli");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = employeeService.updateEmployee(employee);
		Assert.assertNotNull(employeess);
        Assert.assertEquals(employee.getEmployeeId(),employee.getEmployeeId());	
	}
	@Test
	public void testcreateEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		employee.setPhone("8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = employeeService.updateEmployee(employee);
		Assert.assertNotNull(employeess);
        Assert.assertEquals(employee.getEmployeeName(),employee.getEmployeeName());		
	}
	@Test
	public void testcreateEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		employee.setPhone("-8838667354");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = employeeService.updateEmployee(employee);
		Assert.assertNotNull(employeess);
       Assert.assertEquals(employee.getEmployeeId(), employee.getEmployeeId());		
	}
	@Test
	public void testgetAllEmployeeForPositive() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = employeeService.updateEmployee(employee);
		Assert.assertNotNull(employeess);
	       Assert.assertEquals(employee.getEmployeeId(), employee.getEmployeeId());		
	}
	@Test
	public void testgetAllEmployeeForNagative() {
		List<Employee> employees = new ArrayList();
		Employee employee = new Employee();
		employee.setEmployeeId((long) 1);
		employee.setEmployeeName("kumar");
		Mockito.when(employeeRepository.saveAndFlush(employee)).thenReturn(employee);
		Employee employeess = employeeService.updateEmployee(employee);
		Assert.assertNotNull(employeess);
	       Assert.assertEquals(employee.getEmployeeId(), employee.getEmployeeId());		
	}
	@AfterClass
	public static void tearDown() {
		employee = null;
	}
	
}