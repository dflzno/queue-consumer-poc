package jms.weatherqueue.integration.weatherprovider;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WeatherInformationRestClient {
	
	public static final String WEATHER_SERVICE_URL = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22dallas%2C%20tx%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
	
	@Autowired
	private RestTemplate restTemplate;

	Optional<WeatherCondition> getCurrentWeather(LatitudeLongitudeElevationCoordinate coordinate) {
		
		Optional<WeatherCondition> result = Optional.empty();
		
		log.debug(" -- About to print HttpMessageConverters for RestTemplate:");
		for(HttpMessageConverter<?> converter : restTemplate.getMessageConverters()) {
			log.debug(converter.toString() + " " + converter.getSupportedMediaTypes());
		}
		log.debug("Done printing!!!");
		
		try {
			WeatherCondition response = restTemplate.getForEntity(URI.create(WEATHER_SERVICE_URL), WeatherCondition.class).getBody();
			result = Optional.of(response);
			log.debug(response.toString());
		} catch (RestClientException ex) {
			result = Optional.empty();
			log.error("Exception while retrieving weather information.", ex);
		}
		
		return result;
	}

}
