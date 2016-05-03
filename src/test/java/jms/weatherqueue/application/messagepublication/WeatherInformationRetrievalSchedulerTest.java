package jms.weatherqueue.application.messagepublication;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.Test;

import base.TestWithMockito;
import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;

public class WeatherInformationRetrievalSchedulerTest extends TestWithMockito {

	@Mock
	private WeatherInformationProvider weatherInfoProvider;
	
	@InjectMocks
	private WeatherInformationRetrievalScheduler testSuject;
	
	@Test
	public void shouldRetrieveSomeWeatherInformation() {
		// given
		/* No assumptions */
		
		// when
		testSuject.execute();
		
		// then
		verify(weatherInfoProvider, times(1)).getCurrentWeather(any(LatitudeLongitudeElevationCoordinate.class));
	}
}
