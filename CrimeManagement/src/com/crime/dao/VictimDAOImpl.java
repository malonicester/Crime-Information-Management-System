package com.crime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.crime.Utility.DBUtils;

public class VictimDAOImpl implements VictimDAO{

	@Override
	public void addVictim(String name, int crimeId) {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "INSERT INTO Victim (name,crimeId) values (?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, name);
			pstmt.setInt(2, crimeId);
			int res = pstmt.executeUpdate();
			if(res<=0) {
				System.out.println("Something Went Wrong");
			}
			else {
				System.out.println("Victim Added ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
