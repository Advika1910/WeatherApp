package com.example.WeatherUpdates.dto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "WeatherData")

public class WeatherDataDto {

	@DynamoDBHashKey(attributeName="id")
	
	private String id;
	
	@DynamoDBAttribute
	private String city;
	
	@DynamoDBAttribute
	private String data;

	public WeatherDataDto() {}

	public WeatherDataDto(String id, String city, String data) {
		super();
		this.id = id;
		this.city = city;
		this.data = data;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}



}
