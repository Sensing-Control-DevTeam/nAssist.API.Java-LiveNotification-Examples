package nassist.api.examples.livenotifications.notificationmodel;

import net.servicestack.client.ResponseStatus;

public abstract class ResponseBase
{
	public ResponseStatus ResponseStatus;

	protected ResponseBase()
	{
		ResponseStatus = new ResponseStatus();
	}
}
