package nassist.api.examples.livenotifications.notificationmodel;

import java.util.HashMap;

import net.servicestack.client.DataContract;
import net.servicestack.client.DataMember;
import net.servicestack.client.IReturn;
import net.servicestack.client.ResponseStatus;

public class dto{

	@DataContract
	public static class Authenticate implements IReturn<AuthenticateResponse>
	{
		@DataMember(Order=1)
		public String provider = null;

		@DataMember(Order=2)
		public String State = null;

		@DataMember(Order=3)
		public String oauth_token = null;

		@DataMember(Order=4)
		public String oauth_verifier = null;

		@DataMember(Order=5)
		public String UserName = null;

		@DataMember(Order=6)
		public String Password = null;

		@DataMember(Order=7)
		public Boolean RememberMe = null;

		@DataMember(Order=8)
		public String Continue = null;

		@DataMember(Order=9)
		public String nonce = null;

		@DataMember(Order=10)
		public String uri = null;

		@DataMember(Order=11)
		public String response = null;

		@DataMember(Order=12)
		public String qop = null;

		@DataMember(Order=13)
		public String nc = null;

		@DataMember(Order=14)
		public String cnonce = null;

		@DataMember(Order=15)
		public HashMap<String,String> Meta = null;

		public String getProvider() { return provider; }
		public Authenticate setProvider(String value) { this.provider = value; return this; }
		public String getState() { return State; }
		public Authenticate setState(String value) { this.State = value; return this; }
		public String getOauthToken() { return oauth_token; }
		public Authenticate setOauthToken(String value) { this.oauth_token = value; return this; }
		public String getOauthVerifier() { return oauth_verifier; }
		public Authenticate setOauthVerifier(String value) { this.oauth_verifier = value; return this; }
		public String getUserName() { return UserName; }
		public Authenticate setUserName(String value) { this.UserName = value; return this; }
		public String getPassword() { return Password; }
		public Authenticate setPassword(String value) { this.Password = value; return this; }
		public Boolean isRememberMe() { return RememberMe; }
		public Authenticate setRememberMe(Boolean value) { this.RememberMe = value; return this; }
		public String getContinue() { return Continue; }
		public Authenticate setContinue(String value) { this.Continue = value; return this; }
		public String getNonce() { return nonce; }
		public Authenticate setNonce(String value) { this.nonce = value; return this; }
		public String getUri() { return uri; }
		public Authenticate setUri(String value) { this.uri = value; return this; }
		public String getResponse() { return response; }
		public Authenticate setResponse(String value) { this.response = value; return this; }
		public String getQop() { return qop; }
		public Authenticate setQop(String value) { this.qop = value; return this; }
		public String getNc() { return nc; }
		public Authenticate setNc(String value) { this.nc = value; return this; }
		public String getCnonce() { return cnonce; }
		public Authenticate setCnonce(String value) { this.cnonce = value; return this; }
		public HashMap<String,String> getMeta() { return Meta; }
		public Authenticate setMeta(HashMap<String,String> value) { this.Meta = value; return this; }
		private static Object responseType = AuthenticateResponse.class;
		public Object getResponseType() { return responseType; }
	}

	@DataContract
	public static class AuthenticateResponse
	{
		@DataMember(Order=6)
		public ResponseStatus ResponseStatus = null;

		@DataMember(Order=1)
		public String UserId = null;

		@DataMember(Order=2)
		public String SessionId = null;

		@DataMember(Order=3)
		public String UserName = null;

		@DataMember(Order=4)
		public String DisplayName = null;

		@DataMember(Order=5)
		public String ReferrerUrl = null;

		@DataMember(Order=7)
		public HashMap<String,String> Meta = null;

		public ResponseStatus getResponseStatus() { return ResponseStatus; }
		public AuthenticateResponse setResponseStatus(ResponseStatus value) { this.ResponseStatus = value; return this; }
		public String getUserId() { return UserId; }
		public AuthenticateResponse setUserId(String value) { this.UserId = value; return this; }
		public String getSessionId() { return SessionId; }
		public AuthenticateResponse setSessionId(String value) { this.SessionId = value; return this; }
		public String getUserName() { return UserName; }
		public AuthenticateResponse setUserName(String value) { this.UserName = value; return this; }
		public String getDisplayName() { return DisplayName; }
		public AuthenticateResponse setDisplayName(String value) { this.DisplayName = value; return this; }
		public String getReferrerUrl() { return ReferrerUrl; }
		public AuthenticateResponse setReferrerUrl(String value) { this.ReferrerUrl = value; return this; }
		public HashMap<String,String> getMeta() { return Meta; }
		public AuthenticateResponse setMeta(HashMap<String,String> value) { this.Meta = value; return this; }
	}
}
