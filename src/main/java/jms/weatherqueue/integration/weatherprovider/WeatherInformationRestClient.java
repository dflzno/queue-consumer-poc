package jms.weatherqueue.integration.weatherprovider;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;

@Component
public class WeatherInformationRestClient {
	
	public static final String WEATHER_SERVICE_URL = "https://goo.gl/lgqHBz";
	
	@Autowired
	private RestTemplate restTemplate;

	Optional<WeatherCondition> getCurrentWeather(LatitudeLongitudeElevationCoordinate coordinate) {
		
		Optional<WeatherCondition> result = null;
		
		try {
			WeatherCondition response = restTemplate.getForEntity(URI.create(WEATHER_SERVICE_URL), WeatherCondition.class).getBody();
			result = Optional.of(response);
		} catch (RestClientException ex) {
			result = Optional.empty();
		}
		
		return result;
	}

}
