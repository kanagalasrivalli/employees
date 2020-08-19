package com.example.demo.exception;

public class EmployeeNotFound extends RuntimeException{
	public EmployeeNotFound(String source) {
		super(String.format("Employee with %s not found",source));
	}
}
