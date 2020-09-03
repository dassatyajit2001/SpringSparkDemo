package com.example.SpringSparkdemo2.dao;

public class CassandraDAO implements IDao {

	public CassandraDAO(DBConnection connection) {
		super();
		this.connection = connection;
	}

	DBConnection connection;
	
	public void demoDAOOperation() {
		System.out.println("Demo Dao Operation with DB Connection->"+connection);
	}
}
