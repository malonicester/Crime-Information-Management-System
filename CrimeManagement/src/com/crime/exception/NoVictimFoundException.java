package com.crime.exception;

public class NoVictimFoundException extends Exception {

	public NoVictimFoundException() {
	}

	public NoVictimFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
