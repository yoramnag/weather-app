package com.example.weatherapp.rest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.weatherapp.entity.Inputdata;
import com.example.weatherapp.entity.WeatherResponse;
import com.example.weatherapp.service.Utils;
import com.example.weatherapp.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	private List<Inputdata> data = Utils.getDataFromJsonFile();
	
	@GetMapping(value="/getWeather/{cityName}",produces="application/json")
	public CompletableFuture<ResponseEntity> getWeather(@PathVariable String cityName) {
		return weatherService.returnWeatherForACity(cityName).thenApply(ResponseEntity::ok);
	}
	
	@GetMapping(value="/getWeatherThread",produces="application/json")
	public ResponseEntity getWeatherThread() {
		CompletableFuture<WeatherResponse> weatherThread1 = weatherService.returnWeatherForACity(data.get(0).getCityName());
		CompletableFuture<WeatherResponse> weatherThread2 = weatherService.returnWeatherForACity(data.get(1).getCityName());
		CompletableFuture<WeatherResponse> weatherThread3 = weatherService.returnWeatherForACity(data.get(2).getCityName());
		CompletableFuture.allOf(weatherThread1,weatherThread2,weatherThread3);
		return ResponseEntity.status(HttpStatus.OK).build();
		
	}

}
