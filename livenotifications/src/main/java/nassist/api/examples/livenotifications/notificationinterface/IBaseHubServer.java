package nassist.api.examples.livenotifications.notificationinterface;

public interface IBaseHubServer {
    void JoinGroup(String groupName);

    void LeaveGroup(String groupName);
}
