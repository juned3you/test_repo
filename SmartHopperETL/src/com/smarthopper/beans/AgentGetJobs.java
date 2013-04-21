package com.smarthopper.beans;

import java.io.Serializable;

public class AgentGetJobs implements Serializable{
	public static final long serialVersionUID = 0;
	
	private String jobID;
	private String created;
	private String modified;
	private String jobType;
	private String status;
	private String started;
	private String end;
	private int agentID;
	private String errorCode;
	private String errorMessage;
	private String errorFirst;
	private String errorLast;
	private String errorCount;
	private String warningcount;
	
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStarted() {
		return started;
	}
	public void setStarted(String started) {
		this.started = started;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getAgentID() {
		return agentID;
	}
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorFirst() {
		return errorFirst;
	}
	public void setErrorFirst(String errorFirst) {
		this.errorFirst = errorFirst;
	}
	public String getErrorLast() {
		return errorLast;
	}
	public void setErrorLast(String errorLast) {
		this.errorLast = errorLast;
	}
	public String getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(String errorCount) {
		this.errorCount = errorCount;
	}
	public String getWarningcount() {
		return warningcount;
	}
	public void setWarningcount(String warningcount) {
		this.warningcount = warningcount;
	}	
}
