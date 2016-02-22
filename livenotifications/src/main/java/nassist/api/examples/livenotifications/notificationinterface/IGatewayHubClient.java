package nassist.api.examples.livenotifications.notificationinterface;

public interface IGatewayHubClient extends IBaseHubClient
{
    void receiveLogsUpdate(String DriverID, String Link);
    void receiveUpdateStatus(String GatewayId, String UpdateStatus);
    void receiveNetworkStatus(String GatewayId, String NetworkStatus);
    void receiveAddOrRemoveSensor(String GatewayId, boolean IsAdded);
    void receiveGWVersion(String Id, String GWVersion);
    void receiveSensorConfigured(String Id, String SensorId);
    void receiveMainThermostatChanged(String Id, String Name);
    void receiveBackupCreated(String Id, boolean IsCreated);
    void receiveSystemBackupCreated(String Id, boolean IsCreated);
}
