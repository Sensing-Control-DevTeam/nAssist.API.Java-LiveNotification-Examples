package nassist.api.examples.livenotifications.notificationmodel;

public class SensorDataPoint {

    private String SensorId;
    private String SensorName;
    private DataPoint DataPoint;
    
	public String getSensorId() {
		return SensorId;
	}
	
	public void setSensorId(String sensorId) {
		SensorId = sensorId;
	}
	
	public String getSensorName() {
		return SensorName;
	}
	
	public void setSensorName(String sensorName) {
		SensorName = sensorName;
	}
	
	public DataPoint getDataPoint() {
		return DataPoint;
	}
	
	public void setDataPoint(DataPoint dataPoint) {
		DataPoint = dataPoint;
	}
}
