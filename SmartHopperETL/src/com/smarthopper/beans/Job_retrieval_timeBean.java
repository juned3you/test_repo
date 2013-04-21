/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.beans;

import java.util.Date;
import java.util.HashMap;

import com.smarthopper.dbdao.Job_retrieval_timeDAO;

/**
*This class is used as a bean of Job_retrieval_time
**/ 
public class Job_retrieval_timeBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
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

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Job_retrieval_timeDAO.Columns.TIME_ID,getTime_id());
		map.put(Job_retrieval_timeDAO.Columns.LAST_RUN,getLast_run());
		map.put(Job_retrieval_timeDAO.Columns.TIME,getTime());
		map.put(Job_retrieval_timeDAO.Columns.JR_ID,getJr_id());
		map.put(Job_retrieval_timeDAO.Columns.DATE_UPDATED,getDate_updated());
		return map;
	}
}