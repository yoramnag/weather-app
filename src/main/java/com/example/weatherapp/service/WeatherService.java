package com.example.weatherapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherapp.entity.WeatherResponse;

@Service
public class WeatherService {
	
	@Value("${spring.datasource.appid}")
	String appid;
	
	public WeatherResponse returnWeatherForACity(String cityName) {
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName 
				+ "&"+ "appid=" + appid +"&units=metric";
		RestTemplate restTemplate = new RestTemplate();
		WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
		return weatherResponse;
	}
}
