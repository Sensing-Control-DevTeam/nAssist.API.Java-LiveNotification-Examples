package nassist.api.examples.livenotifications;

import java.util.Scanner;

import microsoft.aspnet.signalr.client.ConnectionState;
import microsoft.aspnet.signalr.client.LogLevel;
import microsoft.aspnet.signalr.client.Logger;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.StateChangedCallback;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler3;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler4;

public class Program {

	private static HubConnection con = null;
	private static HubProxy installationHub = null;
	private static HubProxy sensorHub = null;

	private static final int JOIN_RETRIES = 3;

	private static final String NOTIFICATIONS_URL = "http://dev.nassist-test.com";
	private static final String INSTALLATIONS_CHANNEL_NAME = "signalinstallations-";
	private static final String SENSORS_CHANNEL_NAME = "signalsensors-";
	private static final String INSTALLATION_SECURITY_EVENT = "receiveNewInstallationSecurityStatus";
	private static final String SENSOR_NEW_VALUE_EVENT = "receiveNewSensorData";

	private static final String INSTALLATION_ID = "00000000-0000-0000-0000-b827eb9e544b";
	private static final String SENSOR_ID = "2e74636a-3dad-44ad-82a8-c42a2a8eb925";

	public static void main(String[] args){
		System.out.println("Press any key to start and a second time to exit the program");
		
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		
		Logger logger = new Logger() {
			@Override
			public void log(String message, LogLevel level) {
				System.out.println(message);
			}
		};

		con = new HubConnection(NOTIFICATIONS_URL, "", true, logger);

		con.stateChanged(new StateChangedCallback() {
			@Override
			public void stateChanged(ConnectionState connectionStateOld, ConnectionState connectionStateNew) {
				switch(connectionStateNew){
				case Connected:
					JoinGroup(installationHub, INSTALLATIONS_CHANNEL_NAME + INSTALLATION_ID, JOIN_RETRIES);
					JoinGroup(sensorHub, SENSORS_CHANNEL_NAME + SENSOR_ID, JOIN_RETRIES);

					break;

				case Disconnected:
					break;

				default:
					break;
				}
			}
		});

		installationHub = con.createHubProxy("installationHub");
		sensorHub = con.createHubProxy("sensorHub");

		installationHub.on(INSTALLATION_SECURITY_EVENT, new SubscriptionHandler4<String, String, String, String>() {
			@Override
			public void run(String installationId, String date, String status, String trigger) {
				System.out.println("Received Security Status change notification");
				System.out.println("Installation Id: " + installationId);
				System.out.println("Date: " + date);
				System.out.println("Status: " + status);
				System.out.println("Trigger: " + trigger);
			}
		}, String.class, String.class, String.class, String.class);
		
		sensorHub.on(SENSOR_NEW_VALUE_EVENT, new SubscriptionHandler3<String, String, String>(){
            @Override
            public void run(String sensorId, String date, String value) {
            	System.out.println("Received New Sensor value notification");
				System.out.println("Sensor Id: " + sensorId);
				System.out.println("Date: " + date);
				System.out.println("Value: " + value);
            }
        }, String.class, String.class, String.class);
		
		con.start();
		
		sc.nextLine();
		
		sc.close();
		
		con.stop();
	}

	public static void JoinGroup(HubProxy hub, String groupName, int retries) {
		System.out.print("JoinGroupInstallation: " + groupName + ". Retries: " + retries);

		boolean error = true;
		while(retries > 0 && error){
			SignalRFuture<String> invoke = hub.invoke(String.class, "joinGroup", groupName);

			try {
				invoke.get();

				if(invoke.errorWasTriggered()){
					error = true;
				} else{
					error = false;
				}
			} catch (Exception e) {
				error = true;
			}

			retries--;
		}
	}

}
