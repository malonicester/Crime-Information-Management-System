package com.crime.dao;

import java.time.LocalDate;
import java.util.List;

import com.crime.dto.Crime;
import com.crime.dto.Criminal;
import com.crime.dto.Suspect;
import com.crime.dto.Victim;
import com.crime.exception.NoCriminalFoundException;
import com.crime.exception.NoPoliceStationFoundException;
import com.crime.exception.NoSuspectFoundException;
import com.crime.exception.NoVictimFoundException;
import com.crime.exception.SomethingWentWrongException;

public interface CrimeDAO {
	public void registerCrime(Crime crime) throws SomethingWentWrongException;

	public void transferToANewPoliceStationByName(String name)
			throws NoPoliceStationFoundException, SomethingWentWrongException;

	public void transferToANewPoliceStationById(int id)
			throws NoPoliceStationFoundException, SomethingWentWrongException;

	public void changeStatusOfCrime(boolean isSolved) throws SomethingWentWrongException;

	public void addArrestDate(LocalDate date) throws SomethingWentWrongException;

	public Crime getCrimeDetails(int id) throws NoCriminalFoundException, SomethingWentWrongException;

	public List<Suspect> getAllSuspectsOfACrime(int crimeId)
			throws NoSuspectFoundException, SomethingWentWrongException;

	public List<Criminal> getAllCriminalsOfACrime(int id) throws NoCriminalFoundException, SomethingWentWrongException;

	public List<Victim> getAllVictimsOfACrime(int crimeId) throws NoVictimFoundException, SomethingWentWrongException;
}
