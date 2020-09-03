package com.example.SpringSparkdemo2.dao;

public class DBConnection {
	public DBConnection(String connection) {
		super();
		Connection = connection;
	}

	String Connection;

	/**
	 * @return the connection
	 */
	public String getConnection() {
		return Connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(String connection) {
		Connection = connection;
	}

}
