package com.microservices.estoque.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnauthorizedServiceException(String message) {
		super(message);
		
	}
	
}
