package com.crime.dto;

import java.util.List;

public class CriminalImpl implements Criminal {
	private int criminalId;
	private String criminalName;
	private String gender;
	private int age;
	private String identificationMark;
	private String areaOfResidence;
	private String occupation;
	private String areaOfFirstArrested;
	List<Crime> crimes;

	public CriminalImpl() {
	}

	public CriminalImpl(int criminalId, String criminalName, String gender, int age, String identificationMark,
			String areaOfResidence, String occupation, String areaOfFirstArrested) {
		this.criminalId = criminalId;
		this.criminalName = criminalName;
		this.gender = gender;
		this.age = age;
		this.identificationMark = identificationMark;
		this.areaOfResidence = areaOfResidence;
		this.occupation = occupation;
		this.areaOfFirstArrested = areaOfFirstArrested;
	}

	public CriminalImpl(String criminalName, String gender, int age, String identificationMark, String areaOfResidence,
			String occupation, String areaOfFirstArrested) {
		super();
		this.criminalName = criminalName;
		this.gender = gender;
		this.age = age;
		this.identificationMark = identificationMark;
		this.areaOfResidence = areaOfResidence;
		this.occupation = occupation;
		this.areaOfFirstArrested = areaOfFirstArrested;
	}

	public CriminalImpl(String criminalName, String gender, int age, String identificationMark, String areaOfResidence,
			String occupation) {
		this.criminalName = criminalName;
		this.gender = gender;
		this.age = age;
		this.identificationMark = identificationMark;
		this.areaOfResidence = areaOfResidence;
		this.occupation = occupation;
	}

	@Override
	public int getCriminalId() {
		return criminalId;
	}

	@Override
	public void setCriminalId(int criminalId) {
		this.criminalId = criminalId;
	}

	@Override
	public String getCriminalName() {
		return criminalName;
	}

	@Override
	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getIdentificationMark() {
		return identificationMark;
	}

	@Override
	public void setIdentificationMark(String identificationMark) {
		this.identificationMark = identificationMark;
	}

	@Override
	public String getAreaOfResidence() {
		return areaOfResidence;
	}

	@Override
	public void setAreaOfResidence(String areaOfResidence) {
		this.areaOfResidence = areaOfResidence;
	}

	@Override
	public String getOccupation() {
		return occupation;
	}

	@Override
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String getAreaOfFirstArrested() {
		return areaOfFirstArrested;
	}

	@Override
	public void setAreaOfFirstArrested(String areaOfFirstArrested) {
		this.areaOfFirstArrested = areaOfFirstArrested;
	}

	@Override
	public List<Crime> getCrimes() {
		return crimes;
	}

	@Override
	public void setCrimes(List<Crime> crimes) {
		this.crimes = crimes;
	}

	@Override
	public String toString() {
		return "criminalId=" + criminalId + ", criminalName=" + criminalName + ", gender=" + gender + ", age=" + age
				+ ", identificationMark=" + identificationMark + ", areaOfResidence=" + areaOfResidence
				+ ", occupation=" + occupation + ", areaOfFirstArrested=" + areaOfFirstArrested
				+ "";
	}

}
