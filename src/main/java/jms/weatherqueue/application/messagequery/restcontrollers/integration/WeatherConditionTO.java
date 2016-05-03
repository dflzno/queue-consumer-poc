package jms.weatherqueue.application.messagequery.restcontrollers.integration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jms.weatherqueue.domain.WeatherCondition;
import lombok.Getter;

@XmlRootElement(name = "weathercondition")
public class WeatherConditionTO {

	@Getter @XmlElement private String code;
	@Getter @XmlElement private String date;
	@Getter @XmlElement private int temperature;
	@Getter @XmlElement private String description;
	@Getter @XmlElement private String createdAt;
	
	public WeatherConditionTO() { }
	
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
		
}
