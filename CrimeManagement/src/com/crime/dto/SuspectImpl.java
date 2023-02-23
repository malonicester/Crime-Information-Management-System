package com.crime.dto;

public class SuspectImpl implements Suspect {

	private int id;
	private String name;

	public SuspectImpl() {

	}

	public SuspectImpl(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public SuspectImpl(String name) {
		this.name = name;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + "";
	}

}
