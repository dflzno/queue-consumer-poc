package jms.weatherqueue.integration.weatherprovider.yahoo;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.Optional;

import org.testng.annotations.Test;

import jms.weatherqueue.domain.WeatherCondition;
import jms.weatherqueue.integration.weatherprovider.ToWeatherConditionConverter;
import suppport.builders.WeatherInformationResourceTestBuilder;

public class FromYahooWeatherToWeatherConditionTest {

	private ToWeatherConditionConverter<WeatherInformationResource> testSubject = new FromYahooWeatherToWeatherCondition();
	
	@Test
	public void shouldReturnANewWeatherCondition() {
		// given
		WeatherInformationResource resource = WeatherInformationResourceTestBuilder.build();
		
		// when
		Optional<WeatherCondition> condition = testSubject.apply(resource);
		
		// then
		assertTrue(condition.isPresent());
	}
	
	@Test
	public void allWeatherConditionFieldsShouldBePresent() {
		// given
		WeatherInformationResource resource = WeatherInformationResourceTestBuilder.build();
		
		// when
		Optional<WeatherCondition> condition = testSubject.apply(resource);
		
		// then
		assertNotNull(condition.get().getCode());
		assertNotNull(condition.get().getCreatedAt());
		assertNotNull(condition.get().getDate());
		assertNotNull(condition.get().getTemperature());
		assertNotNull(condition.get().getText());
	}	
}
