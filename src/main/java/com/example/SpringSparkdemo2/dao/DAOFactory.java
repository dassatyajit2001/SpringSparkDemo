package com.example.SpringSparkdemo2.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component(value="daofactory")
public class DAOFactory {

	Map<String, CassandraDAO> cacheDaos = new HashMap<>();

	public CassandraDAO getDAO(String datasource) {
		return cacheDaos.computeIfAbsent(datasource, t -> new CassandraDAO(new DBConnection(datasource)));
	}
}
