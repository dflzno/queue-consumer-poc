package jms.weatherqueue.integration.weatherprovider.yahoo;

import static jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationRestClient.WEATHER_SERVICE_URL;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.net.URI;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

import base.TestWithMockito;
import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;
import suppport.builders.WeatherInformationResourceTestBuilder;

public class WeatherInformationRestClientTest extends TestWithMockito {

	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private WeatherInformationRestClient testSubject;
	
	@Test
	public void shouldReturnAWeatherCondition() {
		// given
		LatitudeLongitudeElevationCoordinate coordinate = new LatitudeLongitudeElevationCoordinate(4.6810316, -74.047626);
		
		when(restTemplate.getForEntity(URI.create(WEATHER_SERVICE_URL), WeatherInformationResource.class)).
			thenReturn(new ResponseEntity<WeatherInformationResource>(WeatherInformationResourceTestBuilder.build(), HttpStatus.OK));
		
		// when
		Optional<WeatherCondition> weatherCondition = testSubject.getCurrentWeather(coordinate);
		
		// then
		assertNotNull(weatherCondition);
		assertTrue(weatherCondition.isPresent());
	}
	
	@Test
	public void shouldReturnAnEmptyResponseDueToAnException() {
		// given
		LatitudeLongitudeElevationCoordinate coordinate = null;
		when(restTemplate.getForEntity(URI.create(WEATHER_SERVICE_URL), WeatherInformationResource.class)).thenThrow(new RestClientException("Some weird HTTP error."));
		
		// when
		Optional<WeatherCondition> weatherCondition = testSubject.getCurrentWeather(coordinate);
		
		// then
		assertNotNull(weatherCondition);
		assertFalse(weatherCondition.isPresent());
	}
}
