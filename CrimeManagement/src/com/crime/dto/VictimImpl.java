package com.crime.dto;

public class VictimImpl implements Victim {
	private int id;
	private String name;

	public VictimImpl() {
	}

	public VictimImpl(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public VictimImpl(String name) {
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
		return "VictimImpl [id=" + id + ", name=" + name + "]";
	}

}
