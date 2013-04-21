/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdto;

import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import com.smarthopper.dbdao.Import_data_logDAO;
/**
*This class is used to hold DTO of Import_data_log
**/ 
public class Import_data_logDTO {

	//Member Variable Declaration.
	private int companyid;
	private int contract_type_id;
	private String error_messages;
	private String import_date;
	private int num_jobs_imported;
	private int num_jobs_xml_file;
	private int num_of_errors;

	//companyid Getter and Setter method.
	public int getCompanyid(){
		return companyid;
	}
	public void setCompanyid(int companyid){
		this.companyid = companyid;
	}

	//contract_type_id Getter and Setter method.
	public int getContract_type_id(){
		return contract_type_id;
	}
	public void setContract_type_id(int contract_type_id){
		this.contract_type_id = contract_type_id;
	}

	//error_messages Getter and Setter method.
	public String getError_messages(){
		return error_messages;
	}
	public void setError_messages(String error_messages){
		this.error_messages = error_messages;
	}

	//import_date Getter and Setter method.
	public String getImport_date(){
		return import_date;
	}
	public void setImport_date(String import_date){
		this.import_date = import_date;
	}

	//num_jobs_imported Getter and Setter method.
	public int getNum_jobs_imported(){
		return num_jobs_imported;
	}
	public void setNum_jobs_imported(int num_jobs_imported){
		this.num_jobs_imported = num_jobs_imported;
	}

	//num_jobs_xml_file Getter and Setter method.
	public int getNum_jobs_xml_file(){
		return num_jobs_xml_file;
	}
	public void setNum_jobs_xml_file(int num_jobs_xml_file){
		this.num_jobs_xml_file = num_jobs_xml_file;
	}

	//num_of_errors Getter and Setter method.
	public int getNum_of_errors(){
		return num_of_errors;
	}
	public void setNum_of_errors(int num_of_errors){
		this.num_of_errors = num_of_errors;
	}

	//This method convert the ResultSet to DTO conversion.
	public static List<Import_data_logDTO> resultSetToDTOConversion(ResultSet rs){
		List<Import_data_logDTO> list = new ArrayList<Import_data_logDTO>();
		try{
			while(rs.next()){
				Import_data_logDTO import_data_logDTO = new Import_data_logDTO();
				import_data_logDTO.setCompanyid(rs.getInt(Import_data_logDAO.Columns.COMPANYID));
				import_data_logDTO.setContract_type_id(rs.getInt(Import_data_logDAO.Columns.CONTRACT_TYPE_ID));
				import_data_logDTO.setError_messages(rs.getString(Import_data_logDAO.Columns.ERROR_MESSAGES));
				import_data_logDTO.setImport_date(rs.getString(Import_data_logDAO.Columns.IMPORT_DATE));
				import_data_logDTO.setNum_jobs_imported(rs.getInt(Import_data_logDAO.Columns.NUM_JOBS_IMPORTED));
				import_data_logDTO.setNum_jobs_xml_file(rs.getInt(Import_data_logDAO.Columns.NUM_JOBS_XML_FILE));
				import_data_logDTO.setNum_of_errors(rs.getInt(Import_data_logDAO.Columns.NUM_OF_ERRORS));
				list.add(import_data_logDTO);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return list;
	}
}