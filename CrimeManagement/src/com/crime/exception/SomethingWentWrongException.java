package com.crime.exception;

public class SomethingWentWrongException extends Exception {

	public SomethingWentWrongException() {

	}

	public SomethingWentWrongException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
