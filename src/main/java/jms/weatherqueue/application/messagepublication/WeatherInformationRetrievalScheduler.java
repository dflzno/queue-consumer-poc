package jms.weatherqueue.application.messagepublication;

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
	private static final int DELAY = 1000*60;
	
	@Autowired
	private WeatherInformationProvider weatherInfoProvider;
	
	@Autowired
	private JmsMessageSender jmsSender;
	
	private PayloadTransformerIntoText<WeatherCondition> transformer = new WeatherConditionToXML();
	
	@Scheduled(fixedDelay = DELAY)
	public void execute() {
		Optional<WeatherCondition> weatherCondition = 
				weatherInfoProvider.getCurrentWeather(new LatitudeLongitudeElevationCoordinate(LATITUDE, LONGITUDE));
		log.debug("Weather information retrieved: " + (weatherCondition.isPresent() ? weatherCondition.get() : "NONE"));
		
		if(weatherCondition.isPresent()) {
			Optional<String> xmlRepresentation = transformer.apply(weatherCondition.get());
			if(xmlRepresentation.isPresent()) {
				jmsSender.send(xmlRepresentation.get());
			} else {
				log.debug("Skipping message publication...");
			}
		} else {
			log.debug("Skipping message publication...");
		}
	}
	
	/**
	 * Reconfigures the {@link WeatherInformationProvider} in runtime
	 * @param provider the new {@link WeatherInformationProvider} to be used
	 */
	public void setWeatherInformationProvider(WeatherInformationProvider provider) {
		this.weatherInfoProvider = provider;
	}
	
	
	/**
	 * Reconfigures the {@link PayloadTransformerIntoText} object in runtime
	 * @param transformer the new {@link PayloadTransformerIntoText}
	 */
	public void setPayloadTransformer(PayloadTransformerIntoText<WeatherCondition> transformer) {
		this.transformer = transformer;
	}
}
