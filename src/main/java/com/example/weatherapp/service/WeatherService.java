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
	
	@Value("${spring.datasource.appid}")
	String appid;
	
	Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	public WeatherResponse returnWeatherForACity(String cityName) {
		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName 
				+ "&"+ "appid=" + appid +"&units=metric";
		RestTemplate restTemplate = new RestTemplate();
		WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
		return weatherResponse;
	}
	
//	//@Async
//	public CompletableFuture<WeatherResponse> returnWeatherForACity(String cityName) {
//		logger.info("get WeatherResponse by " + Thread.currentThread().getName());
////		String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName 
////				+ "&"+ "appid=" + appid +"&units=metric";
//		String url = "https://api.openweathermap.org/data/2.5/weather?q=London&appid=e735b6b632e6c008be941b8dbdb346d4&units=metric";
//		RestTemplate restTemplate = new RestTemplate();
//		WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
//		return CompletableFuture.completedFuture(weatherResponse);
//	}
}
