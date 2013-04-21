/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Job_retrievalDAO;
import com.smarthopper.dbdao.Job_retrieval_country_contract_pairDAO;
import com.smarthopper.dbdao.Job_retrieval_timeDAO;
/**
*This class is used to hold DTO of Job_retrieval
**/ 
public class Job_retrievalDTO {

	//Member Variable Declaration.
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
	private  List<Job_retrieval_timeDTO> jobRetrievalTimeList = null;;
	private List<Job_retrieval_country_contract_pairDTO> ccList = null;

	//jr_id Getter and Setter method.
	public int getJr_id(){
		return jr_id;
	}
	public void setJr_id(int jr_id){
		this.jr_id = jr_id;
		
		 Job_retrieval_timeDAO jobRetrievalTimeDAO = new Job_retrieval_timeDAO();
		 jobRetrievalTimeList = jobRetrievalTimeDAO.findBy_Jr_id(jr_id);
		 
		 Job_retrieval_country_contract_pairDAO ccPairDAO = new Job_retrieval_country_contract_pairDAO();
		 ccList = ccPairDAO.findBy_Jr_id(jr_id);
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

	public List<Job_retrieval_timeDTO> getJobRetrievalTimeList() {
		return jobRetrievalTimeList;
	}
	public List<Job_retrieval_country_contract_pairDTO> getCcList() {
		return ccList;
	}
	//This method convert the ResultSet to DTO conversion.
	public static List<Job_retrievalDTO> resultSetToDTOConversion(ResultSet rs){
		List<Job_retrievalDTO> list = new ArrayList<Job_retrievalDTO>();
		try{
			while(rs.next()){
				Job_retrievalDTO job_retrievalDTO = new Job_retrievalDTO();
				job_retrievalDTO.setJr_id(rs.getInt(Job_retrievalDAO.Columns.JR_ID));
				job_retrievalDTO.setConfiguration_name(rs.getString(Job_retrievalDAO.Columns.CONFIGURATION_NAME));
				job_retrievalDTO.setDate_created(rs.getString(Job_retrievalDAO.Columns.DATE_CREATED));
				job_retrievalDTO.setEmail_notification(rs.getString(Job_retrievalDAO.Columns.EMAIL_NOTIFICATION));
				job_retrievalDTO.setIs_three_tims_per_day(rs.getString(Job_retrievalDAO.Columns.IS_THREE_TIMS_PER_DAY));
				job_retrievalDTO.setJob_attributes_ids(rs.getString(Job_retrievalDAO.Columns.JOB_ATTRIBUTES_IDS));
				job_retrievalDTO.setNotes(rs.getString(Job_retrievalDAO.Columns.NOTES));
				job_retrievalDTO.setStatus(rs.getString(Job_retrievalDAO.Columns.STATUS));
				job_retrievalDTO.setUrl_of_job(rs.getString(Job_retrievalDAO.Columns.URL_OF_JOB));
				job_retrievalDTO.setCompany_id(rs.getInt(Job_retrievalDAO.Columns.COMPANY_ID));
				list.add(job_retrievalDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}