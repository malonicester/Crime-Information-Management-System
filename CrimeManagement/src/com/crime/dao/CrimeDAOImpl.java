package com.crime.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.crime.Utility.DBUtils;
import com.crime.dto.Crime;
import com.crime.dto.CrimeImpl;
import com.crime.dto.Criminal;
import com.crime.dto.PoliceStationImpl;
import com.crime.dto.Suspect;
import com.crime.dto.Victim;
import com.crime.exception.NoCrimeFoundException;
import com.crime.exception.NoCriminalFoundException;
import com.crime.exception.NoPoliceStationFoundException;
import com.crime.exception.NoSuspectFoundException;
import com.crime.exception.NoVictimFoundException;
import com.crime.exception.SomethingWentWrongException;

public class CrimeDAOImpl implements CrimeDAO {

	@Override
	public void registerCrime(Crime crime, int polStationID) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "INSERT INTO Crime (crimeType,crimeDesc,dateOfCrime,place,polStationid) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, crime.getCrimeType());
			pstmt.setString(2, crime.getCrimeDesc());
			pstmt.setDate(3, Date.valueOf(crime.getDateOfCrime()));
			pstmt.setString(4, crime.getPlaceOfCrime());
			pstmt.setInt(5, polStationID);
			int res = pstmt.executeUpdate();
			if (res > 0) {
				System.out.println("Crime Successfully Registered");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went wrong please try again later");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void changeStatusOfCrime(int crimeID, boolean isSolved) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "UPDATE Crime SET solved = ? WHERE crimeId = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			if (isSolved) {
				pstmt.setString(1, "Solved");
			} else {
				pstmt.setString(1, "UnSolved");
			}
			int res = pstmt.executeUpdate();
			if (res <= 0) {
				throw new SomethingWentWrongException("Something Went Wrong Exception");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went wrong please try again later");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addArrestDate(int crimeId, LocalDate date) throws SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "UPDATE Crime SET dateOfArrest = ? WHERE crimeId = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setDate(1, Date.valueOf(date));
			int res = pstmt.executeUpdate();
			if (res <= 0) {
				throw new SomethingWentWrongException("Something Went Wrong Exception");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("No Crime Found with id " + crimeId);
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}

	private Crime getAsCrime(ResultSet rs) throws SQLException {
		Crime crime = new CrimeImpl();
		crime.setCrimeID(rs.getInt("crimeId"));
		crime.setCrimeType(rs.getString("crimeType"));
		crime.setCrimeDesc(rs.getString("crimeDesc"));
		crime.setDateOfCrime(rs.getDate("dateOfCrime").toLocalDate());
		crime.setPlaceOfCrime(rs.getString("place"));
		crime.setSolved(rs.getString("solved").equalsIgnoreCase("solved") ? true : false);
		crime.setPoliceStation(new PoliceStationImpl(rs.getInt("polStationid")));
		if (rs.getDate("dateOfArrest") != null) {
			crime.setDateOfArrest(rs.getDate("dateOfArrest").toLocalDate());
		}
		return crime;
	}

	private Victim getAsVictim(ResultSet rs) throws SQLException {
		Victim victim = null;
		victim.setId(rs.getInt("id"));
		victim.setName(rs.getString("name"));
		return victim;
	}

	@Override
	public Crime getCrimeDetails(int crimeId) throws NoCrimeFoundException, SomethingWentWrongException {
		Crime crime = null;
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "SELECT * FROM Crime WHERE crimeId = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, crimeId);
			ResultSet rs = pstmt.executeQuery();
			if (isResultSetEmpty(rs)) {
				throw new NoCrimeFoundException("No crime with id " + crimeId);
			}
			rs.next();
			crime = getAsCrime(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("No Crime Found with id " + crimeId);
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return crime;
	}

	@Override
	public List<Suspect> getAllSuspectsOfACrime(int crimeId)
			throws NoSuspectFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Criminal> getAllCriminalsOfACrime(int id) throws NoCriminalFoundException, SomethingWentWrongException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Victim> getAllVictimsOfACrime(int crimeId) throws NoVictimFoundException, SomethingWentWrongException {
		return null;
	}

	@Override
	public void transferToANewPoliceStation(int crimeID, String name)
			throws NoPoliceStationFoundException, SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "UPDATE Crime SET polStationid = (select id from policeStation WHERE name like %?%) WHERE crimeId = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setString(1, name);
			pstmt.setInt(2, crimeID);
			int res = pstmt.executeUpdate();
			if (res <= 0) {
				throw new NoPoliceStationFoundException("No Police Station Found Related to name " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went wrong please try again later");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void transferToANewPoliceStation(int crimeID, int polStationId)
			throws NoPoliceStationFoundException, SomethingWentWrongException {
		Connection con = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "UPDATE Crime SET polStationid = ? WHERE crimeId = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, polStationId);
			pstmt.setInt(2, crimeID);
			int res = pstmt.executeUpdate();
			if (res <= 0) {
				throw new NoPoliceStationFoundException("No Police Station Found Exception " + polStationId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went wrong please try again later");
		} finally {
			try {
				DBUtils.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
