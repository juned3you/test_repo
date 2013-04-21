package com.smarthopper.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import startup.MozendaServiceManually;
import startup.WorkQueue;

import com.smarthopper.beans.AgentGetJobs;
import com.smarthopper.exceptions.AgentGetJobsException;
import com.smarthopper.service.MainService;
import com.smarthopper.utils.APIDetails;
import com.smarthopper.utils.AgentJobStatus;
import com.smarthopper.utils.XmlUtils;

@SuppressWarnings("unchecked")
public class AgentGetJobsService extends MainService {

	private Logger log = Logger.getLogger(AgentGetJobsService.class);
	public String agentID;
	private final String CREATED = "Created";
	private final String MODIFIED = "Modified";
	private final String AGENTID = "AgentID";
	private final String JOBID = "JobID";
	private final String JOBTYPE = "JobType";
	private final String STATUS = "Status";
	private final String STARTED = "Started";
	private final String END = "End";
	private final String ERROR_CODE = "ErrorCode";
	private final String ERROR_MESSAGE = "ErrorMessage";
	private final String ERROR_FIRST = "ErrorFirst";
	private final String ERROR_LAST = "ErrorLast";
	private final String ERROR_COUNT = "ErrorCount";
	private final String WARNING_COUNT = "WarningCount";

	@Override
	public List getDataList() {
		return null;
	}

	@Override
	public List getDataList(String param) {
		log.info("Starting AgentGetJobsService jobid " + param);
		List<AgentGetJobs> collectionList = new ArrayList<AgentGetJobs>();

		String url = getURL(APIDetails.AGENT_GETJOBS);
		url = url+"&"+AGENTID+"="+agentID;
		
		NodeList collectionListNodes = XmlUtils.getNodeListFromURL(url,
				"JobList");

		if (collectionListNodes == null)
			return null;

		for (int counter = 0; counter < collectionListNodes.getLength(); counter++) {
			Node collectionNode = collectionListNodes.item(counter);
			if (collectionNode == null)
				continue;

			if (collectionNode.getNodeName().equalsIgnoreCase("Job")) {
				NodeList childrenNodes = collectionNode.getChildNodes();
				collectionList.add(getBean(childrenNodes));
			}
		}
		log.info("Started AgentGetJobsService ."+param);
		return collectionList;
	}

	/**
	 * Creates Job Details from the Collection node.
	 * 
	 * @param nodelist
	 * @return
	 */
	private AgentGetJobs getBean(NodeList nodelist) {
		AgentGetJobs bean = new AgentGetJobs();
		for (int counter = 0; counter < nodelist.getLength(); counter++) {
			Node parentNode = nodelist.item(counter);
			NodeList children = parentNode.getChildNodes();
			Node node = children.item(0);

			if (node == null)
				continue;

			String nodeName = parentNode.getNodeName();
			String nodeValue = node.getNodeValue();

			// check for Invalid data.
			if (XmlUtils.isInvalidData(nodeValue))
				continue;

			if (nodeName.equalsIgnoreCase(JOBID)) {
				bean.setJobID(nodeValue);
			} else if (nodeName.equalsIgnoreCase(CREATED)) {
				bean.setCreated(nodeValue);
			} else if (nodeName.equalsIgnoreCase(MODIFIED)) {
				bean.setModified(nodeValue);
			} else if (nodeName.equalsIgnoreCase(AGENTID)) {
				if (XmlUtils.isNumeric(nodeValue))
					bean.setAgentID(Integer.parseInt(nodeValue));
			} else if (nodeName.equalsIgnoreCase(JOBTYPE)) {
				bean.setJobType(nodeValue);
			} else if (nodeName.equalsIgnoreCase(STATUS)) {
				bean.setStatus(nodeValue);
			} else if (nodeName.equalsIgnoreCase(STARTED)) {
				bean.setStarted(nodeValue);
			} else if (nodeName.equalsIgnoreCase(END)) {
				bean.setEnd(nodeValue);
			} else if (nodeName.equalsIgnoreCase(ERROR_CODE)) {
				bean.setErrorCode(nodeValue);
			} else if (nodeName.equalsIgnoreCase(ERROR_MESSAGE)) {
				bean.setErrorMessage(nodeValue);
			} else if (nodeName.equalsIgnoreCase(ERROR_FIRST)) {
				bean.setErrorFirst(nodeValue);
			} else if (nodeName.equalsIgnoreCase(ERROR_LAST)) {
				bean.setErrorLast(nodeValue);
			} else if (nodeName.equalsIgnoreCase(ERROR_COUNT)) {
				bean.setErrorCount(nodeValue);
			} else if (nodeName.equalsIgnoreCase(WARNING_COUNT)) {
				bean.setWarningcount(nodeValue);
			}
		}
		return bean;
	}

	/**
	 * Recursive checking for Agent Run Status within every 1 min.
	 * @param jobID
	 */
	public void checkAgentRunStatus(String jobID, int agentID) {
		try {
			List<AgentGetJobs> agentJobList = null;
			boolean isDone = false;
			this.agentID = ""+agentID;
			
			while (true) {
				agentJobList = getDataList(jobID);
				if (agentJobList == null) {
					WorkQueue.isAgentRunComplete = true;
					log.info("Can't run getJobs." + agentID);
					return;
				}
				
				if(agentJobList.size() == 0){
					WorkQueue.isAgentRunComplete = true;
					log.info("Can't run getJobs." + agentID);
					return;
				}
				
				
				isDone = isStatusDone(agentJobList.get(0));
				if (isDone) {					
					MozendaServiceManually collService = new MozendaServiceManually();
					collService.startCollectionService(""+agentID);
					collService.insertAllJob();
					WorkQueue.isAgentRunComplete = true;
					break;
				}
				
				log.info("Agent "+agentID +" response has not received yet. Going for sleep "+(WorkQueue.CHECK_FOR_AGENT_STATUS)/1000+" seconds.");				
				Thread.sleep(WorkQueue.CHECK_FOR_AGENT_STATUS);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check the Status received from Agent.GetJobs.
	 * @param agentGetJobs
	 * @return
	 * @throws AgentGetJobsException
	 */
	private boolean isStatusDone(AgentGetJobs agentGetJobs)
			throws AgentGetJobsException {
		String status = agentGetJobs.getStatus();		
		
		if(status == null)
			return false;
		
		if(!status.trim().toLowerCase().equals(AgentJobStatus.Status.DONE))
			return false;
		
		return true;
	}
}
