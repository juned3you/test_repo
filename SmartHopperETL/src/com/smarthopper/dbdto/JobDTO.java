/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		01-04-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.JobDAO;
import com.smarthopper.dbdao.Job_detailDAO;
/**
*This class is used to hold DTO of Job
**/ 
public class JobDTO {

	//Member Variable Declaration.
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
	private Job_detailDTO jobDetailDTO;

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
	
	public Job_detailDTO getJobDetailDTO() {
		return jobDetailDTO;
	}
	public void setJobDetailDTO(Job_detailDTO jobDetailDTO) {
		this.jobDetailDTO = jobDetailDTO;
	}
	
	//This method convert the ResultSet to DTO conversion.
	public static List<JobDTO> resultSetToDTOConversion(ResultSet rs){
		List<JobDTO> list = new ArrayList<JobDTO>();
		try{
			while(rs.next()){
				JobDTO jobDTO = new JobDTO();
				jobDTO.setJobid(rs.getInt(JobDAO.Columns.JOBID));
				jobDTO.setContract_type_id(rs.getInt(JobDAO.Columns.CONTRACT_TYPE_ID));
				jobDTO.setClient_reference_id(rs.getString(JobDAO.Columns.CLIENT_REFERENCE_ID));
				jobDTO.setClient_reference_url(rs.getString(JobDAO.Columns.CLIENT_REFERENCE_URL));
				jobDTO.setJob_detail_id(rs.getInt(JobDAO.Columns.JOB_DETAIL_ID));
				jobDTO.setKicker(rs.getString(JobDAO.Columns.KICKER));
				jobDTO.setTitle(rs.getString(JobDAO.Columns.TITLE));
				jobDTO.setTasks(rs.getString(JobDAO.Columns.TASKS));
				jobDTO.setSkills(rs.getString(JobDAO.Columns.SKILLS));
				jobDTO.setExperience(rs.getString(JobDAO.Columns.EXPERIENCE));
				jobDTO.setExpectations(rs.getString(JobDAO.Columns.EXPECTATIONS));
				jobDTO.setEducation(rs.getString(JobDAO.Columns.EDUCATION));
				jobDTO.setLocation(rs.getString(JobDAO.Columns.LOCATION));
				jobDTO.setPostal_code(rs.getString(JobDAO.Columns.POSTAL_CODE));
				jobDTO.setCountry_code(rs.getInt(JobDAO.Columns.COUNTRY_CODE));
				jobDTO.setStart(rs.getString(JobDAO.Columns.START));
				jobDTO.setEnd(rs.getString(JobDAO.Columns.END));
				jobDTO.setDuration(rs.getString(JobDAO.Columns.DURATION));
				jobDTO.setDate_posted(rs.getString(JobDAO.Columns.DATE_POSTED));
				jobDTO.setCompanyid(rs.getInt(JobDAO.Columns.COMPANYID));
				jobDTO.setCompany_description(rs.getString(JobDAO.Columns.COMPANY_DESCRIPTION));
				jobDTO.setContact_email(rs.getString(JobDAO.Columns.CONTACT_EMAIL));
				jobDTO.setReward(rs.getDouble(JobDAO.Columns.REWARD));
				jobDTO.setKeywordid(rs.getInt(JobDAO.Columns.KEYWORDID));
				jobDTO.setVisible(rs.getString(JobDAO.Columns.VISIBLE));
				jobDTO.setActive(rs.getString(JobDAO.Columns.ACTIVE));
				jobDTO.setDate_created(rs.getString(JobDAO.Columns.DATE_CREATED));
				list.add(jobDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	//This method convert the ResultSet to DTO conversion.
	public static List<JobDTO> resultSetToJobDetails(ResultSet rs){
		List<JobDTO> list = new ArrayList<JobDTO>();
		try{
			while(rs.next()){
				JobDTO jobDTO = new JobDTO();
				jobDTO.setJobid(rs.getInt(JobDAO.Columns.JOBID));
				jobDTO.setContract_type_id(rs.getInt(JobDAO.Columns.CONTRACT_TYPE_ID));
				jobDTO.setClient_reference_id(rs.getString(JobDAO.Columns.CLIENT_REFERENCE_ID));
				jobDTO.setClient_reference_url(rs.getString(JobDAO.Columns.CLIENT_REFERENCE_URL));
				jobDTO.setJob_detail_id(rs.getInt(JobDAO.Columns.JOB_DETAIL_ID));
				jobDTO.setKicker(rs.getString(JobDAO.Columns.KICKER));
				jobDTO.setTitle(rs.getString(JobDAO.Columns.TITLE));
				jobDTO.setTasks(rs.getString(JobDAO.Columns.TASKS));
				jobDTO.setSkills(rs.getString(JobDAO.Columns.SKILLS));
				jobDTO.setExperience(rs.getString(JobDAO.Columns.EXPERIENCE));
				jobDTO.setExpectations(rs.getString(JobDAO.Columns.EXPECTATIONS));
				jobDTO.setEducation(rs.getString(JobDAO.Columns.EDUCATION));
				jobDTO.setLocation(rs.getString(JobDAO.Columns.LOCATION));
				jobDTO.setPostal_code(rs.getString(JobDAO.Columns.POSTAL_CODE));
				jobDTO.setCountry_code(rs.getInt(JobDAO.Columns.COUNTRY_CODE));
				jobDTO.setStart(rs.getString(JobDAO.Columns.START));
				jobDTO.setEnd(rs.getString(JobDAO.Columns.END));
				jobDTO.setDuration(rs.getString(JobDAO.Columns.DURATION));
				jobDTO.setDate_posted(rs.getString(JobDAO.Columns.DATE_POSTED));
				jobDTO.setCompanyid(rs.getInt(JobDAO.Columns.COMPANYID));
				jobDTO.setCompany_description(rs.getString(JobDAO.Columns.COMPANY_DESCRIPTION));
				jobDTO.setContact_email(rs.getString(JobDAO.Columns.CONTACT_EMAIL));
				jobDTO.setReward(rs.getDouble(JobDAO.Columns.REWARD));
				jobDTO.setKeywordid(rs.getInt(JobDAO.Columns.KEYWORDID));
				jobDTO.setVisible(rs.getString(JobDAO.Columns.VISIBLE));
				jobDTO.setActive(rs.getString(JobDAO.Columns.ACTIVE));
				jobDTO.setDate_created(rs.getString(JobDAO.Columns.DATE_CREATED));
				
				Job_detailDTO job_detailDTO = new Job_detailDTO();
				job_detailDTO.setId(rs.getInt(Job_detailDAO.Columns.ID));
				job_detailDTO.setIndustry(rs.getString(Job_detailDAO.Columns.INDUSTRY));
				job_detailDTO.setCompany_client_description(rs.getString(Job_detailDAO.Columns.COMPANY_CLIENT_DESCRIPTION));
				job_detailDTO.setCompany_information_url(rs.getString(Job_detailDAO.Columns.COMPANY_INFORMATION_URL));
				job_detailDTO.setSalary(rs.getString(Job_detailDAO.Columns.SALARY));
				job_detailDTO.setWorkload(rs.getString(Job_detailDAO.Columns.WORKLOAD));
				job_detailDTO.setContact_first_name(rs.getString(Job_detailDAO.Columns.CONTACT_FIRST_NAME));
				job_detailDTO.setContact_second_name(rs.getString(Job_detailDAO.Columns.CONTACT_SECOND_NAME));
				job_detailDTO.setContact_phone(rs.getString(Job_detailDAO.Columns.CONTACT_PHONE));
				job_detailDTO.setContact_fax(rs.getString(Job_detailDAO.Columns.CONTACT_FAX));
				job_detailDTO.setNote(rs.getString(Job_detailDAO.Columns.NOTE));
				job_detailDTO.setDate_modified(rs.getString(Job_detailDAO.Columns.DATE_MODIFIED));
				
				jobDTO.setJobDetailDTO(job_detailDTO);				
				list.add(jobDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
	
}