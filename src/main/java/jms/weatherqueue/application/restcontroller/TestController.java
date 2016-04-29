package jms.weatherqueue.application.restcontroller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jms.weatherqueue.domain.WeatherCondition;

@RestController
public class TestController {
	
	@RequestMapping("/api/example")
	public WeatherCondition provideExampleData() {
		return new WeatherCondition("23", ZonedDateTime.now(ZoneId.of("CST")), 28, "Sunny");
	}

}
