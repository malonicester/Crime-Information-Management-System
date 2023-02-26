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
import com.crime.dto.Criminal;
import com.crime.dto.CriminalImpl;
import com.crime.dto.PoliceStationImpl;
import com.crime.exception.NoCrimeFoundException;
import com.crime.exception.NoCriminalFoundException;
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
	public void assignCrimeToCriminal(int crimeId, int criminalID) throws NoCrimeFoundException {
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

	private Crime getAsCrime(ResultSet rs) throws SQLException {
		Crime crime = new CrimeImpl();
		crime.setCrimeID(rs.getInt("crimeId"));
		crime.setCrimeType(rs.getString("crimeType"));
		crime.setCrimeDesc(rs.getString("crimeDesc"));
		crime.setDateOfCrime(rs.getDate("dateOfCrime").toLocalDate());
		crime.setPlaceOfCrime(rs.getString("place"));
		crime.setSolved(rs.getString("solved").equalsIgnoreCase("solved") ? true : false);
		crime.setPoliceStation(new PoliceStationImpl(rs.getString("name")));
		if (rs.getDate("dateOfArrest") != null) {
			crime.setDateOfArrest(rs.getDate("dateOfArrest").toLocalDate());
		}
		return crime;
	}

	private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
		return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}

	@Override
	public List<Crime> getRecordOfCriminal(int criminalId) throws NoCrimeFoundException {
		Connection con = null;
		List<Crime> list = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "select C.crimeId,C.crimeType,C.crimedesc,C.dateOfCrime,C.place,C.solved,C.polStationId,C.dateOfArrest,P.Name from criminalInvolvedInCrime CI INNER JOIN Crime C ON CI.crimeId = C.crimeid INNER JOIN PoliceStation P ON C.polStationId = P.id WHERE CI.criminalId = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, criminalId);
			ResultSet rs = pstmt.executeQuery();
			if (isResultSetEmpty(rs)) {
				throw new NoCrimeFoundException("No Crime Found For criminal with  id" + criminalId);
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

	private Criminal getAsCriminal(ResultSet rs) throws SQLException {
		Criminal criminal = new CriminalImpl();
		criminal.setCriminalId(rs.getInt("criminalId"));
		criminal.setCriminalName(rs.getString("Criminalname"));
		criminal.setAge(rs.getInt("age"));
		criminal.setGender(rs.getString("gender"));
		criminal.setIdentificationMark(rs.getString("identMark"));
		criminal.setOccupation(rs.getString("occupation"));
		criminal.setAreaOfFirstArrested(rs.getString("areaOfFirstArrested"));
		return criminal;
	}

	@Override
	public Criminal getCriminalDetails(int criminalId) throws NoCriminalFoundException {
		Connection con = null;
		Criminal criminal = null;
		try {
			con = DBUtils.connectToDatabase();
			String QUERY = "select * from criminal where criminalid = ?";
			PreparedStatement pstmt = con.prepareStatement(QUERY);
			pstmt.setInt(1, criminalId);
			ResultSet rs = pstmt.executeQuery();
			if (isResultSetEmpty(rs)) {
				throw new NoCriminalFoundException("No Crime Found For criminal with  id" + criminalId);
			}
			rs.next();
			criminal = getAsCriminal(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criminal;
	}

}
