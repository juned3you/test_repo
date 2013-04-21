package startup;

import java.util.List;

import org.apache.log4j.Logger;

import com.smarthopper.agent.service.AgentListService;
import com.smarthopper.agent.service.AgentRunService;
import com.smarthopper.beans.AgentList;

@SuppressWarnings("unchecked")
public class WorkQueue {

	public static long CHECK_FOR_AGENT_RUN_COMPLETE = 1000 * 10; // ten seconds.
	public static long CHECK_FOR_AGENT_STATUS = 1000 * 15; // One min.

	// Update after one Agent Run is complete.
	public static boolean isAgentRunComplete = true;

	private Logger log = Logger.getLogger(WorkQueue.class);
	private List<AgentList> agentList;
	private int totalAgent;
	private int currentCounter;

	public WorkQueue() {
		currentCounter = 0;		
	}
	
	private void initAgentList(){
		AgentListService serv = new AgentListService();
		this.agentList = serv.getDataList();
	}
	
	/**
	 * Start Getting all agent and run.
	 */
	public void start() {
		log.info("................Starting Agent Extraction..................");
		
		initAgentList();

		if (agentList == null || agentList.size() == 0) {
			log.error("No Agent List found on Mozenda Server.");
			return;
		}

		AgentRunService agentRunService;
		totalAgent = this.agentList.size();
		try {
			int agentid = -1;
			while (currentCounter < totalAgent) {

				if (isAgentRunComplete) {
					isAgentRunComplete = false;
					agentRunService = new AgentRunService();
					agentid = agentList.get(currentCounter)
					.getAgentID();
					agentRunService.start(agentid);
					currentCounter++;
				}
				log.info("Agent "+agentid+"is still running. Going for sleep "+(CHECK_FOR_AGENT_RUN_COMPLETE)/1000+" seconds.");
				Thread.sleep(CHECK_FOR_AGENT_RUN_COMPLETE);
			}
			log.info(".......................Work finished...........................");
		} catch (Exception e) {
			log.error("Error in Work queue start -- >" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Start based on Agent id.
	 * @param agentId
	 */
	public void start(int agentId) {
		log.info("Starting Workqueue...");
		initAgentList();

		if (agentList == null || agentList.size() == 0) {
			log.error("No Agent List found on Mozenda Server.");
			return;
		}

		AgentRunService agentRunService;
		totalAgent = this.agentList.size();
		try {

			while (currentCounter < totalAgent) {

				if (isAgentRunComplete) {					
					agentRunService = new AgentRunService();
					if(agentList.get(currentCounter).getAgentID() == agentId){
						isAgentRunComplete = false;
						agentRunService.start(agentList.get(currentCounter)
								.getAgentID());
						break;
					}
					currentCounter++;
				}
				Thread.sleep(CHECK_FOR_AGENT_RUN_COMPLETE);
			}

		} catch (Exception e) {
			log.error("Error in Work queue start -- >" + e.getMessage());
		}
	}
	
	public static void main(String str[]){
		WorkQueue workQueue = new WorkQueue();
		workQueue.start();
		
	}
}
