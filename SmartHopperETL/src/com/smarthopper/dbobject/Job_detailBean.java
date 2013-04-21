/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbobject;

import java.util.HashMap;

import com.smarthopper.dbdao.Job_detailDAO;

/**
*This class is used as a bean of Job_detail
**/ 
public class Job_detailBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
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

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Job_detailDAO.Columns.INDUSTRY,getIndustry());
		map.put(Job_detailDAO.Columns.COMPANY_CLIENT_DESCRIPTION,getCompany_client_description());
		map.put(Job_detailDAO.Columns.COMPANY_INFORMATION_URL,getCompany_information_url());
		map.put(Job_detailDAO.Columns.SALARY,getSalary());
		map.put(Job_detailDAO.Columns.WORKLOAD,getWorkload());
		map.put(Job_detailDAO.Columns.CONTACT_FIRST_NAME,getContact_first_name());
		map.put(Job_detailDAO.Columns.CONTACT_SECOND_NAME,getContact_second_name());
		map.put(Job_detailDAO.Columns.CONTACT_PHONE,getContact_phone());
		map.put(Job_detailDAO.Columns.CONTACT_FAX,getContact_fax());
		map.put(Job_detailDAO.Columns.NOTE,getNote());
		map.put(Job_detailDAO.Columns.DATE_MODIFIED,getDate_modified());
		return map;
	}
}