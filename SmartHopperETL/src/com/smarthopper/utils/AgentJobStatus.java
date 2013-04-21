package com.smarthopper.utils;

public class AgentJobStatus {

	public interface Status{
		String CANCELED = "Canceled";
		String CANCELING = "Canceling";
		
		String CYCLED = "Cycled";
		String CYCLING = "Cycling";
		
		String DONE = "done";
		String ERROR = "Error";
		
		String LIMIT_REACHED = "LimitReached";
		String POSTPONED = "Postponed";
		
		String RESTARTED = "Restarted";
		String RESTARTING = "Restarting";
		
		String RUNNING = "Running";
		String STOPPED = "Stopped";
		String STOPPING = "Stopping";		
	}

	public interface ErrorCode{
		String ACCESS_DENIED = "AccessDenied";
		String AJAX_FAILED = "AjaxFailed";
		
		String CLICK_ELEMENT_FAILED = "ClickElementFailed";
		String CRITICAL_ELEMENT_NOTFOUND = "CriticalElementNotFound";
		
		String DATA_NOTFOUND = "DataNotFound";
		String ELEMENT_NOTFOUND = "ElementNotFound";
		
		String GATEWAY_TIMEOUT = "GatewayTimeout";
		String HTTP_BAD_GATEWAY = "502";
		
		String HTTP_BAD_REQUEST = "400";
		String HTTP_DENIED = "HttpDenied";
		
		String HTTP_FORBIDDEN = "403";
		String HTTP_NOT_FOUND = "404";
		String HTTP_SERVER_ERROR = "500";
		
		String HTTP_SERVER_UNAVAILABLE = "503";
		String HTTP_STATUS_LENGTH_REQUIRED = "";
		String HTTP_UNHANDLED_ERROR = "HttpUnhandledError";
		
		String INET_AUTH_REQ = "INetAuthenticationRequired";
		String INET_DOWNLOAD_FAILURE = "INetDownloadFailure";
		String INET_SOURCE_NOT_FOUND = "INetResourceNotFound";
		String INET_REDIRECT_FAILURE = "INetRedirectFailed";
		String NAVIGATION_FAILED = "NavigationFailed";
		String RECURSION = "Recursion";
		String SET_ELEMENT_VALUE_FAILED = "SetElementValueFailed";
		String VIEW_NOT_FOUND = "Timeout";		 
	}
}
