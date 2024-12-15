package com.employee.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String error)
	{
		super(error);
	}
}
