package com.crime.dao;

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
	public void assignCrimeToCriminal(int criminalID, int id) throws NoCrimeFoundException;
}
