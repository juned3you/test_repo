package com.smarthopper.beans;

import java.io.Serializable;

public class AgentRun implements Serializable{
	public static final long serialVersionUID = 0;
	
	private int agentID;
	private String jobID;	
	
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}	
}
