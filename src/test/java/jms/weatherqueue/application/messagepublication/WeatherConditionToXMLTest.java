package jms.weatherqueue.application.messagepublication;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.testng.annotations.Test;

import jms.weatherqueue.domain.WeatherCondition;

public class WeatherConditionToXMLTest {
	
	private PayloadTransformerIntoText<WeatherCondition> testSubject = new WeatherConditionToXML();

	@Test
	public void shouldReturnAnXmlRepresentationOfAWeatherCondition() {
		// given
		WeatherCondition weatherCondition = new WeatherCondition("012", ZonedDateTime.now(), 20, "Sunny", ZonedDateTime.now().minusDays(1));
		
		// when
		Optional<String> response = testSubject.apply(weatherCondition);
		
		// then
		assertTrue(response.isPresent());
	}
	
	@Test
	public void shouldReturnEmptyBecauseOfNPE() {
		// given
		WeatherCondition weatherCondition = null;
		
		// when
		Optional<String> response = testSubject.apply(weatherCondition);
		
		// then
		assertFalse(response.isPresent());
	}
}
