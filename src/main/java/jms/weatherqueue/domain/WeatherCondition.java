package jms.weatherqueue.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WeatherCondition {

	private String code;
	private ZonedDateTime date;
	private int temperature;
	private String text;
	private ZonedDateTime createdAt;
			
	public WeatherCondition(String code, ZonedDateTime date, int temperature, String text, ZonedDateTime createdAt) {
		super();
		this.code = code;
		this.date = date;
		this.temperature = temperature;
		this.text = text;
		this.createdAt = createdAt;
	}
}
