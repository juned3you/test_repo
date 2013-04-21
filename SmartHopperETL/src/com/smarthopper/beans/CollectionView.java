package com.smarthopper.beans;

import java.io.Serializable;
import java.util.List;

public class CollectionView implements Serializable{
	public static final long serialVersionUID = 0;
	
	private int viewID;
	private String name;
	private String description;
	private int collectionID;
	private List<JobDetail> jobDetails;
	
	public int getViewID() {
		return viewID;
	}
	public void setViewID(int viewID) {
		this.viewID = viewID;
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
	}
	public int getCollectionID() {
		return collectionID;
	}
	public void setCollectionID(int collectionID) {
		this.collectionID = collectionID;
	}
	public List<JobDetail> getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(List<JobDetail> jobDetails) {
		this.jobDetails = jobDetails;
	}
		
}
