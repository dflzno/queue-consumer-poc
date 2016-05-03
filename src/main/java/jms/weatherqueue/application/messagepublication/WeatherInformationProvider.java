package jms.weatherqueue.application.messagepublication;

import java.util.Optional;

import jms.weatherqueue.domain.LatitudeLongitudeElevationCoordinate;
import jms.weatherqueue.domain.WeatherCondition;

public interface WeatherInformationProvider {
	
	Optional<WeatherCondition> getCurrentWeather(LatitudeLongitudeElevationCoordinate coordinate);
}
