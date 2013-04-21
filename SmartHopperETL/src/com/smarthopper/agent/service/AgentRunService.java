package com.smarthopper.agent.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import startup.WorkQueue;

import com.smarthopper.beans.AgentList;
import com.smarthopper.beans.AgentRun;
import com.smarthopper.dbdto.Job_retrieval_timeDTO;
import com.smarthopper.service.MainService;
import com.smarthopper.utils.APIDetails;
import com.smarthopper.utils.XmlUtils;

@SuppressWarnings("unchecked")
public class AgentRunService extends MainService implements Runnable {

	private Logger log = Logger.getLogger(AgentRunService.class);
	private final String JOBID = "JobID";
	private final String AGENTID = "AgentID";	
	private AgentList agent = null;	

	public AgentList getAgent() {
		return agent;
	}

	public void setAgent(AgentList agent) {
		this.agent = agent;
	}

	@Override
	public List getDataList() {
		return null;
	}

	@Override
	public List getDataList(String param) {
		log.info("Starting AgentRun " + param);
		List<AgentRun> collectionList = new ArrayList<AgentRun>();

		String url = getURL(APIDetails.AGENT_RUN);
		url = url + "&" + APIDetails.AGENTID_PARAM + "=" + param;

		NodeList collectionListNodes = XmlUtils.getRootFromURL(url);

		if (collectionListNodes == null)
			return null;

		collectionList.add(getBean(collectionListNodes));
		log.info("AgentRunService extraction done.");
		return collectionList;
	}

	/**
	 * Creates Job Details from the Collection node.
	 * 
	 * @param nodelist
	 * @return
	 */
	private AgentRun getBean(NodeList nodelist) {
		AgentRun bean = new AgentRun();
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
			} else if (nodeName.equalsIgnoreCase(AGENTID)) {
				if (XmlUtils.isNumeric(nodeValue))
					bean.setAgentID(Integer.parseInt(nodeValue));
			}
		}
		return bean;
	}

	
	public void start(int agentID) {
		List<AgentRun> agentRunList = getDataList("" + agentID);

		if (agentRunList == null || agentRunList.size() == 0) {
			WorkQueue.isAgentRunComplete = true;
			log.info("Can't run any agent." + agentID);
			return;
		}
		String jobId = agentRunList.get(0).getJobID();
		if (jobId == null) {
			WorkQueue.isAgentRunComplete = true;
			return;
		}

		AgentGetJobsService agentGetJobsService = new AgentGetJobsService();
		agentGetJobsService.checkAgentRunStatus(jobId, agentID);
	}

	@Override
	public void run() {
		if(agent.isError()){
			log.error("There is an error in country & contract pair.."+agent.getName()+"("+agent.getDescription()+")");
			return;
		}		
				
		for (Job_retrieval_timeDTO timeDTO: agent.getJobRetrieval().getJobRetrievalTimeList()){
			if(isTimeMatch(timeDTO.getTime())){
				
			}else if(isMissed(timeDTO.getTime())){
				log.info("Last time missed");
			}
		}		
	}
	
	private boolean isTimeMatch(Date retTime){
		Date currentDate = new Date();
		int result = currentDate.compareTo(retTime);
		switch(result){
			case 0:
				log.info("Time matched:- Retrieval Time "+retTime+" Current Time "+currentDate);
				break;
			case 1:
				break;
			case 2:
				break;	
		}
		
		return true;
	}
	
	private boolean isMissed(Date retTime){
		return true;
	}
}
