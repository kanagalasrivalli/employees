package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.exception.NoDataFound;
import com.example.demo.model.Employee;



@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	public Employee createEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	public  Employee updateEmployee(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}
	public void deleteEmployeeid(Long employeeId) {
		employeeRepository.deleteById(employeeId);

	}
	
	public Employee getemployee(Long employeeId) {
		

		Optional<Employee> employee	=employeeRepository.findById(employeeId);
		
		Employee emp=null;
		if(employee.isPresent()) {
			emp=employee.get();
		}else {
			throw new EmployeeNotFound("");
		}
			
			return emp;
		}

	public List<Employee> findByEmployeeNameLike(String employeeName) {
		List<Employee> employee = employeeRepository.findByemployeeNameLike("%" + employeeName + "%");
		if (employee.isEmpty()) {
			throw new NoDataFound();
		}

		return employee;

	}
	
	
	

}
