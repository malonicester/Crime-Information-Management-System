package com.crime.exception;

public class NoCaseFoundException extends Exception {

	public NoCaseFoundException() {
	}

	public NoCaseFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
