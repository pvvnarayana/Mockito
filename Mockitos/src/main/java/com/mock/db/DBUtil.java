package com.mock.db;

public class DBUtil {

	private String driverClass;
	private String jndiURL;
	private String userName;
	private String password;
	
	
	
	public static  DBUtil getConnection() {
		// logic to create a connection
		return new DBUtil();
	}
	
}

