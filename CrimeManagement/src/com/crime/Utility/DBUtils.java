package com.crime.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	static final String URL;
	static final String user;
	static final String password;

	static {
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
		URL = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection connectToDatabase() throws SQLException {
		return DriverManager.getConnection(URL, user, password);
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}
