package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.ResponseMessageDto;
import com.example.demo.exception.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
/**
 * 
 * @author srivalli
 *
 */


@RestController
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	/**
	 * 
	 * @param employeeDto
	 * @return ResponseMessageDto
	 */
	


	@PostMapping(value = "/employee")
	public ResponseEntity<ResponseMessageDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		 employeeService.createEmployee(employeeDto);
		responseMessageDto.setMessage("Employee created  successfully");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param employeeId
	 * @return ResponseMessageDto
	 */
	
	@DeleteMapping(value="/employee/{employeeid}")
	public ResponseEntity<ResponseMessageDto> deleteEmployee(@PathVariable("employeeid") Long employeeId) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		employeeService.deleteEmployeeid(employeeId);
		responseMessageDto.setMessage("Employee id is:"+employeeId+"deleted");
		return new ResponseEntity<>(responseMessageDto,HttpStatus.OK);
		}
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
	/**
	 * 
	 * @param employee
	 * @return ResponseMessageDto
	 */
	
	@PutMapping(value = "/employee")
	public ResponseEntity<ResponseMessageDto> updateEmployee(@RequestBody Employee employee) {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		employeeService.updateEmployee(employee);
		responseMessageDto.setMessage("Employee updated  successfully");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param employeeId
	 * @return ResponseMessageDto
	 */
	@GetMapping(value="/employee/{employeeid}")
	public ResponseEntity<Employee> getemployee(@PathVariable("employeeid") Long employeeId) {
	Employee employee = employeeService.getemployee(employeeId); 
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	/**
	 * 
	 * @param employeeName
	 * @return ResponseMessageDto
	 * @throws EmployeeNotFound
	 */
	@GetMapping("/employe/{employeeName}")
	public List<Employee> findByEmployeeNameLike(@PathVariable("employeeName") String employeeName) {
		List<Employee> employee = employeeService.findByEmployeeNameLike(employeeName);
		if (employee != null) {
			return employee;
		} else {
			throw new EmployeeNotFound("the given name or letter is not found");
		}
	}

	
	
}
