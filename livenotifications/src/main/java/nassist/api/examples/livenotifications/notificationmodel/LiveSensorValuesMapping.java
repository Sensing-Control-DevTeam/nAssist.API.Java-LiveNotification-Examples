package nassist.api.examples.livenotifications.notificationmodel;

import java.util.List;

public class LiveSensorValuesMapping {
    private List<SensorDataPoint> Sensors;
    private double MasterValue;
    
	public List<SensorDataPoint> getSensors() {
		return Sensors;
	}
	
	public void setSensors(List<SensorDataPoint> sensors) {
		Sensors = sensors;
	}
	
	public double getMasterValue() {
		return MasterValue;
	}
	
	public void setMasterValue(double masterValue) {
		MasterValue = masterValue;
	}
}
