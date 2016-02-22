package nassist.api.examples.livenotifications.notificationinterface;

public interface ISensorHubClient extends IBaseHubClient
{
    void receiveNewSensorData(String sensorId, String date, Double value);
    void receiveNewSensorStatus(String sensorId, String sensorName, String date, String status);
    void receiveCopyStartedOperation(String SourceSensorId, String TargetSensorId, String from, String to, String operationKey);
    void receiveCopyCompletedOperation(String operationKey);
    void receiveNewSensorLockStatus(String Id, boolean IsLocked);
}