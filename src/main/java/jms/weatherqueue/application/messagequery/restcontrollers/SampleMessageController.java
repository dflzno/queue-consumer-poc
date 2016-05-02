package jms.weatherqueue.application.messagequery.restcontrollers;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jms.weatherqueue.domain.WeatherCondition;

@RestController
public class SampleMessageController {
	
	@RequestMapping(value = "/api/message/sample", method = RequestMethod.GET)
	public WeatherCondition provideExampleData() {
		return new WeatherCondition("23", ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST"))), 28, "Sunny");
	}

}
