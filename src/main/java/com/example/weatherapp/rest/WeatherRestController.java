package com.example.weatherapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.weatherapp.service.WeatherService;

@RestController
@RequestMapping("/api")
public class WeatherRestController {
	
	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/getWeather/{cityName}")
	public Object getWeather(@PathVariable String cityName) {
		return weatherService.returnWeatherForACity(cityName);
	}

}
