package com.crime.exception;

public class NoCrimeFoundException extends Exception {

	public NoCrimeFoundException() {
		super();
	}

	public NoCrimeFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
