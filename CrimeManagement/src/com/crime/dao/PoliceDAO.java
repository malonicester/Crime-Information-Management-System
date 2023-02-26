package com.crime.dao;

import java.util.List;

import com.crime.dto.Crime;
import com.crime.exception.NoCaseFoundException;
import com.crime.exception.NoPoliceStationFoundException;
import com.crime.exception.SomethingWentWrongException;

public interface PoliceDAO {
	/**
	 * returns Number of all cases that are pending in difference police station
	 * 
	 * @param
	 * @return List<String>
	 * @throws NoCaseFoundException
	 */
	List<String> noOfCasesPendingInPoliceStation() throws NoCaseFoundException;

	/**
	 * Add new police station
	 * 
	 * @param name
	 * @throws SomethingWentWrongException
	 */
	public void addNewPoliceStation(String name) throws SomethingWentWrongException;

	/**
	 * get all cases for a particular police station
	 * 
	 * @param policeStationId
	 * @return List<Crime>
	 * @throws NoPoliceStationFoundException
	 */
	public List<Crime> getAllCasesInPoliceStation(int policeStationId) throws NoPoliceStationFoundException;

}
