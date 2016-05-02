package jms.weatherqueue.application.messagequery.restcontrollers;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jms.weatherqueue.application.messagequery.restcontrollers.integration.WeatherConditionTO;

@RestController
public class SampleMessageController {
	
	@RequestMapping(value = "/api/message/sample", method = RequestMethod.GET)
	public ResponseEntity<WeatherConditionTO> provideExampleData() {
		return new ResponseEntity<WeatherConditionTO>(
				new WeatherConditionTO("23", 
						ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST"))).toString(),
						28, 
						"Sunny",
						ZonedDateTime.now().toString()),
				HttpStatus.OK);
	}

}
