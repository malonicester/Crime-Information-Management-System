package com.crime.dto;

import java.util.List;

public interface Criminal {
	public int getCriminalId();

	public void setCriminalId(int criminalId);

	public String getCriminalName();

	public void setCriminalName(String criminalName);

	public String getGender();

	public void setGender(String gender);

	public int getAge();

	public void setAge(int age);

	public String getIdentificationMark();

	public void setIdentificationMark(String identificationMark);

	public String getAreaOfResidence();

	public void setAreaOfResidence(String areaOfResidence);

	public String getOccupation();

	public void setOccupation(String occupation);

	public String getAreaOfFirstArrested();

	public void setAreaOfFirstArrested(String areaOfFirstArrested);

	public List<Crime> getCrimes();

	public void setCrimes(List<Crime> crimes);
}
