package com.crime.useCases;

import com.crime.dao.CriminalDAO;
import com.crime.dao.CriminalDAOImpl;
import com.crime.dto.Criminal;
import com.crime.dto.CriminalImpl;

public class AddCriminal {
	public static void main(String[] args) {
		CriminalDAO criminalDAO = new CriminalDAOImpl();
		Criminal criminal = new CriminalImpl("Ankit","male",34,"Mole On Face","LaxmiSagar","Cabin Crew");
		try {
//			criminalDAO.registerCriminal(criminal);
			criminalDAO.assignCrimeToCriminal(10, 1);
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
}
