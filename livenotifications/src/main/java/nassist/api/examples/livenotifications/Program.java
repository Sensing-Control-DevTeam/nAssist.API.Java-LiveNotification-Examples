package nassist.api.examples.livenotifications;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.Scanner;

import microsoft.aspnet.signalr.client.ConnectionState;
import microsoft.aspnet.signalr.client.LogLevel;
import microsoft.aspnet.signalr.client.Logger;
import microsoft.aspnet.signalr.client.StateChangedCallback;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler3;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler4;
import microsoft.aspnet.signalr.client.transport.WebsocketTransport;
import nassist.api.examples.livenotifications.notificationmodel.dto.Authenticate;
import net.servicestack.client.JsonServiceClient;

public class Program {

	private static HubConnection con;
	private static HubProxy installationHub;
	private static HubProxy sensorHub;

	private static final String NOTIFICATIONS_URL = "https://dev.encontrol.io";

	private static final String INSTALLATION_SECURITY_EVENT = "receiveNewInstallationSecurityStatus";
	private static final String SENSOR_NEW_VALUE_EVENT = "receiveNewSensorData";

	private static final String INSTALLATION_ID = "00000000-0000-0000-0000-b827ebe90baa";
	private static final String SENSOR_ID = "321c86b7-9be4-4660-9303-a5454a0056d0";
	
	private static final String UserName = "demo";
	private static final String Password = "demo";

	private static final JsonServiceClient client = new JsonServiceClient(NOTIFICATIONS_URL + "/api");
	
	public static void main(String[] args){
		System.out.println("Press any key to start and a second time to exit the program");
		
		Scanner sc = new Scanner(System.in);
		
		sc.nextLine();
		
		// Obtain credentials
		CookieManager cmanager = new CookieManager();
		CookieHandler.setDefault(cmanager);
		
		Authenticate auth = new Authenticate();
		auth.setUserName(UserName);
		auth.setPassword(Password);
		client.post(auth);
		
		Logger logger = new Logger() {
			@Override
			public void log(String message, LogLevel level) {
				System.out.println(message);
			}
		};

		// Create connection with notification server
		con = new HubConnection(NOTIFICATIONS_URL, "", true, logger);

		for(HttpCookie cookie: cmanager.getCookieStore().getCookies()){
			con.addHeader("X-" + cookie.getName(), cookie.getValue());
		}
		
		con.connected(new Runnable() {
			@Override
			public void run() {
				System.out.println("Connected!");
				// Method names must be camel case
				installationHub.invoke("joinGroup", INSTALLATION_ID);
				sensorHub.invoke("joinGroup", SENSOR_ID);
			}
		});
		
		con.stateChanged(new StateChangedCallback() {
			@Override
			public void stateChanged(ConnectionState connectionStateOld, ConnectionState connectionStateNew) {
				System.out.println("State changed from " + connectionStateOld + " to " + connectionStateNew);
			}
		});

		// Hub names must be camel case
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
		
		// Start the connection using websockets
		con.start(new WebsocketTransport(logger));
		
		sc.nextLine();
		
		sc.close();
		
		con.stop();
	}
}
