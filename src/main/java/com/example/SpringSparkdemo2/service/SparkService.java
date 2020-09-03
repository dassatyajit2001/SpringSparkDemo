package com.example.SpringSparkdemo2.service;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.SpringSparkdemo2.configbuilder.IConfigBuilder;

import scala.Tuple2;

@Component(value = "myservice")
public class SparkService implements ISparkService {
	@Autowired
	@Qualifier("dbconfig")
	IConfigBuilder dbConfig;

	@Autowired
	@Qualifier("jobconfig")
	IConfigBuilder jobConfig;

	@Override
	public void execute(String args) {
		buildConfigs();
		executeJob();
		jobConfig.buildConfig("demo");
	}

	public void buildConfigs() {
		dbConfig.buildConfig("btec,cmefo");
		jobConfig.buildConfig("demo");
	}

	public void executeJob() {
		SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("JD Word Counter");
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		JavaRDD<String> inputFile = sparkContext.textFile("/Users/satyajitdas/Downloads/SpringSparkdemo2/src/main/resources/input.txt");
		JavaRDD<String> wordsFromFile = inputFile.flatMap(content -> Arrays.asList(content.split(" ")).iterator());
		JavaPairRDD countData = wordsFromFile.mapToPair(t -> new Tuple2(t, 1)).reduceByKey((x, y) -> (int) x + (int) y);

		countData.saveAsTextFile("/Users/satyajitdas/Downloads/SpringSparkdemo2/src/main/resources/CountData");
		sparkContext.stop();
	}
}
