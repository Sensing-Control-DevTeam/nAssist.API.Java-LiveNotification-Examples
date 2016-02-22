package nassist.api.examples.livenotifications.notificationmodel;

public class DataPoint {
	private double Value;
    private String Date;
	
	public double getValue() {
		return Value;
	}
	
	public void setValue(double value) {
		Value = value;
	}
	
	public String getDate() {
		return Date;
	}
	
	public void setDate(String date) {
		Date = date;
	}
}
