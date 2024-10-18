package com.weather.data.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.data.model.WeatherData;
import com.weather.data.repository.WeatherDataRepository;
import com.weather.data.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataRepository weatherDataRepository;

	@Autowired
	private WeatherService weatherService;

	@GetMapping("/{city}")
	public ResponseEntity<String> getWeatherDataById(@PathVariable String city) {
		String weatherData = weatherService.getWeather(city);
		WeatherData data = new WeatherData();
		String id = UUID.randomUUID().toString();
		// UUID id = UUID.randomUUID();
		data.setId(id);
		data.setCity(city);
		data.setData(weatherData);
		weatherDataRepository.save(data);
		return ResponseEntity.ok(weatherData);
	}

}
