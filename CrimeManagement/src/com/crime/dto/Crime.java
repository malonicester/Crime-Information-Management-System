package com.crime.dto;

import java.time.LocalDate;
import java.util.List;

public interface Crime {
	public int getCrimeID();

	public void setCrimeID(int crimeID);

	public String getCrimeType();

	public void setCrimeType(String crimeType);

	public String getCrimeDesc();

	public void setCrimeDesc(String crimeDesc);

	public LocalDate getDateOfCrime();

	public void setDateOfCrime(LocalDate dateOfCrime);

	public LocalDate getDateOfArrest();

	public void setDateOfArrest(LocalDate dateOfArrest);

	public String getPlaceOfCrime();

	public void setPlaceOfCrime(String placeOfCrime);

	public boolean isSolved();

	public void setSolved(boolean isSolved);

	public PoliceStation getPoliceStation();

	public void setPoliceStation(PoliceStation policeStation);

	public List<Criminal> getCriminals();

	public void setCriminals(List<Criminal> criminals);
}
