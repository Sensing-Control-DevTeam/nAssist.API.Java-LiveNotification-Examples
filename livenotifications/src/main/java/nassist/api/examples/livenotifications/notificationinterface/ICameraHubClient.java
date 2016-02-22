package nassist.api.examples.livenotifications.notificationinterface;

public interface ICameraHubClient extends IBaseHubClient
{
    void receiveNewCameraPhoto(String cameraId, String cameraName, String date);
}