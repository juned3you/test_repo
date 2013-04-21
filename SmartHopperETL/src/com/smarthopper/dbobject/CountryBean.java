/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbobject;

import java.util.HashMap;

import com.smarthopper.dbdao.CountryDAO;

/**
*This class is used as a bean of Country
**/ 
public class CountryBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
	private int countryid;
	private String name;
	private String code;
	private int language_id;

	//countryid Getter and Setter method.
	public int getCountryid(){
		return countryid;
	}
	public void setCountryid(int countryid){
		this.countryid = countryid;
	}

	//name Getter and Setter method.
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	//code Getter and Setter method.
	public String getCode(){
		return code;
	}
	public void setCode(String code){
		this.code = code;
	}

	//language_id Getter and Setter method.
	public int getLanguage_id(){
		return language_id;
	}
	public void setLanguage_id(int language_id){
		this.language_id = language_id;
	}

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(CountryDAO.Columns.NAME,getName());
		map.put(CountryDAO.Columns.CODE,getCode());
		map.put(CountryDAO.Columns.LANGUAGE_ID,getLanguage_id());
		return map;
	}
}