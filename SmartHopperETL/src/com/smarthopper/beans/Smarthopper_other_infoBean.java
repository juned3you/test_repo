/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		11-05-2010		JUNED		CREATED
*/

package com.smarthopper.beans;

import java.util.HashMap;

import com.smarthopper.dbdao.Smarthopper_other_infoDAO;

/**
*This class is used as a bean of Smarthopper_other_info
**/ 
public class Smarthopper_other_infoBean{

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
	private int id;
	private int reference_id;
	private String particular;
	private int countryid;

	//id Getter and Setter method.
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	//reference_id Getter and Setter method.
	public int getReference_id(){
		return reference_id;
	}
	public void setReference_id(int reference_id){
		this.reference_id = reference_id;
	}

	//particular Getter and Setter method.
	public String getParticular(){
		return particular;
	}
	public void setParticular(String particular){
		this.particular = particular;
	}

	//countryid Getter and Setter method.
	public int getCountryid(){
		return countryid;
	}
	public void setCountryid(int countryid){
		this.countryid = countryid;
	}

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Smarthopper_other_infoDAO.Columns.REFERENCE_ID,getReference_id());
		map.put(Smarthopper_other_infoDAO.Columns.PARTICULAR,getParticular());
		map.put(Smarthopper_other_infoDAO.Columns.COUNTRYID,getCountryid());
		return map;
	}
}