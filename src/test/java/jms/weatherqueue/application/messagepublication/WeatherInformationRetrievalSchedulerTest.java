package jms.weatherqueue.application.messagepublication;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import base.TestWithMockito;
import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;

public class WeatherInformationRetrievalSchedulerTest extends TestWithMockito {

	@Mock
	private WeatherInformationProvider weatherInfoProvider;
	
	@Mock
	private JmsMessageSender jmsSender;
	
	@InjectMocks
	private WeatherInformationRetrievalScheduler testSubject;
	
	@Test
	public void shouldInvokeWeatherInformationProvider() {
		// given
		when(weatherInfoProvider.getCurrentWeather(any(LatitudeLongitudeElevationCoordinate.class))).thenReturn(Optional.empty());
		
		// when
		testSubject.execute();
		
		// then
		verify(weatherInfoProvider, times(1)).getCurrentWeather(any(LatitudeLongitudeElevationCoordinate.class));
	}
	
	@Test
	public void shouldInvokeJmsSenderBecauseAWeatherConditionWasRetrieved() {
		// given
		WeatherCondition weatherCondition = new WeatherCondition("44", ZonedDateTime.now(), 15, "Rainy", ZonedDateTime.now());
		when(weatherInfoProvider.getCurrentWeather(any(LatitudeLongitudeElevationCoordinate.class))).
			thenReturn(Optional.of(weatherCondition));
		
		// when
		testSubject.execute();
		
		// then
		verify(jmsSender, times(1)).send(weatherCondition.toString());
	}
	
	@Test
	public void shouldNotInvokeJmsSenderBecauseNoWeatherConditionWasRetrieved() {
		// given
		when(weatherInfoProvider.getCurrentWeather(any(LatitudeLongitudeElevationCoordinate.class))).thenReturn(Optional.empty());
		
		// when
		testSubject.execute();
		
		// then
		verify(jmsSender, never()).send(anyString());
	}
}
