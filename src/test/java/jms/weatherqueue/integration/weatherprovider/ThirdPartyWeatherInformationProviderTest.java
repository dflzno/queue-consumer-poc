package jms.weatherqueue.integration.weatherprovider;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import base.TestWithMockito;
import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;

public class ThirdPartyWeatherInformationProviderTest extends TestWithMockito {
	
	@Mock
	private WeatherInformationRestClient restClient;
	
	@InjectMocks
	private ThirdPartyWeatherInformationProvider testSubject;
	
	@Test
	public void shouldReturnAWeatherCondition() {
		// given
		LatitudeLongitudeElevationCoordinate coordinate = new LatitudeLongitudeElevationCoordinate(4.6810316, -74.047626);
		when(restClient.getCurrentWeather(coordinate)).thenReturn(Optional.of(new WeatherCondition("44", ZonedDateTime.now(), 15, "Rainy")));
		
		// when
		Optional<WeatherCondition> weatherCondition = testSubject.getCurrentWeather(coordinate);
		
		// then
		assertNotNull(weatherCondition);
		assertTrue(weatherCondition.isPresent());
	}
}
