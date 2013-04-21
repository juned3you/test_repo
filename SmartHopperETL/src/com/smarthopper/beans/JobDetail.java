package com.smarthopper.beans;

import java.io.Serializable;

public class JobDetail implements Serializable{
	public static final long serialVersionUID = 0;
	
	private String company_description = "";
	private String client_reference_id = "";
	private String title = "";
	private String tasks = "";
	private String skills = "";
	
	private String location = "";
	private String start = "";
	private String end = "";
	private String contact_phone = "";
	private String contact_email = "";
	
	private String duration = "";
	private String date_posted = "";
	
	private String salary = "";	
	private String company_client = "";
	private String fullText = "";
	private String url = "";		
	private String industry = "";
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = toTitleCase(location);		
	}
	
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDate_posted() {
		return date_posted;
	}
	public void setDate_posted(String date_posted) {
		this.date_posted = date_posted;
	}
	public String getClient_reference_id() {
		return client_reference_id;
	}
	public void setClient_reference_id(String client_reference_id) {
		this.client_reference_id = client_reference_id;
	}
	public String getCompany_client() {
		return company_client;
	}
	public void setCompany_client(String company_client) {
		this.company_client = company_client;
	}
	public String getFullText() {
		return fullText;
	}
	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTasks() {
		return tasks;
	}
	public void setTasks(String tasks) {
		this.tasks = tasks;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCompany_description() {
		return company_description;
	}
	public void setCompany_description(String company_description) {
		this.company_description = company_description;
	}	
	
	private String toTitleCase(String str){		
		if (str != null && str.trim().length()>0){
			str = str.toLowerCase();
			char ch = str.charAt(0);
			ch-=32;
			str = ch+str.substring(1);
		}
		return str;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}		
}
