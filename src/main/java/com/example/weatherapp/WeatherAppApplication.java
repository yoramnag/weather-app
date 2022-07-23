package com.example.weatherapp;



import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.weatherapp.entity.Inputdata;
import com.example.weatherapp.service.Utils;


@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args)  {
		SpringApplication.run(WeatherAppApplication.class, args);
		
		List<Inputdata> data = Utils.getDataFromJsonFile();
		System.out.println(data);
		
		
	}
	
	

}
