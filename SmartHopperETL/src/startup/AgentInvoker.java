package startup;

import java.util.List;

import org.apache.log4j.Logger;

import com.smarthopper.agent.service.AgentListService;
import com.smarthopper.agent.service.AgentRunService;
import com.smarthopper.beans.AgentList;

@SuppressWarnings("unchecked")
public class AgentInvoker {

	private Logger log = Logger.getLogger(AgentInvoker.class);
	private List<AgentList> agentList;

	public AgentInvoker() {

	}

	private void initAgentList() {
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

		try {			
			for (AgentList aList : this.agentList) {
				AgentRunService agentRunService = new AgentRunService();
				agentRunService.setAgent(aList);			
				new Thread(agentRunService);				
			}
			log	.info("................All agent Thread started..................");
		} catch (Exception e) {
			log.error("Error in Work queue start -- >" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String str[]) {
		AgentInvoker agentInvoker = new AgentInvoker();
		agentInvoker.start();
	}
}
