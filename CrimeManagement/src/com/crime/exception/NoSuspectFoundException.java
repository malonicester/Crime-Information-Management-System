package com.crime.exception;

public class NoSuspectFoundException extends Exception {

	public NoSuspectFoundException() {
		super();
	}

	public NoSuspectFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
