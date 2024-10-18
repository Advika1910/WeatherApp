package com.example.WeatherUpdates.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherApiResponse {
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String city;
	@JsonProperty("data")
	private String data;
	
	public WeatherApiResponse() {}
	
	public WeatherApiResponse(String id, String city, String data) {
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
