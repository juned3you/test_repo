/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		01-04-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Smarthopper_other_infoDAO;
/**
*This class is used to hold DTO of Smarthopper_other_info
**/ 
public class Smarthopper_other_infoDTO {

	//Member Variable Declaration.
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

	//This method convert the ResultSet to DTO conversion.
	public static List<Smarthopper_other_infoDTO> resultSetToDTOConversion(ResultSet rs){
		List<Smarthopper_other_infoDTO> list = new ArrayList<Smarthopper_other_infoDTO>();
		try{
			while(rs.next()){
				Smarthopper_other_infoDTO smarthopper_other_infoDTO = new Smarthopper_other_infoDTO();
				smarthopper_other_infoDTO.setId(rs.getInt(Smarthopper_other_infoDAO.Columns.ID));
				smarthopper_other_infoDTO.setReference_id(rs.getInt(Smarthopper_other_infoDAO.Columns.REFERENCE_ID));
				smarthopper_other_infoDTO.setParticular(rs.getString(Smarthopper_other_infoDAO.Columns.PARTICULAR));
				smarthopper_other_infoDTO.setCountryid(rs.getInt(Smarthopper_other_infoDAO.Columns.COUNTRYID));
				list.add(smarthopper_other_infoDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}