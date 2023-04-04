package com.crime.useCases;

import com.crime.dao.VictimDAO;
import com.crime.dao.VictimDAOImpl;

public class AddVictim {
	public static void main(String[] args) {
		VictimDAO victimDAO = new  VictimDAOImpl();
		victimDAO.addVictim("Anjum", 1);
	}
}
