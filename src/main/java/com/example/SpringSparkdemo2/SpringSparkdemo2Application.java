package com.example.SpringSparkdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.SpringSparkdemo2.service.ISparkService;

@SpringBootApplication
public class SpringSparkdemo2Application {// implements CommandLineRunner {

	@Autowired
	static ISparkService service;
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringSparkdemo2Application.class, args);
		System.out.println(applicationContext.getBean("myservice"));
		((ISparkService) applicationContext.getBean("myservice")).execute("demo");
	}
}
