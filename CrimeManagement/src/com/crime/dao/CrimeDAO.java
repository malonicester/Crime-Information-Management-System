package com.crime.dao;

import java.time.LocalDate;
import java.util.List;

import com.crime.dto.Crime;
import com.crime.dto.Criminal;
import com.crime.dto.Suspect;
import com.crime.dto.Victim;
import com.crime.exception.NoCrimeFoundException;
import com.crime.exception.NoCriminalFoundException;
import com.crime.exception.NoPoliceStationFoundException;
import com.crime.exception.NoSuspectFoundException;
import com.crime.exception.NoVictimFoundException;
import com.crime.exception.SomethingWentWrongException;

public interface CrimeDAO {

	/**
	 * This method is used to Register a new Crime
	 * 
	 * @param crime
	 * @throws SomethingWentWrongException
	 */
	public void registerCrime(Crime crime, int polStationID) throws SomethingWentWrongException;

	/**
	 * This method is used to transfer the case to a new police station
	 * 
	 * @param name
	 * @throws NoPoliceStationFoundException
	 * @throws SomethingWentWrongException
	 */
	public void transferToANewPoliceStation(int crimeID, String name)
			throws NoPoliceStationFoundException, SomethingWentWrongException;

	/**
	 * This method is used to transfer the case to a new police station
	 * 
	 * @param id
	 * @throws NoPoliceStationFoundException
	 * @throws SomethingWentWrongException
	 */
	public void transferToANewPoliceStation(int crimeID, int polStationId)
			throws NoPoliceStationFoundException, SomethingWentWrongException;

	/**
	 * To Change the status of Crime
	 * 
	 * @param isSolved of Type Boolean
	 * @throws SomethingWentWrongException
	 * @return void
	 */
	public void changeStatusOfCrime(int crimeID, boolean isSolved) throws SomethingWentWrongException;

	/**
	 * This method is used to set The arrest date when the criminal is arrested
	 * 
	 * @param date Of Type LocalDate
	 * @throws SomethingWentWrongException
	 * @return void
	 */
	public void addArrestDate(int crimeId, LocalDate date) throws SomethingWentWrongException;

	/**
	 * To Get The details of a particular crime to get
	 * 
	 * @param id of type integer
	 * @return Object Of Crime Type
	 * @throws NoCriminalFoundException
	 * @throws SomethingWentWrongException
	 * @throws NoCrimeFoundException 
	 */
	public Crime getCrimeDetails(int id) throws NoCrimeFoundException, SomethingWentWrongException, NoCrimeFoundException;

	/**
	 * to get all suspects of that crime
	 * 
	 * @param crimeId Of type integer
	 * @return List Of Suspect Which are associated with that case
	 * @throws NoSuspectFoundException
	 * @throws SomethingWentWrongException
	 */
	public List<Suspect> getAllSuspectsOfACrime(int crimeId)
			throws NoSuspectFoundException, SomethingWentWrongException;

	/**
	 * To get all criminals of that crime
	 * 
	 * @param id of type integer
	 * @return List of Criminals which are associated with that case
	 * @throws NoCriminalFoundException
	 * @throws SomethingWentWrongException
	 */
	public List<Criminal> getAllCriminalsOfACrime(int id) throws NoCriminalFoundException, SomethingWentWrongException;

	/**
	 * To get the all victims of that crime
	 * 
	 * @param crimeId of type integer
	 * @return List Of Victim which are associated with that Crime
	 * @throws NoVictimFoundException
	 * @throws SomethingWentWrongException
	 */
	public List<Victim> getAllVictimsOfACrime(int crimeId) throws NoVictimFoundException, SomethingWentWrongException;

}
