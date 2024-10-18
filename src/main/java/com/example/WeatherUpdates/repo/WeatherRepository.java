package com.example.WeatherUpdates.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.WeatherUpdates.dto.WeatherDataDto;

@Repository
public class WeatherRepository {
	
	 @Autowired
	    DynamoDBMapper dynamoDBMapper;
	 
	 public void save(WeatherDataDto data) {
		 dynamoDBMapper.save(data);
	 }
	 
	 public void saveToDynamoDB(WeatherDataDto weatherData) {
	        dynamoDBMapper.save(weatherData);
	    }

}
