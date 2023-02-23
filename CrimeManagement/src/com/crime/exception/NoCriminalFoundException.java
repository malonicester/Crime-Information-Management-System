package com.crime.exception;

public class NoCriminalFoundException extends Exception {

	public NoCriminalFoundException() {
	}

	public NoCriminalFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
