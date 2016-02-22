package nassist.api.examples.livenotifications.notificationinterface;

import nassist.api.examples.livenotifications.notificationmodel.EventsCountResponse;

public interface IEventHubClient extends IBaseHubClient
{
    void receiveNewEvent(String rowKey, String type, String subtype, String installation, String InstallationId, String translatedDescription, boolean pending, String date, String cameraTrigger);

    void receivePendingCountUpdate(EventsCountResponse count);

    void receiveNewSecurityEvent(String eventId, String eventDescription, String date);

    void receiveNewEnergyEvent(String eventId, String eventDescription, String date);
}
