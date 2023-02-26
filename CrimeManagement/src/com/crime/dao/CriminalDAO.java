package com.crime.dao;

import java.util.List;

import com.crime.dto.Crime;
import com.crime.dto.Criminal;
import com.crime.exception.NoCrimeFoundException;
import com.crime.exception.SomethingWentWrongException;

public interface CriminalDAO {
	/**
	 * register a criminal
	 * 
	 * @param criminal of Type Criminal
	 * @throws SomethingWentWrongException
	 */
	public void registerCriminal(Criminal criminal) throws SomethingWentWrongException;

	/**
	 * This method is used to assign the criminal a Crime
	 * 
	 * @param criminalID
	 * @param id
	 * @throws NoCrimeFoundException
	 */
	public void assignCrimeToCriminal(int crimeId,int criminalID) throws NoCrimeFoundException;

	/**
	 * This method can be used to get all the criminal record of a criminal
	 * 
	 * @param criminalId
	 * @return List<String>
	 * @throws NoCrimeFoundException
	 */
	public List<Crime> getRecordOfCriminal(int criminalId) throws NoCrimeFoundException;
}
