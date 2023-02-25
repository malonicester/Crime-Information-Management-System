package com.crime.dao.UI;

import java.time.LocalDate;
import java.util.List;

import com.crime.dao.CrimeDAO;
import com.crime.dao.CrimeDAOImpl;
import com.crime.dao.CriminalDAO;
import com.crime.dao.CriminalDAOImpl;
import com.crime.dto.Crime;
import com.crime.dto.CrimeImpl;
import com.crime.dto.Criminal;
import com.crime.dto.CriminalImpl;
import com.crime.dto.Suspect;
import com.crime.dto.Victim;
import com.crime.exception.NoCrimeFoundException;
import com.crime.exception.SomethingWentWrongException;

public class Main {
	public static void main(String[] args) {
		CrimeDAO crimeDAO = new CrimeDAOImpl();
		CriminalDAO criminalDAO = new CriminalDAOImpl();
		Crime crime = new CrimeImpl("Loot", "Looted 50000 Rs", LocalDate.parse("2020-12-11"), "Tamando");
//		Criminal criminal = new CriminalImpl("Ramesh", "male", 23, "Black Mole On Chin", "Rasulgarh", "Labour");
		try {
//			criminalDAO.registerCriminal(criminal);
//			criminalDAO.assignCrimeToCriminal(3, 1);
//			crimeDAO.registerCrime(crime, 1);
//			crimeDAO.addArrestDate(1, LocalDate.parse("2023-02-25"));
			crimeDAO.changeStatusOfCrime(1, true);
//			Crime crime = crimeDAO.getCrimeDetails(2);
//			crimeDAO.registerCrime(crime, 1);
			List<Victim> list = crimeDAO.getAllVictimsOfACrime(2);
			List<Crime> crimes = criminalDAO.getRecordOfCriminal(1);
			List<String> getData = crimeDAO.noOfRecordsResolvedAndPending();
			getData.forEach(System.out::println);
//			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
