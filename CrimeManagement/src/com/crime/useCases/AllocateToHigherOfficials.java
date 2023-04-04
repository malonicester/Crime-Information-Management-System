package com.crime.useCases;

import com.crime.dao.CrimeDAO;
import com.crime.dao.CrimeDAOImpl;
import com.crime.exception.NoPoliceStationFoundException;
import com.crime.exception.SomethingWentWrongException;

public class AllocateToHigherOfficials {
	public static void main(String[] args) {
		CrimeDAO crimeDAO = new CrimeDAOImpl();
		try {
			crimeDAO.transferToANewPoliceStation(3, 11);
		} catch (NoPoliceStationFoundException | SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}
	
}
