/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.CountryDAO;
/**
*This class is used to hold DTO of Country
**/ 
public class CountryDTO {

	//Member Variable Declaration.
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

	//This method convert the ResultSet to DTO conversion.
	public static List<CountryDTO> resultSetToDTOConversion(ResultSet rs){
		List<CountryDTO> list = new ArrayList<CountryDTO>();
		try{
			while(rs.next()){
				CountryDTO countryDTO = new CountryDTO();
				countryDTO.setCountryid(rs.getInt(CountryDAO.Columns.COUNTRYID));
				countryDTO.setName(rs.getString(CountryDAO.Columns.NAME));
				countryDTO.setCode(rs.getString(CountryDAO.Columns.CODE));
				countryDTO.setLanguage_id(rs.getInt(CountryDAO.Columns.LANGUAGE_ID));
				list.add(countryDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}