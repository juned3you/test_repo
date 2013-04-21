/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Job_retrieval_timeDAO;
/**
*This class is used to hold DTO of Job_retrieval_time
**/ 
public class Job_retrieval_timeDTO {

	//Member Variable Declaration.
	private int time_id;
	private String last_run;
	private Date time;
	private int jr_id;
	private String date_updated;

	//time_id Getter and Setter method.
	public int getTime_id(){
		return time_id;
	}
	public void setTime_id(int time_id){
		this.time_id = time_id;
	}

	//last_run Getter and Setter method.
	public String getLast_run(){
		return last_run;
	}
	public void setLast_run(String last_run){
		this.last_run = last_run;
	}

	//time Getter and Setter method.
	public Date getTime(){
		return time;
	}
	public void setTime(Date time){
		this.time = time;
	}

	//jr_id Getter and Setter method.
	public int getJr_id(){
		return jr_id;
	}
	public void setJr_id(int jr_id){
		this.jr_id = jr_id;
	}

	//date_updated Getter and Setter method.
	public String getDate_updated(){
		return date_updated;
	}
	public void setDate_updated(String date_updated){
		this.date_updated = date_updated;
	}

	//This method convert the ResultSet to DTO conversion.
	public static List<Job_retrieval_timeDTO> resultSetToDTOConversion(ResultSet rs){
		List<Job_retrieval_timeDTO> list = new ArrayList<Job_retrieval_timeDTO>();
		try{
			while(rs.next()){
				Job_retrieval_timeDTO job_retrieval_timeDTO = new Job_retrieval_timeDTO();
				job_retrieval_timeDTO.setTime_id(rs.getInt(Job_retrieval_timeDAO.Columns.TIME_ID));
				job_retrieval_timeDTO.setLast_run(rs.getString(Job_retrieval_timeDAO.Columns.LAST_RUN));
				job_retrieval_timeDTO.setTime(rs.getDate(Job_retrieval_timeDAO.Columns.TIME));
				job_retrieval_timeDTO.setJr_id(rs.getInt(Job_retrieval_timeDAO.Columns.JR_ID));
				job_retrieval_timeDTO.setDate_updated(rs.getString(Job_retrieval_timeDAO.Columns.DATE_UPDATED));
				list.add(job_retrieval_timeDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}