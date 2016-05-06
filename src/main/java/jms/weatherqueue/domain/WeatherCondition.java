package jms.weatherqueue.domain;

import java.time.ZonedDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import jms.weatherqueue.application.integration.adapters.WeatherConditionXmlAdapter;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@XmlJavaTypeAdapter(WeatherConditionXmlAdapter.class)
public class WeatherCondition {

	private final String code;
	private final ZonedDateTime date;
	private final int temperature;
	private final String text;
	private final ZonedDateTime createdAt;
			
	public WeatherCondition(String code, ZonedDateTime date, int temperature, String text, ZonedDateTime createdAt) {
		super();
		this.code = code;
		this.date = date;
		this.temperature = temperature;
		this.text = text;
		this.createdAt = createdAt;
	}
}
