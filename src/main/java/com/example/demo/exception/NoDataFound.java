package com.example.demo.exception;

public class NoDataFound extends RuntimeException{
	private static final long serialVersionUID=1l;
	@Override
	public String getMessage() {
		return "No Data Found";
		
	}


}
 