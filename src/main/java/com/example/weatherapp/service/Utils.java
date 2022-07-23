package com.example.weatherapp.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.example.weatherapp.entity.Inputdata;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
	
	public static List<Inputdata> getDataFromJsonFile() {
		
		final String JSON_DATA = "/citys.json";
		
		TypeReference<List<Inputdata>> typeReference = new TypeReference<List<Inputdata>>() {
		};
		
		InputStream inputStream = TypeReference.class.getResourceAsStream(JSON_DATA);
		List<Inputdata> data = null;
		try {
			data = new ObjectMapper().readValue(inputStream, typeReference);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(data);
		return data;
		
	}

}
