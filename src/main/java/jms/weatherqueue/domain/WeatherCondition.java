package jms.weatherqueue.domain;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherCondition {

	@Getter @Setter private String code;
	@Getter @Setter private ZonedDateTime date;
	@Getter @Setter private int temperature;
	@Getter @Setter private String text;
	@Getter @Setter private ZonedDateTime createdAt;
			
	public WeatherCondition(String code, ZonedDateTime date, int temperature, String text) {
		super();
		this.code = code;
		this.date = date;
		this.temperature = temperature;
		this.text = text;
		this.createdAt = ZonedDateTime.now();
	}
}
