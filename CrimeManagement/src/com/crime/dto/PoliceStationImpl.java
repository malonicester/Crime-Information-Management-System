package com.crime.dto;

public class PoliceStationImpl implements PoliceStation {
	private int id;
	private String name;

	public PoliceStationImpl() {
	}

	public PoliceStationImpl(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public PoliceStationImpl(String name) {
		this.name = name;
	}

	public PoliceStationImpl(int id) {
		this.id = id;
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
