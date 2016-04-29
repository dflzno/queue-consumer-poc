package jms.weatherqueue.domain;

import java.time.ZonedDateTime;

public class WeatherCondition {

	private String code;
	private ZonedDateTime date;
	private int temperature;
	private String text;
	private ZonedDateTime createdAt;
		
	public WeatherCondition(String code, ZonedDateTime date, int temperature, String text) {
		super();
		this.code = code;
		this.date = date;
		this.temperature = temperature;
		this.text = text;
		this.createdAt = ZonedDateTime.now();
	}

	public String getCode() {
		return code;
	}
	
	public ZonedDateTime getDate() {
		return date;
	}
	
	public int getTemperature() {
		return temperature;
	}
	
	public String getText() {
		return text;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}	
}
