package com.crime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crime.Utility.DBUtils;
import com.crime.dto.Crime;
import com.crime.dto.CrimeImpl;
import com.crime.exception.NoCaseFoundException;
import com.crime.exception.NoPoliceStationFoundException;
import com.crime.exception.SomethingWentWrongException;

public class PoliceDAOImpl implements PoliceDAO {

	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}

	@Override
	public List<String> noOfCasesPendingInPoliceStation() throws NoCaseFoundException {
		Connection con = null;
		List<String> list = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "select P.name name,count(*) count from PoliceStation P INNER JOIN Crime C ON P.id = C.polStationid where solved = 'unsolved' group by P.name";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			ResultSet rs = pstmt.executeQuery();
			if (isResultSetEmpty(rs)) {
				throw new NoCaseFoundException();
			}
			list = new ArrayList<>();
			while (rs.next()) {
				String val = rs.getString("name") + " " + rs.getInt("count");
				list.add(val);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void addNewPoliceStation(String name) throws SomethingWentWrongException {
		Connection con = null;
		int res = 0;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "INSERT INTO PoliceStation(name) values (?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
			if (res <= 0) {
				throw new SomethingWentWrongException("Something went wrong");
			}
			System.out.println("Police Station added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Crime getAsCrime(ResultSet rs) throws SQLException {
		Crime crime = new CrimeImpl();
		crime.setCrimeID(rs.getInt("crimeId"));
		crime.setCrimeType(rs.getString("crimeType"));
		crime.setCrimeDesc(rs.getString("crimeDesc"));
		crime.setDateOfCrime(rs.getDate("dateOfCrime").toLocalDate());
		crime.setPlaceOfCrime(rs.getString("place"));
		crime.setSolved(rs.getString("solved").equalsIgnoreCase("solved") ? true : false);
//		crime.setPoliceStation(new PoliceStationImpl(rs.getInt("polStationid")));
		if (rs.getDate("dateOfArrest") != null) {
			crime.setDateOfArrest(rs.getDate("dateOfArrest").toLocalDate());
		}
		return crime;
	}

	@Override
	public List<Crime> getAllCasesInPoliceStation(int policeStationId) throws NoPoliceStationFoundException {
		Connection con = null;
		List<Crime> list = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "select crimeid,crimeType,crimedesc,dateOfCrime,place,solved,dateOfArrest from crime where  polStationid = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, policeStationId);
			ResultSet rs = pstmt.executeQuery();
			if (isResultSetEmpty(rs)) {
				throw new NoPoliceStationFoundException();
			}
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(getAsCrime(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
