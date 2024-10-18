package com.weather.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.weather.data.model.WeatherData;

@Repository
public class WeatherDataRepository {
	 @Autowired
	    private DynamoDBMapper dynamoDBMapper;

	    public void save(WeatherData weatherData) {
	        dynamoDBMapper.save(weatherData);
	    }
	  
}
