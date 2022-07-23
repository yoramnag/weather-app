package com.example.weatherapp.entity;

public class Inputdata {
	
	private int cityId;
	private String cityName;
	private int frequency;
	private int threshold;
	
	
	public Inputdata() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Inputdata(int cityId, String cityName, int frequency, int threshold) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.frequency = frequency;
		this.threshold = threshold;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public int getFrequency() {
		return frequency;
	}


	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}


	public int getThreshold() {
		return threshold;
	}


	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}


	@Override
	public String toString() {
		return "Inputdata [cityId=" + cityId + ", cityName=" + cityName + ", frequency=" + frequency + ", threshold="
				+ threshold + "]";
	}
	 
	
}
