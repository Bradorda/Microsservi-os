package com.microservices.vendas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnsupportedServiceException(String message) {
		super(message);
		
	}

}
