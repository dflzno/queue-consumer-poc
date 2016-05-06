package jms.weatherqueue.application.integration.adapters;

import java.time.ZonedDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import jms.weatherqueue.application.integration.entities.WeatherConditionTO;
import jms.weatherqueue.domain.WeatherCondition;

public class WeatherConditionXmlAdapter extends XmlAdapter<WeatherConditionTO, WeatherCondition> {

	@Override
	public WeatherCondition unmarshal(WeatherConditionTO from) throws Exception {
		return new WeatherCondition(
				from.getCode(), 
				ZonedDateTime.parse(from.getDate()),
				from.getTemperature(), 
				from.getDescription(), 
				ZonedDateTime.parse(from.getCreatedAt()));
	}

	@Override
	public WeatherConditionTO marshal(WeatherCondition from) throws Exception {
		return new WeatherConditionTO(from);
	}

}
