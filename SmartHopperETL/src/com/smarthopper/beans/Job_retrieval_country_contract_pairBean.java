/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.beans;

import java.util.HashMap;

import com.smarthopper.dbdao.Job_retrieval_country_contract_pairDAO;

/**
*This class is used as a bean of Job_retrieval_country_contract_pair
**/ 
public class Job_retrieval_country_contract_pairBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
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

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Job_retrieval_country_contract_pairDAO.Columns.PAIR_ID,getPair_id());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.AUTOMATIC_ACTIVATION_OF_JOBS,getAutomatic_activation_of_jobs());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.AUTOMATIC_ASSIGNED_REWARD,getAutomatic_assigned_reward());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.CONTRACT_TYPE_ID,getContract_type_id());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.COUNTRY_ID,getCountry_id());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.INITIAL_RETRIEVAL_JOBS,getInitial_retrieval_jobs());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.IS_USE_FOR_DEACTIVATION,getIs_use_for_deactivation());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.NEW_JOB_PER_DAY,getNew_job_per_day());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.JR_ID,getJr_id());
		map.put(Job_retrieval_country_contract_pairDAO.Columns.IS_ACTIVE,getIsactive());
		return map;
	}
}