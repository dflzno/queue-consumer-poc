package jms.weatherqueue.integration.weatherprovider.yahoo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jms.weatherqueue.application.messagepublication.WeatherInformationProvider;
import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;

@Service
public class ThirdPartyWeatherInformationProvider implements WeatherInformationProvider {
	
	@Autowired
	private WeatherInformationRestClient restClient;

	@Override
	public Optional<WeatherCondition> getCurrentWeather(LatitudeLongitudeElevationCoordinate coordinate) {
		return restClient.getCurrentWeather(coordinate);
	}

}
