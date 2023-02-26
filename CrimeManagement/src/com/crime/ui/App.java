package com.crime.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.crime.dao.CrimeDAO;
import com.crime.dao.CrimeDAOImpl;
import com.crime.dao.CriminalDAO;
import com.crime.dao.CriminalDAOImpl;
import com.crime.dao.PoliceDAO;
import com.crime.dao.PoliceDAOImpl;
import com.crime.dto.Crime;
import com.crime.dto.Criminal;
import com.crime.dto.Suspect;
import com.crime.dto.Victim;

public class App {
	static void operateTheSystem(Scanner sc) {
		System.out.println("                          *****Welcome to Crime Management System Application*****");
		System.out.println(
				"==================================================================================================================");
		System.out.println("                               Please Login as Assistant Police Inspector  ");
		System.out.println("                            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		System.out.println("Enter Login Id ");
		String user = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		if (!user.equalsIgnoreCase("admin") || !password.equalsIgnoreCase("admin"))
			return;
		System.out.println("Logged In Successfully");
		CrimeDAO crimeDAO = new CrimeDAOImpl();
		CriminalDAO criminalDAO = new CriminalDAOImpl();
		PoliceDAO policeDAO = new PoliceDAOImpl();

		while (true) {
			try {
				System.out.println(" \n   1. View All Criminals Data  : "
						+ " \n   2. Please enter Criminal Id to search to Criminal data : "
						+ " \n   3. Get Number Of Resolved and Pending Cases  : "
						+ " \n   4. Show All Victim Of  a Crime: " + " \n   5. Show All Suspects Of a Crime : "
						+ " \n   6. Change Status Of Crime to Solved : " + " \n   7. Add Arrest Date To The Crime : "
						+ " \n   8. Add Police Station  : " + " \n   9. Number of Crimes recorded in Year By Month   : "
						+ " \n  10. Get All The Cases Under a Police Station ." + " \n  11. Exit the App");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:

					System.out.println("Enter Criminal Id ");
					int criminalId = sc.nextInt();
					Criminal criminal = criminalDAO.getCriminalDetails(criminalId);
					System.out.println(
							"id    | name     | gender  | age  | Residence    | Occuption    | Area Of First Arrested");
					System.out.println(criminal.getCriminalId() + "      " + criminal.getCriminalName() + "       "
							+ criminal.getGender() + "       " + criminal.getAge() + "     "
							+ criminal.getAreaOfResidence() + "           " + criminal.getOccupation()
							+ "                "
							+ (criminal.getAreaOfFirstArrested() != null ? criminal.getAreaOfFirstArrested() : "NA"));
					break;
				case 2:
					System.out.println("Enter Criminal Id");
					criminalId = sc.nextInt();
					System.out.println(
							"id    |  Type     |        Description        |    DateOfCrime     |      Place        | Solved    | DateOfArrested   | PoliceStationName");
					List<Crime> list = criminalDAO.getRecordOfCriminal(criminalId);
					for (Crime crime : list) {
						System.out.println(crime.getCrimeID() + "        " + crime.getCrimeType() + "           "
								+ crime.getCrimeDesc() + "            " + crime.getDateOfCrime() + "        "
								+ crime.getPlaceOfCrime() + "       " + crime.isSolved() + "           "
								+ (crime.getDateOfArrest() != null ? crime.getDateOfArrest() : "NA") + "         "
								+ crime.getPoliceStation().getName().split(" ")[0]);
					}
					break;
				case 3:
					List<String> details = crimeDAO.noOfRecordsResolvedAndPending();
					details.forEach(System.out::println);
					break;
				case 4:
					System.out.println("Enter Crime Id");
					int crimeId = sc.nextInt();
					List<Victim> victims = crimeDAO.getAllVictimsOfACrime(crimeId);
					System.out.println("id   | name");
					victims.forEach((e) -> System.out.println(e.getId() + "       " + e.getName()));
					break;
				case 5:
					System.out.println("Enter Crime Id");
					crimeId = sc.nextInt();
					List<Suspect> suspects = crimeDAO.getAllSuspectsOfACrime(crimeId);
					System.out.println("id | name");
					suspects.forEach((e) -> System.out.println(e.getId() + "    " + e.getName()));
					break;
				case 6:
					System.out.println("Enter Crime Id");
					int crimeID = sc.nextInt();
					crimeDAO.changeStatusOfCrime(crimeID, true);
					break;
				case 7:
					System.out.println("Enter Crime Id");
					crimeId = sc.nextInt();
					System.out.print("Enter Date ");
					LocalDate date = LocalDate.parse(sc.next());
					crimeDAO.addArrestDate(crimeId, date);
					break;
				case 8:
					System.out.println("Police Station Name ");
					String name = sc.next();
					policeDAO.addNewPoliceStation(name);
					System.out.println("Police Station Added");
					break;
				case 9:
					System.out.println("Enter Year ");
					int year = sc.nextInt();
					List<String> crimesInYear = crimeDAO.getCrimesMonthWise(year);
					crimesInYear.forEach(System.out::println);
					break;
				case 10:
					System.out.println("Enter Police Station Id ");
					int policeStationId = sc.nextInt();
					List<Crime> crimesUnderAPoliceStation = policeDAO.getAllCasesInPoliceStation(policeStationId);
					System.out.println(
							"id    |  Type     |        Description        |    DateOfCrime     |      Place        | Solved    | DateOfArrested ");
					for (Crime crime : crimesUnderAPoliceStation) {
						System.out.println(crime.getCrimeID() + "        " + crime.getCrimeType() + "           "
								+ crime.getCrimeDesc() + "            " + crime.getDateOfCrime() + "        "
								+ crime.getPlaceOfCrime() + "       " + crime.isSolved() + "           "
								+ (crime.getDateOfArrest() != null ? crime.getDateOfArrest() : "NA"));
					}
					break;
				case 11:
					return;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

}
