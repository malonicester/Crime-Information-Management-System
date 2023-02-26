package com.crime.useCases;

import java.time.LocalDate;

import com.crime.dao.CrimeDAO;
import com.crime.dao.CrimeDAOImpl;
import com.crime.dto.Crime;
import com.crime.dto.CrimeImpl;
import com.crime.exception.SomethingWentWrongException;

public class AddCrime {
	public static void main(String[] args) {
		CrimeDAO crimeDAO = new CrimeDAOImpl();
		Crime crime = new CrimeImpl("Smuggling","Smuggling Of Marijuana",LocalDate.parse("2023-02-25"),"Sahid Nagar");
		try {
			crimeDAO.registerCrime(crime, 1);
		} catch (SomethingWentWrongException e) {
			e.printStackTrace();
		}
	}
}
