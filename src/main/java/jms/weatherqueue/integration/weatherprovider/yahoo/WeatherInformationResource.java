package jms.weatherqueue.integration.weatherprovider.yahoo;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherInformationResource {
	
	private QueryResource query;
}

@Data
class QueryResource {
	
	@JsonProperty("created") 
	private ZonedDateTime createdAt;
	
	private ResultResource results;
}

@Data
class ResultResource {
	private ChannelResource channel;
}

@Data
class ChannelResource {
	private ItemResource item;
}

@Data
class ItemResource {
	private ConditionResource condition;
}

@Data
class ConditionResource {
	private String code;
	
	@JsonFormat(pattern = "EEE, dd MMM yyyy hh:mm a z") // ¡WTH!
	private ZonedDateTime date;
	
	@JsonProperty("temp")
	private String temperature;
	
	@JsonProperty("text")
	private String description;
}