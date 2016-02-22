package nassist.api.examples.livenotifications.notificationmodel;

import java.util.HashMap;
import java.util.Map;

public class EventsCountResponse extends ResponseBase
{
    public Map<String, Integer> EventGroupsCount;

    public int TotalCount;

    public EventsCountResponse()
    {
        EventGroupsCount = new HashMap<String, Integer>();
    }
}
