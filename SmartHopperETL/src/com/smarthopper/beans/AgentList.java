package com.smarthopper.beans;

import java.io.Serializable;

import com.smarthopper.dbdto.Job_retrievalDTO;
import com.smarthopper.dbdto.Job_retrieval_country_contract_pairDTO;
import com.smarthopper.service.RetrievalTimeService;

public class AgentList implements Serializable{
	public static final long serialVersionUID = 0;
	
	private int agentID;
	private String name;
	private String description;
	private String created;
	private String settings;
	private String modified;
	private RetrievalTimeService retrievalService;
	
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
		retrievalService = new RetrievalTimeService(description);
	}
	
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getSettings() {
		return settings;
	}
	public void setSettings(String settings) {
		this.settings = settings;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}	
	
	public Job_retrieval_country_contract_pairDTO getCCpair(){
		return retrievalService.getCcPair();
	}
	
	public Job_retrievalDTO getJobRetrieval() {
		return retrievalService.getJobRetrieval();
	}
	
	public boolean isError() {
		return retrievalService.isError();
	}
}
