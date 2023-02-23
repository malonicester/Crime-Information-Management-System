package com.crime.exception;

public class NoPoliceStationFoundException extends Exception {

	public NoPoliceStationFoundException() {
		super();
	}

	public NoPoliceStationFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}

}
