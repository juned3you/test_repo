/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.beans;

import java.util.HashMap;

import com.smarthopper.dbdao.Job_attributeDAO;

/**
*This class is used as a bean of Job_attribute
**/ 
public class Job_attributeBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
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

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Job_attributeDAO.Columns.ATTRIBUTE_NAME,getAttribute_name());
		return map;
	}
}