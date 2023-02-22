package com.crime.dto;

import java.time.LocalDate;
import java.util.List;

public class CrimeImpl implements Crime {
	private int crimeID;
	private String crimeType;
	private String crimeDesc;
	private LocalDate dateOfCrime;
	private LocalDate dateOfArrest;
	private String placeOfCrime;
	private boolean isSolved;
	private PoliceStation policeStation;
	List<Criminal> criminals;

	public CrimeImpl() {
	}

	public CrimeImpl(int crimeID, String crimeType, String crimeDesc, LocalDate dateOfCrime, LocalDate dateOfArrest,
			String placeOfCrime, boolean isSolved) {
		this.crimeID = crimeID;
		this.crimeType = crimeType;
		this.crimeDesc = crimeDesc;
		this.dateOfCrime = dateOfCrime;
		this.dateOfArrest = dateOfArrest;
		this.placeOfCrime = placeOfCrime;
		this.isSolved = isSolved;
	}

	public CrimeImpl(int crimeID, String crimeType, String crimeDesc, LocalDate dateOfCrime, LocalDate dateOfArrest,
			String placeOfCrime, boolean isSolved, PoliceStation policeStation) {
		super();
		this.crimeID = crimeID;
		this.crimeType = crimeType;
		this.crimeDesc = crimeDesc;
		this.dateOfCrime = dateOfCrime;
		this.dateOfArrest = dateOfArrest;
		this.placeOfCrime = placeOfCrime;
		this.isSolved = isSolved;
		this.policeStation = policeStation;
	}

	public CrimeImpl(String crimeType, String crimeDesc, LocalDate dateOfCrime, LocalDate dateOfArrest,
			String placeOfCrime, boolean isSolved) {
		this.crimeType = crimeType;
		this.crimeDesc = crimeDesc;
		this.dateOfCrime = dateOfCrime;
		this.dateOfArrest = dateOfArrest;
		this.placeOfCrime = placeOfCrime;
		this.isSolved = isSolved;
	}

	@Override
	public int getCrimeID() {
		return crimeID;
	}

	@Override
	public void setCrimeID(int crimeID) {
		this.crimeID = crimeID;
	}

	@Override
	public String getCrimeType() {
		return crimeType;
	}

	@Override
	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	@Override
	public String getCrimeDesc() {
		return crimeDesc;
	}

	@Override
	public void setCrimeDesc(String crimeDesc) {
		this.crimeDesc = crimeDesc;
	}

	@Override
	public LocalDate getDateOfCrime() {
		return dateOfCrime;
	}

	@Override
	public void setDateOfCrime(LocalDate dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}

	@Override
	public LocalDate getDateOfArrest() {
		return dateOfArrest;
	}

	@Override
	public void setDateOfArrest(LocalDate dateOfArrest) {
		this.dateOfArrest = dateOfArrest;
	}

	@Override
	public String getPlaceOfCrime() {
		return placeOfCrime;
	}

	@Override
	public void setPlaceOfCrime(String placeOfCrime) {
		this.placeOfCrime = placeOfCrime;
	}

	@Override
	public boolean isSolved() {
		return isSolved;
	}

	@Override
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}

	@Override
	public PoliceStation getPoliceStation() {
		return policeStation;
	}

	@Override
	public void setPoliceStation(PoliceStation policeStation) {
		this.policeStation = policeStation;
	}

	@Override
	public List<Criminal> getCriminals() {
		return criminals;
	}

	@Override
	public void setCriminals(List<Criminal> criminals) {
		this.criminals = criminals;
	}

	@Override
	public String toString() {
		return "crimeID=" + crimeID + ", crimeType=" + crimeType + ", crimeDesc=" + crimeDesc + ", dateOfCrime="
				+ dateOfCrime + ", dateOfArrest=" + dateOfArrest + ", placeOfCrime=" + placeOfCrime + ", isSolved="
				+ isSolved + ", policeStation=" + policeStation + "";
	}

}
