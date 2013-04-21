/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.beans;

import java.util.HashMap;

import com.smarthopper.dbdao.Job_retrievalDAO;

/**
*This class is used as a bean of Job_retrieval
**/ 
public class Job_retrievalBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
	private int jr_id;
	private String configuration_name;
	private String date_created;
	private String email_notification;
	private String is_three_tims_per_day;
	private String job_attributes_ids;
	private String notes;
	private String status;
	private String url_of_job;
	private int company_id;

	//jr_id Getter and Setter method.
	public int getJr_id(){
		return jr_id;
	}
	public void setJr_id(int jr_id){
		this.jr_id = jr_id;
	}

	//configuration_name Getter and Setter method.
	public String getConfiguration_name(){
		return configuration_name;
	}
	public void setConfiguration_name(String configuration_name){
		this.configuration_name = configuration_name;
	}

	//date_created Getter and Setter method.
	public String getDate_created(){
		return date_created;
	}
	public void setDate_created(String date_created){
		this.date_created = date_created;
	}

	//email_notification Getter and Setter method.
	public String getEmail_notification(){
		return email_notification;
	}
	public void setEmail_notification(String email_notification){
		this.email_notification = email_notification;
	}

	//is_three_tims_per_day Getter and Setter method.
	public String getIs_three_tims_per_day(){
		return is_three_tims_per_day;
	}
	public void setIs_three_tims_per_day(String is_three_tims_per_day){
		this.is_three_tims_per_day = is_three_tims_per_day;
	}

	//job_attributes_ids Getter and Setter method.
	public String getJob_attributes_ids(){
		return job_attributes_ids;
	}
	public void setJob_attributes_ids(String job_attributes_ids){
		this.job_attributes_ids = job_attributes_ids;
	}

	//notes Getter and Setter method.
	public String getNotes(){
		return notes;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}

	//status Getter and Setter method.
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		this.status = status;
	}

	//url_of_job Getter and Setter method.
	public String getUrl_of_job(){
		return url_of_job;
	}
	public void setUrl_of_job(String url_of_job){
		this.url_of_job = url_of_job;
	}

	//company_id Getter and Setter method.
	public int getCompany_id(){
		return company_id;
	}
	public void setCompany_id(int company_id){
		this.company_id = company_id;
	}

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Job_retrievalDAO.Columns.JR_ID,getJr_id());
		map.put(Job_retrievalDAO.Columns.CONFIGURATION_NAME,getConfiguration_name());
		map.put(Job_retrievalDAO.Columns.DATE_CREATED,getDate_created());
		map.put(Job_retrievalDAO.Columns.EMAIL_NOTIFICATION,getEmail_notification());
		map.put(Job_retrievalDAO.Columns.IS_THREE_TIMS_PER_DAY,getIs_three_tims_per_day());
		map.put(Job_retrievalDAO.Columns.JOB_ATTRIBUTES_IDS,getJob_attributes_ids());
		map.put(Job_retrievalDAO.Columns.NOTES,getNotes());
		map.put(Job_retrievalDAO.Columns.STATUS,getStatus());
		map.put(Job_retrievalDAO.Columns.URL_OF_JOB,getUrl_of_job());
		map.put(Job_retrievalDAO.Columns.COMPANY_ID,getCompany_id());
		return map;
	}
}