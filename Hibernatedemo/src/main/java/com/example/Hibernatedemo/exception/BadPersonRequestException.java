package com.example.Hibernatedemo.exception;

public class BadPersonRequestException extends RuntimeException {
	
	public BadPersonRequestException(String message) {
		super(message);
	}

}
