package jms.weatherqueue.application.messagequery.restcontrollers.integration;

import jms.weatherqueue.domain.WeatherCondition;

public class WeatherConditionTO {

	private String code;
	private String date;
	private int temperature;
	private String description;
	private String createdAt;
	
	public WeatherConditionTO(String code, String date, int temperature, String description, String createdAt) {
		super();
		this.code = code;
		this.date = date;
		this.temperature = temperature;
		this.description = description;
		this.createdAt = createdAt;
	}
	
	public WeatherConditionTO(WeatherCondition from) {
		this.code = from.getCode();
		this.date = from.getDate().toString();
		this.temperature = from.getTemperature();
		this.description = from.getText();
		this.createdAt = from.getCreatedAt().toString();
	}

	public String getCode() {
		return code;
	}

	public String getDate() {
		return date;
	}

	public int getTemperature() {
		return temperature;
	}

	public String getDescription() {
		return description;
	}

	public String getCreatedAt() {
		return createdAt;
	}
		
}
