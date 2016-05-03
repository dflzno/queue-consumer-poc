package jms.weatherqueue.domain;

public class LatitudeLongitudeElevationCoordinate {

	private double latitude;
	private double longitude;
	private double elevation;
	
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

	public double getLatitude() {
		return latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public double getElevation() {
		return elevation;
	}	
	
}
