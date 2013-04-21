/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Contract_typeDAO;
/**
*This class is used to hold DTO of Contract_type
**/ 
public class Contract_typeDTO {

	//Member Variable Declaration.
	private int contract_type_id;
	private String contract_type;

	//contract_type_id Getter and Setter method.
	public int getContract_type_id(){
		return contract_type_id;
	}
	public void setContract_type_id(int contract_type_id){
		this.contract_type_id = contract_type_id;
	}

	//contract_type Getter and Setter method.
	public String getContract_type(){
		return contract_type;
	}
	public void setContract_type(String contract_type){
		this.contract_type = contract_type;
	}

	//This method convert the ResultSet to DTO conversion.
	public static List<Contract_typeDTO> resultSetToDTOConversion(ResultSet rs){
		List<Contract_typeDTO> list = new ArrayList<Contract_typeDTO>();
		try{
			while(rs.next()){
				Contract_typeDTO contract_typeDTO = new Contract_typeDTO();
				contract_typeDTO.setContract_type_id(rs.getInt(Contract_typeDAO.Columns.CONTRACT_TYPE_ID));
				contract_typeDTO.setContract_type(rs.getString(Contract_typeDAO.Columns.CONTRACT_TYPE));
				list.add(contract_typeDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}