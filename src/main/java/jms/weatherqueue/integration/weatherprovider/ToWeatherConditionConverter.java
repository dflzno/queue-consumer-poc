package jms.weatherqueue.integration.weatherprovider;

import java.util.Optional;
import java.util.function.Function;

import jms.weatherqueue.domain.WeatherCondition;

public interface ToWeatherConditionConverter<T> extends Function<T, Optional<WeatherCondition>> {

}
