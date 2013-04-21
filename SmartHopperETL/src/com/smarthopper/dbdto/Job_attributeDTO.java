/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Job_attributeDAO;
/**
*This class is used to hold DTO of Job_attribute
**/ 
public class Job_attributeDTO {

	//Member Variable Declaration.
	private int attr_id;
	private String attribute_name;

	//attr_id Getter and Setter method.
	public int getAttr_id(){
		return attr_id;
	}
	public void setAttr_id(int attr_id){
		this.attr_id = attr_id;
	}

	//attribute_name Getter and Setter method.
	public String getAttribute_name(){
		return attribute_name;
	}
	public void setAttribute_name(String attribute_name){
		this.attribute_name = attribute_name;
	}

	//This method convert the ResultSet to DTO conversion.
	public static List<Job_attributeDTO> resultSetToDTOConversion(ResultSet rs){
		List<Job_attributeDTO> list = new ArrayList<Job_attributeDTO>();
		try{
			while(rs.next()){
				Job_attributeDTO job_attributeDTO = new Job_attributeDTO();
				job_attributeDTO.setAttr_id(rs.getInt(Job_attributeDAO.Columns.ATTR_ID));
				job_attributeDTO.setAttribute_name(rs.getString(Job_attributeDAO.Columns.ATTRIBUTE_NAME));
				list.add(job_attributeDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}