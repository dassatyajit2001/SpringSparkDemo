package com.example.SpringSparkdemo2.configbuilder;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SpringSparkdemo2.dao.DAOFactory;

@Component(value = "dbconfig")
public class DBConfigBuilder implements IConfigBuilder {

	@Autowired
	DAOFactory daofactory;

	@Override
	public void buildConfig(String value) {
		Stream.of(value.split(",")).forEach(n -> daofactory.getDAO(n));
		System.out.println(daofactory.getDAO("btec"));
	}

}
