package com.example.SpringSparkdemo2.configbuilder;

import org.springframework.stereotype.Component;

@Component
public interface IConfigBuilder {
	public void buildConfig(String value);
}
