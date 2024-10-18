package com.example.WeatherUpdates.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.WeatherUpdates.dto.WeatherDataDto;
import com.example.WeatherUpdates.entity.WeatherApiResponse;
import com.example.WeatherUpdates.repo.WeatherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class WeatherDataServiceImpl implements WeatherDataService {

	@Autowired
	WeatherRepository weatherRepo;

	@Autowired
	ObjectMapper objectMapper;


	RestTemplate rs=new RestTemplate();

	private String api_url="http://api.openweathermap.org/data/2.5/weather";
	private String api_key="6a377fb194798a72c56f9119b5261d0a";

	private WeatherDataDto mapToWeatherData(WeatherApiResponse apiResponse,String city) {
		String url = String.format("%s?q=%s&appid=%s", api_url, city, api_key);
		WeatherDataDto weatherData = new WeatherDataDto();
		weatherData.setId(apiResponse.getId());
		weatherData.setCity(apiResponse.getCity());
		weatherData.setData(rs.getForObject(url, String.class));
		// Additional mapping logic
		return weatherData;
	}

	@Override
	public WeatherDataDto getWeatherData(String city) {
		String url = String.format("%s?q=%s&appid=%s", api_url, city, api_key);


		ResponseEntity<String> response = rs.getForEntity(url, String.class);
		System.out.println(response); 
		try { WeatherApiResponse apiResponse =
				objectMapper.readValue(response.getBody(), WeatherApiResponse.class);
		String	jsonString = objectMapper.writeValueAsString(apiResponse);
		System.out.println(jsonString); 
		WeatherDataDto weatherData =mapToWeatherData(apiResponse,city);
		weatherRepo.saveToDynamoDB(weatherData);
		return weatherData; 
		} catch (IOException e) { throw new
			RuntimeException("Error parsing weather API response", e); 
		}


	}

}
