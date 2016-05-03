package jms.weatherqueue.domain;

import lombok.Getter;

public class LatitudeLongitudeElevationCoordinate {

	@Getter private double latitude;
	@Getter private double longitude;
	@Getter private double elevation;
	
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
