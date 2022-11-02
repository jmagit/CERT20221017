package com.example.excepciones;

public class DemosException extends Exception {

	public DemosException() {
	}

	public DemosException(String message) {
		super(message);
	}

	public DemosException(Throwable cause) {
		super(cause);
	}

	public DemosException(String message, Throwable cause) {
		super(message, cause);
	}

	public DemosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
