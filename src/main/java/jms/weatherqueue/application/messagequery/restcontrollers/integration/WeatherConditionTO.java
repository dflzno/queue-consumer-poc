package jms.weatherqueue.application.messagequery.restcontrollers.integration;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jms.weatherqueue.domain.WeatherCondition;

@XmlRootElement(name = "weathercondition")
public class WeatherConditionTO {

	private String code;
	private String date;
	private int temperature;
	private String description;
	private String createdAt;
	
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

	@XmlElement
	public String getCode() {
		return code;
	}

	@XmlElement
	public String getDate() {
		return date;
	}

	@XmlElement
	public int getTemperature() {
		return temperature;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	@XmlElement
	public String getCreatedAt() {
		return createdAt;
	}
		
}
