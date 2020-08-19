package com.example.demo.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> DataNotFound(EmployeeNotFound ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("TIMESTAmp ", LocalDateTime.now());
		body.put("message", ex.getMessage());
		body.put("status", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	

	
}
