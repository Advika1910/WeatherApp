package com.weather.data;

import java.util.Map;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.weather.data.model.WeatherData;
import com.weather.data.service.WeatherService;

public class WeatherLambdaHandler implements RequestHandler<Map<String, String>, APIGatewayProxyResponseEvent> {
	private final WeatherService weatherService = new WeatherService();
    private final AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.defaultClient();
    private final DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

    public APIGatewayProxyResponseEvent handleRequest(Map<String, String> event, Context context) {
    	APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
    	 try {
             String city = event.get("city");
             if (city == null || city.isEmpty()) {
                 response.setStatusCode(400);
                 response.setBody("City parameter is missing");
                 return response;
             }

             String weatherData = weatherService.getWeather(city);
             WeatherData data = new WeatherData();
             data.setId(UUID.randomUUID().toString());
             data.setCity(city);
             data.setData(weatherData);
             mapper.save(data);

             response.setStatusCode(200);
             response.setBody(weatherData);
         } catch (Exception e) {
             response.setStatusCode(500);
             response.setBody("An error occurred: " + e.getMessage());
         }
         return response;
    }
}
