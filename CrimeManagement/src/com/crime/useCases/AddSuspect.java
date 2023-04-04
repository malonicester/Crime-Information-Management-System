package com.crime.useCases;

import com.crime.dao.SuspectDAO;
import com.crime.dao.SuspectDAOImpl;
import com.crime.dto.SuspectImpl;

public class AddSuspect {
	public static void main(String[] args) {
		SuspectDAO suspectDAO = new SuspectDAOImpl();
		suspectDAO.addSuspect("Harman", 1);
	}
}
