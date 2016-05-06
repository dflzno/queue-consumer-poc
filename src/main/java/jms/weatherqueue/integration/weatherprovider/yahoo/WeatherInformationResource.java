package jms.weatherqueue.integration.weatherprovider.yahoo;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NonNull;

@Data
public class WeatherInformationResource {
	
	@NonNull
	private QueryResource query;
	
	@Data
	public static class QueryResource {
		
		@NonNull
		@JsonProperty("created") 
		private ZonedDateTime createdAt;
		
		@NonNull
		private ResultResource results;
	}	

	@Data
	public static class ResultResource {
		
		@NonNull
		private ChannelResource channel;
	}

	@Data
	public static class ChannelResource {
		
		@NonNull
		private ItemResource item;
	}

	@Data
	public static class ItemResource {
		
		@NonNull
		private ConditionResource condition;
	}
	
	@Data
	public static class ConditionResource {
		
		@NonNull
		private String code;
		
		@NonNull
		@JsonFormat(pattern = "EEE, dd MMM yyyy hh:mm a z")
		private ZonedDateTime date;
		
		@NonNull
		@JsonProperty("temp")
		private String temperature;
		
		@NonNull
		@JsonProperty("text")
		private String description;
	}

}
