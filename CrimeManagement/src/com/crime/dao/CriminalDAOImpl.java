package com.crime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crime.Utility.DBUtils;
import com.crime.dto.Criminal;
import com.crime.exception.NoCrimeFoundException;
import com.crime.exception.SomethingWentWrongException;

public class CriminalDAOImpl implements CriminalDAO {

	@Override
	public void registerCriminal(Criminal criminal) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "INSERT INTO Criminal (Criminalname,identMark,gender,age,areaOfResidence,occupation) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, criminal.getCriminalName());
			pstmt.setString(2, criminal.getIdentificationMark());
			pstmt.setString(3, criminal.getGender());
			pstmt.setInt(4, criminal.getAge());
			pstmt.setString(5, criminal.getAreaOfResidence());
			pstmt.setString(6, criminal.getOccupation());
			int res = pstmt.executeUpdate();
			System.out.println(res > 0 ? "Criminal Added to the register" : "");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void assignCrimeToCriminal(int criminalID, int crimeId) throws NoCrimeFoundException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "INSERT INTO criminalInvolvedIncrime (crimeID,criminalId) values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, crimeId);
			pstmt.setInt(2, criminalID);
			int res = pstmt.executeUpdate();
			if (res > 0)
				System.out.println("Criminal Assigned to the Crime");
			else
				throw new NoCrimeFoundException("No Crime found with id " + crimeId);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
