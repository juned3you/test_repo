/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbobject;

import java.util.HashMap;

import com.smarthopper.dbdao.Contract_typeDAO;

/**
*This class is used as a bean of Contract_type
**/ 
public class Contract_typeBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
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

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(Contract_typeDAO.Columns.CONTRACT_TYPE_ID,getContract_type_id());
		map.put(Contract_typeDAO.Columns.CONTRACT_TYPE,getContract_type());
		return map;
	}
}