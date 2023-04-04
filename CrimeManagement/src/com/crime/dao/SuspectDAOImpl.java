package com.crime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crime.Utility.DBUtils;

public class SuspectDAOImpl implements SuspectDAO{

	@Override
	public void addSuspect(String name, int crimeid) {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "INSERT INTO Suspect (name,crimeId) values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, name);
			pstmt.setInt(2, crimeid);
			int res = pstmt.executeUpdate();
			if(res<=0) {
				System.out.println("Something Went Wrong");
			}
			else {
				System.out.println("Suspect Added ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
