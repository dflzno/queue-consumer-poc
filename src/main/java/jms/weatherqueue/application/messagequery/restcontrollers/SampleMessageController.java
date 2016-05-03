package jms.weatherqueue.application.messagequery.restcontrollers;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jms.weatherqueue.application.messagequery.restcontrollers.integration.WeatherConditionTO;
import jms.weatherqueue.domain.WeatherCondition;

@RestController
public class SampleMessageController {
	
	@RequestMapping(value = "/api/message/sample", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WeatherConditionTO> provideSampleDataAsJson() {
		return new ResponseEntity<WeatherConditionTO>(new WeatherConditionTO(buildSampleData()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/message/sample.xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<WeatherConditionTO> provideSampleDataAsXml() {
		return new ResponseEntity<WeatherConditionTO>(new WeatherConditionTO(buildSampleData()), HttpStatus.OK);
	}
	
	private WeatherCondition buildSampleData() {
		return new WeatherCondition(
				"23", 
				ZonedDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("CST"))),
				28, 
				"Sunny");
	}

}
