package jms.weatherqueue.application.messagepublication;

import java.io.StringWriter;
import java.util.Optional;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import jms.weatherqueue.application.integration.adapters.WeatherConditionXmlAdapter;
import jms.weatherqueue.application.integration.entities.WeatherConditionTO;
import jms.weatherqueue.domain.WeatherCondition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WeatherConditionToXML implements PayloadTransformerIntoText<WeatherCondition> {

	@Override
	public Optional<String> apply(WeatherCondition condition) {
		
		try {
			StringWriter sw = new StringWriter();
			
			JAXBContext jaxbContext = JAXBContext.newInstance(WeatherConditionTO.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(new WeatherConditionXmlAdapter().marshal(condition), sw);
			
			return Optional.of(sw.toString());
			
		} catch (Exception e) {
			log.error("Error while marshalling object {}, details: {}", condition, e);
			return Optional.empty();
		}		
	}

}
