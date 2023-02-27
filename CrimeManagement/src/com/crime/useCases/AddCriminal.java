package com.crime.useCases;

import com.crime.dao.CriminalDAO;
import com.crime.dao.CriminalDAOImpl;
import com.crime.dto.Criminal;
import com.crime.dto.CriminalImpl;

public class AddCriminal {
	public static void main(String[] args) {
		CriminalDAO criminalDAO = new CriminalDAOImpl();
		Criminal criminal = new CriminalImpl("Harsh","male",24,"Mole On Face","BhimTanki","Painter");
		try {
//			criminalDAO.registerCriminal(criminal);
			criminalDAO.assignCrimeToCriminal(8, 5);
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
}
