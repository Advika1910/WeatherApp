package com.weather.data.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.data.model.WeatherData;
import com.weather.data.repository.WeatherDataRepository;

@Service
public class WeatherService {
	
	
	private static final String API_KEY = "a1c596747ce1d063f6df34fd6fa77498";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?q=%s&appid=%s", BASE_URL, city, API_KEY);
        return restTemplate.getForObject(url, String.class);
    }

	
}
