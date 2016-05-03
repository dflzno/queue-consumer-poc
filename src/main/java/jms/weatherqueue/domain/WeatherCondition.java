package jms.weatherqueue.domain;

import java.time.ZonedDateTime;

import lombok.Getter;

public class WeatherCondition {

	@Getter private String code;
	@Getter private ZonedDateTime date;
	@Getter private int temperature;
	@Getter private String text;
	@Getter private ZonedDateTime createdAt;
		
	public WeatherCondition(String code, ZonedDateTime date, int temperature, String text) {
		super();
		this.code = code;
		this.date = date;
		this.temperature = temperature;
		this.text = text;
		this.createdAt = ZonedDateTime.now();
	}
}
