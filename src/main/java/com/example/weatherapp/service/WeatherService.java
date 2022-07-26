package com.example.weatherapp.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.weatherapp.entity.WeatherResponse;

@Service
public class WeatherService {
	
	Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	@Value("${spring.datasource.appid}")
	String appid;
	
	@Async
	public synchronized CompletableFuture<WeatherResponse> returnWeatherForACity(String cityName) {
		logger.info("in returnWeatherForACity "+Thread.currentThread().getName());
		logger.info("in returnWeatherForACity run with  "+ cityName);
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName 
				+ "&"+ "appid=" + appid +"&units=metric";
		RestTemplate restTemplate = new RestTemplate();
		logger.info("get data from openweathermap.org");
		WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
		logger.info("returning weatherResponse");
		return CompletableFuture.completedFuture(weatherResponse);
	}
}
