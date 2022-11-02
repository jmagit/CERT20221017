package com.example.excepciones;

public class CalculosException extends RuntimeException {

	public CalculosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CalculosException(String message, Throwable cause) {
		super(message, cause);
	}

	public CalculosException(String message) {
		super(message);
	}

	public CalculosException(Throwable cause) {
		super(cause);
	}

	public CalculosException() {
		super();
	}

}
