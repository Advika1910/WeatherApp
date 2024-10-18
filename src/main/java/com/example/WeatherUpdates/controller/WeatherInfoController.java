package com.example.WeatherUpdates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.WeatherUpdates.dto.WeatherDataDto;
import com.example.WeatherUpdates.service.WeatherDataService;


@RestController
@RequestMapping("/weather")
public class WeatherInfoController {
	
	
	  @Autowired 
	  WeatherDataService weatherDataService;
	 
	

	@GetMapping("/{city}")
	public ResponseEntity<WeatherDataDto> getWeatherData(@PathVariable String city){
		WeatherDataDto weatherData=weatherDataService.getWeatherData(city);
		return ResponseEntity.ok(weatherData);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<WeatherDataDto> getWeatherDatatwo(@RequestBody String city){
		WeatherDataDto weatherData=weatherDataService.getWeatherData(city);
		return ResponseEntity.ok(weatherData);
		
	}

}
