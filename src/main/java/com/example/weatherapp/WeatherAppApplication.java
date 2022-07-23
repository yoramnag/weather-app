package com.example.weatherapp;



import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.weatherapp.entity.Inputdata;
import com.example.weatherapp.service.Utils;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class WeatherAppApplication {

	public static void main(String[] args)  {
		SpringApplication.run(WeatherAppApplication.class, args);
		
		Utils.getDataFromJsonFile();
		
		
	}
	
	

}
