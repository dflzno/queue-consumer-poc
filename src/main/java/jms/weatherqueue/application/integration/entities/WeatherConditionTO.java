package jms.weatherqueue.application.integration.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jms.weatherqueue.domain.WeatherCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@XmlRootElement(name = "weathercondition")
@NoArgsConstructor
@AllArgsConstructor
public class WeatherConditionTO {

	@Getter @XmlElement private String code;
	@Getter @XmlElement private String date;
	@Getter @XmlElement private int temperature;
	@Getter @XmlElement private String description;
	@Getter @XmlElement private String createdAt;
	
	public WeatherConditionTO(WeatherCondition from) {
		this.code = from.getCode();
		this.date = from.getDate().toString();
		this.temperature = from.getTemperature();
		this.description = from.getText();
		this.createdAt = from.getCreatedAt().toString();
	}
		
}
