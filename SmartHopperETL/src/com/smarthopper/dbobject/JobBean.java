/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		01-04-2010		JUNED		CREATED
*/

package com.smarthopper.dbobject;

import java.util.HashMap;

import com.smarthopper.dbdao.JobDAO;

/**
*This class is used as a bean of Job
**/ 
public class JobBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
	private int jobid;
	private int contract_type_id;
	private String client_reference_id;
	private String client_reference_url;
	private int job_detail_id;
	private String kicker;
	private String title;
	private String tasks;
	private String skills;
	private String experience;
	private String expectations;
	private String education;
	private String location;
	private String postal_code;
	private int country_code;
	private String start;
	private String end;
	private String duration;
	private String date_posted;
	private int companyid;
	private String company_description;
	private String contact_email;
	private double reward;
	private int keywordid;
	private String visible;
	private String active;
	private String date_created;

	//jobid Getter and Setter method.
	public int getJobid(){
		return jobid;
	}
	public void setJobid(int jobid){
		this.jobid = jobid;
	}

	//contract_type_id Getter and Setter method.
	public int getContract_type_id(){
		return contract_type_id;
	}
	public void setContract_type_id(int contract_type_id){
		this.contract_type_id = contract_type_id;
	}

	//client_reference_id Getter and Setter method.
	public String getClient_reference_id(){
		return client_reference_id;
	}
	public void setClient_reference_id(String client_reference_id){
		this.client_reference_id = client_reference_id;
	}

	//client_reference_url Getter and Setter method.
	public String getClient_reference_url(){
		return client_reference_url;
	}
	public void setClient_reference_url(String client_reference_url){
		this.client_reference_url = client_reference_url;
	}

	//job_detail_id Getter and Setter method.
	public int getJob_detail_id(){
		return job_detail_id;
	}
	public void setJob_detail_id(int job_detail_id){
		this.job_detail_id = job_detail_id;
	}

	//kicker Getter and Setter method.
	public String getKicker(){
		return kicker;
	}
	public void setKicker(String kicker){
		this.kicker = kicker;
	}

	//title Getter and Setter method.
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}

	//tasks Getter and Setter method.
	public String getTasks(){
		return tasks;
	}
	public void setTasks(String tasks){
		this.tasks = tasks;
	}

	//skills Getter and Setter method.
	public String getSkills(){
		return skills;
	}
	public void setSkills(String skills){
		this.skills = skills;
	}

	//experience Getter and Setter method.
	public String getExperience(){
		return experience;
	}
	public void setExperience(String experience){
		this.experience = experience;
	}

	//expectations Getter and Setter method.
	public String getExpectations(){
		return expectations;
	}
	public void setExpectations(String expectations){
		this.expectations = expectations;
	}

	//education Getter and Setter method.
	public String getEducation(){
		return education;
	}
	public void setEducation(String education){
		this.education = education;
	}

	//location Getter and Setter method.
	public String getLocation(){
		return location;
	}
	public void setLocation(String location){
		this.location = location;
	}

	//postal_code Getter and Setter method.
	public String getPostal_code(){
		return postal_code;
	}
	public void setPostal_code(String postal_code){
		this.postal_code = postal_code;
	}

	//country_code Getter and Setter method.
	public int getCountry_code(){
		return country_code;
	}
	public void setCountry_code(int country_code){
		this.country_code = country_code;
	}

	//start Getter and Setter method.
	public String getStart(){
		return start;
	}
	public void setStart(String start){
		this.start = start;
	}

	//end Getter and Setter method.
	public String getEnd(){
		return end;
	}
	public void setEnd(String end){
		this.end = end;
	}

	//duration Getter and Setter method.
	public String getDuration(){
		return duration;
	}
	public void setDuration(String duration){
		this.duration = duration;
	}

	//date_posted Getter and Setter method.
	public String getDate_posted(){
		return date_posted;
	}
	public void setDate_posted(String date_posted){
		this.date_posted = date_posted;
	}

	//companyid Getter and Setter method.
	public int getCompanyid(){
		return companyid;
	}
	public void setCompanyid(int companyid){
		this.companyid = companyid;
	}

	//company_description Getter and Setter method.
	public String getCompany_description(){
		return company_description;
	}
	public void setCompany_description(String company_description){
		this.company_description = company_description;
	}

	//contact_email Getter and Setter method.
	public String getContact_email(){
		return contact_email;
	}
	public void setContact_email(String contact_email){
		this.contact_email = contact_email;
	}

	//reward Getter and Setter method.
	public double getReward(){
		return reward;
	}
	public void setReward(double reward){
		this.reward = reward;
	}

	//keywordid Getter and Setter method.
	public int getKeywordid(){
		return keywordid;
	}
	public void setKeywordid(int keywordid){
		this.keywordid = keywordid;
	}

	//visible Getter and Setter method.
	public String getVisible(){
		return visible;
	}
	public void setVisible(String visible){
		this.visible = visible;
	}

	//active Getter and Setter method.
	public String getActive(){
		return active;
	}
	public void setActive(String active){
		this.active = active;
	}

	//date_created Getter and Setter method.
	public String getDate_created(){
		return date_created;
	}
	public void setDate_created(String date_created){
		this.date_created = date_created;
	}

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(JobDAO.Columns.CONTRACT_TYPE_ID,getContract_type_id());
		map.put(JobDAO.Columns.CLIENT_REFERENCE_ID,getClient_reference_id());
		map.put(JobDAO.Columns.CLIENT_REFERENCE_URL,getClient_reference_url());
		map.put(JobDAO.Columns.JOB_DETAIL_ID,getJob_detail_id());
		map.put(JobDAO.Columns.KICKER,getKicker());
		map.put(JobDAO.Columns.TITLE,getTitle());
		map.put(JobDAO.Columns.TASKS,getTasks());
		map.put(JobDAO.Columns.SKILLS,getSkills());
		map.put(JobDAO.Columns.EXPERIENCE,getExperience());
		map.put(JobDAO.Columns.EXPECTATIONS,getExpectations());
		map.put(JobDAO.Columns.EDUCATION,getEducation());
		map.put(JobDAO.Columns.LOCATION,getLocation());
		map.put(JobDAO.Columns.POSTAL_CODE,getPostal_code());
		map.put(JobDAO.Columns.COUNTRY_CODE,getCountry_code());
		map.put(JobDAO.Columns.START,getStart());
		map.put(JobDAO.Columns.END,getEnd());
		map.put(JobDAO.Columns.DURATION,getDuration());
		map.put(JobDAO.Columns.DATE_POSTED,getDate_posted());
		map.put(JobDAO.Columns.COMPANYID,getCompanyid());
		map.put(JobDAO.Columns.COMPANY_DESCRIPTION,getCompany_description());
		map.put(JobDAO.Columns.CONTACT_EMAIL,getContact_email());
		map.put(JobDAO.Columns.REWARD,getReward());
		map.put(JobDAO.Columns.KEYWORDID,getKeywordid());
		map.put(JobDAO.Columns.VISIBLE,getVisible());
		map.put(JobDAO.Columns.ACTIVE,getActive());
		map.put(JobDAO.Columns.DATE_CREATED,getDate_created());
		return map;
	}
}