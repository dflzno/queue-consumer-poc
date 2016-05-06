package suppport.builders;

import java.time.ZonedDateTime;

import jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationResource;
import jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationResource.ChannelResource;
import jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationResource.ConditionResource;
import jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationResource.ItemResource;
import jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationResource.QueryResource;
import jms.weatherqueue.integration.weatherprovider.yahoo.WeatherInformationResource.ResultResource;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WeatherInformationResourceTestBuilder {
	
	public static WeatherInformationResource build() {
		return new WeatherInformationResource(
				new QueryResource(ZonedDateTime.now(),
						new ResultResource(
								new ChannelResource(
										new ItemResource(
												buildConditionResult("00", ZonedDateTime.now(), "50", "Hot like hell"))))));
	}
	
	public static ConditionResource buildConditionResult(String code, ZonedDateTime date, String temperature, String description) {
		return new ConditionResource(code, date, temperature, description);
	}
}
