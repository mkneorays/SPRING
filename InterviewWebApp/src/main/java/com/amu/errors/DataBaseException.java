package com.amu.errors;

public class DataBaseException extends RuntimeException {

	public DataBaseException() {
		super();
	}//constructor
	
	public DataBaseException(String error) {
		super(error);
	}// string constructor
	
	
}//class
