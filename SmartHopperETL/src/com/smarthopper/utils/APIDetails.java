package com.smarthopper.utils;

public interface APIDetails {
	String URL 					 = "https://api.mozenda.com/rest?";
	String WEB_SERVICE_KEY_PARAM = "WebServiceKey";
	String SERVICE_PARAM 		 = "Service";
	String OPERATION_PARAM		 = "Operation";
	String VIEWID_PARAM		 	 = "ViewID";
	String COLLECTIONID_PARAM	 = "CollectionID";
	String AGENTID_PARAM		 = "AgentID";
	
	String COLLECTION_GETLIST 	 = "Collection.GetList";
	String COLLECTION_GETVIEWS 	 = "Collection.GetViews";
	String COLLECTION_GETFIELDS  = "Collection.GetFields";
	
	String VIEWS_GETITEMS  		 = "View.GetItems";
	
	String AGENT_GETLIST  		 = "Agent.GetList";
	String AGENT_GETJOBS  		 = "Agent.GetJobs";
	String AGENT_RUN  		 	 = "Agent.Run";
	String AGENT_DELETE  	 	 = "Agent.Delete";
	
	String JOB_GET		  		 = "Job.Get";
	String JOB_CANCEL	  		 = "Job.Cancel";
	String JOB_PAUSE	  		 = "Job.Pause";
	String JOB_RESUME	  		 = "Job.Resume";
}
