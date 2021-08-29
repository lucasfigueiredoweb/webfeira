package com.br.webfeira.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1886285425265691526L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
