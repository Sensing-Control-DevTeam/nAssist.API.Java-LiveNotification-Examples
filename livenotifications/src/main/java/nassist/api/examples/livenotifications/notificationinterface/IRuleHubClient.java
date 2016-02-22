package nassist.api.examples.livenotifications.notificationinterface;

public interface IRuleHubClient extends IBaseHubClient
{
    void receiveRuleDeleted(long Id);
    void receiveRuleIsEnabledStatus(long Id, boolean IsEnabled);
}