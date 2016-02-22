package nassist.api.examples.livenotifications.notificationinterface;

import nassist.api.examples.livenotifications.notificationmodel.LiveSensorValuesMapping;

public interface IInstallationHubClient extends IBaseHubClient
{
    void receiveNewInstallationActiveSchedules(String installationId, String date, int activeSchedules);
    void receiveNewInstallationActiveSchedulesByType(String installationId, String date, int activeSchedules, String type);
    void receiveNewInstallationComfortStatus(String installationId, String date, String CssName);
    void receiveNewInstallationComfortStatus(String installationId, String date, String CssName, String DisplayName);
    void receiveNewInstallationSecurityStatus(String installationId, String date, String securityStatus, String trigger);
    void receiveNewInstallationStatus(String installationId, String date, String status);
    void receiveNewInstallationDayEnergyTrend(String installationId, String date, String energyTrend, Double energyValue);
    void receiveNewInstallationOverallTemp(String installationId, Double newOverallTemp);
    void receiveNewInstallationOverallHumidity(String installationId, Double newOverallHumidity);
    void receiveNewRule(long ruleId, String name, String description, String category);
    void receiveNewCondition(long conditionId, String description);
    void receiveConditionDeleted(long conditionId);
    void receiveActionDeleted(long actionId);
    void receiveLiveSensorData(LiveSensorValuesMapping data);
}