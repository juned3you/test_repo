/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Job_detailDAO;
/**
*This class is used to hold DTO of Job_detail
**/ 
public class Job_detailDTO {

	//Member Variable Declaration.
	private int id;
	private String industry;
	private String company_client_description;
	private String company_information_url;
	private String salary;
	private String workload;
	private String contact_first_name;
	private String contact_second_name;
	private String contact_phone;
	private String contact_fax;
	private String note;
	private String date_modified;

	//id Getter and Setter method.
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	//industry Getter and Setter method.
	public String getIndustry(){
		return industry;
	}
	public void setIndustry(String industry){
		this.industry = industry;
	}

	//company_client_description Getter and Setter method.
	public String getCompany_client_description(){
		return company_client_description;
	}
	public void setCompany_client_description(String company_client_description){
		this.company_client_description = company_client_description;
	}

	//company_information_url Getter and Setter method.
	public String getCompany_information_url(){
		return company_information_url;
	}
	public void setCompany_information_url(String company_information_url){
		this.company_information_url = company_information_url;
	}

	//salary Getter and Setter method.
	public String getSalary(){
		return salary;
	}
	public void setSalary(String salary){
		this.salary = salary;
	}

	//workload Getter and Setter method.
	public String getWorkload(){
		return workload;
	}
	public void setWorkload(String workload){
		this.workload = workload;
	}

	//contact_first_name Getter and Setter method.
	public String getContact_first_name(){
		return contact_first_name;
	}
	public void setContact_first_name(String contact_first_name){
		this.contact_first_name = contact_first_name;
	}

	//contact_second_name Getter and Setter method.
	public String getContact_second_name(){
		return contact_second_name;
	}
	public void setContact_second_name(String contact_second_name){
		this.contact_second_name = contact_second_name;
	}

	//contact_phone Getter and Setter method.
	public String getContact_phone(){
		return contact_phone;
	}
	public void setContact_phone(String contact_phone){
		this.contact_phone = contact_phone;
	}

	//contact_fax Getter and Setter method.
	public String getContact_fax(){
		return contact_fax;
	}
	public void setContact_fax(String contact_fax){
		this.contact_fax = contact_fax;
	}

	//note Getter and Setter method.
	public String getNote(){
		return note;
	}
	public void setNote(String note){
		this.note = note;
	}

	//date_modified Getter and Setter method.
	public String getDate_modified(){
		return date_modified;
	}
	public void setDate_modified(String date_modified){
		this.date_modified = date_modified;
	}

	//This method convert the ResultSet to DTO conversion.
	public static List<Job_detailDTO> resultSetToDTOConversion(ResultSet rs){
		List<Job_detailDTO> list = new ArrayList<Job_detailDTO>();
		try{
			while(rs.next()){
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
				list.add(job_detailDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}