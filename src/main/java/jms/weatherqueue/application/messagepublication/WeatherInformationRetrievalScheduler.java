package jms.weatherqueue.application.messagepublication;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WeatherInformationRetrievalScheduler {
	
	private static final double LATITUDE = 32.762861;
	private static final double LONGITUDE = -96.797954;
	private static final int DELAY = 5000;
	
	@Autowired
	private WeatherInformationProvider weatherInfoProvider;
	
	@Scheduled(fixedDelay = DELAY)
	public void execute() {
		log.debug("Running scheduled job at " + LocalDateTime.now());
		Optional<WeatherCondition> weatherCondition = 
				weatherInfoProvider.getCurrentWeather(new LatitudeLongitudeElevationCoordinate(LATITUDE, LONGITUDE));
		log.error("Weather information: " + weatherCondition.orElse(null));
	}
}
