package jms.weatherqueue.domain;

import lombok.Getter;

@Getter
public class LatitudeLongitudeElevationCoordinate {

	private final double latitude;
	private final double longitude;
	private final double elevation;
	
	public LatitudeLongitudeElevationCoordinate(double latitude, double longitude, double elevation) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}	
	
	public LatitudeLongitudeElevationCoordinate(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = 0.0;
	}

	
}
