/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.smarthopper.dbdao.Job_retrieval_country_contract_pairDAO;
/**
*This class is used to hold DTO of Job_retrieval_country_contract_pair
**/ 
public class Job_retrieval_country_contract_pairDTO {

	//Member Variable Declaration.
	private int pair_id;
	private String automatic_activation_of_jobs;
	private double automatic_assigned_reward;
	private int contract_type_id;
	private int country_id;
	private String initial_retrieval_jobs;
	private String is_use_for_deactivation;
	private int new_job_per_day;
	private int jr_id;
	private String isactive;
	private Date last_run;
	

	//pair_id Getter and Setter method.
	public int getPair_id(){
		return pair_id;
	}
	public void setPair_id(int pair_id){
		this.pair_id = pair_id;
	}

	//automatic_activation_of_jobs Getter and Setter method.
	public String getAutomatic_activation_of_jobs(){
		return automatic_activation_of_jobs;
	}
	public void setAutomatic_activation_of_jobs(String automatic_activation_of_jobs){
		this.automatic_activation_of_jobs = automatic_activation_of_jobs;
	}

	//automatic_assigned_reward Getter and Setter method.
	public double getAutomatic_assigned_reward(){
		return automatic_assigned_reward;
	}
	public void setAutomatic_assigned_reward(double automatic_assigned_reward){
		this.automatic_assigned_reward = automatic_assigned_reward;
	}

	//contract_type_id Getter and Setter method.
	public int getContract_type_id(){
		return contract_type_id;
	}
	public void setContract_type_id(int contract_type_id){
		this.contract_type_id = contract_type_id;
	}

	//country_id Getter and Setter method.
	public int getCountry_id(){
		return country_id;
	}
	public void setCountry_id(int country_id){
		this.country_id = country_id;
	}

	//initial_retrieval_jobs Getter and Setter method.
	public String getInitial_retrieval_jobs(){
		return initial_retrieval_jobs;
	}
	public void setInitial_retrieval_jobs(String initial_retrieval_jobs){
		this.initial_retrieval_jobs = initial_retrieval_jobs;
	}

	//is_use_for_deactivation Getter and Setter method.
	public String getIs_use_for_deactivation(){
		return is_use_for_deactivation;
	}
	public void setIs_use_for_deactivation(String is_use_for_deactivation){
		this.is_use_for_deactivation = is_use_for_deactivation;
	}

	//new_job_per_day Getter and Setter method.
	public int getNew_job_per_day(){
		return new_job_per_day;
	}
	public void setNew_job_per_day(int new_job_per_day){
		this.new_job_per_day = new_job_per_day;
	}

	//jr_id Getter and Setter method.
	public int getJr_id(){
		return jr_id;
	}
	public void setJr_id(int jr_id){
		this.jr_id = jr_id;
	}

	//isactive Getter and Setter method.
	public String getIsactive(){
		return isactive;
	}
	public void setIsactive(String isactive){
		this.isactive = isactive;
	}
	
	//last run Getter and Setter method.
	public Date getLast_run() {
		return last_run;
	}
	public void setLast_run(Date last_run) {
		this.last_run = last_run;
	}
	
	//This method convert the ResultSet to DTO conversion.
	public static List<Job_retrieval_country_contract_pairDTO> resultSetToDTOConversion(ResultSet rs){
		List<Job_retrieval_country_contract_pairDTO> list = new ArrayList<Job_retrieval_country_contract_pairDTO>();
		try{
			while(rs.next()){
				Job_retrieval_country_contract_pairDTO job_retrieval_country_contract_pairDTO = new Job_retrieval_country_contract_pairDTO();
				job_retrieval_country_contract_pairDTO.setPair_id(rs.getInt(Job_retrieval_country_contract_pairDAO.Columns.PAIR_ID));
				job_retrieval_country_contract_pairDTO.setAutomatic_activation_of_jobs(rs.getString(Job_retrieval_country_contract_pairDAO.Columns.AUTOMATIC_ACTIVATION_OF_JOBS));
				job_retrieval_country_contract_pairDTO.setAutomatic_assigned_reward(rs.getDouble(Job_retrieval_country_contract_pairDAO.Columns.AUTOMATIC_ASSIGNED_REWARD));
				job_retrieval_country_contract_pairDTO.setContract_type_id(rs.getInt(Job_retrieval_country_contract_pairDAO.Columns.CONTRACT_TYPE_ID));
				job_retrieval_country_contract_pairDTO.setCountry_id(rs.getInt(Job_retrieval_country_contract_pairDAO.Columns.COUNTRY_ID));
				job_retrieval_country_contract_pairDTO.setInitial_retrieval_jobs(rs.getString(Job_retrieval_country_contract_pairDAO.Columns.INITIAL_RETRIEVAL_JOBS));
				job_retrieval_country_contract_pairDTO.setIs_use_for_deactivation(rs.getString(Job_retrieval_country_contract_pairDAO.Columns.IS_USE_FOR_DEACTIVATION));
				job_retrieval_country_contract_pairDTO.setNew_job_per_day(rs.getInt(Job_retrieval_country_contract_pairDAO.Columns.NEW_JOB_PER_DAY));
				job_retrieval_country_contract_pairDTO.setJr_id(rs.getInt(Job_retrieval_country_contract_pairDAO.Columns.JR_ID));
				job_retrieval_country_contract_pairDTO.setIsactive(rs.getString(Job_retrieval_country_contract_pairDAO.Columns.IS_ACTIVE));
				job_retrieval_country_contract_pairDTO.setLast_run(rs.getDate(Job_retrieval_country_contract_pairDAO.Columns.LAST_RUN));
				list.add(job_retrieval_country_contract_pairDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}