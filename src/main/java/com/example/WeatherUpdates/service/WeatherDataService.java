package com.example.WeatherUpdates.service;

import com.example.WeatherUpdates.dto.WeatherDataDto;

public interface WeatherDataService {
	
	public WeatherDataDto getWeatherData(String city);

}
