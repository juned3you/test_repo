/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.Import_data_logDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Import_data_log
**/ 
public class Import_data_logDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="import_data_log";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String COMPANYID	=	"companyid";
		String CONTRACT_TYPE_ID	=	"contract_type_id";
		String ERROR_MESSAGES	=	"error_messages";
		String IMPORT_DATE	=	"import_date";
		String NUM_JOBS_IMPORTED	=	"num_jobs_imported";
		String NUM_JOBS_XML_FILE	=	"num_jobs_xml_file";
		String NUM_OF_ERRORS	=	"num_of_errors";
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(Import_data_logDAO.TABLE_NAME,fieldAndValues);
		return result;
	}

	/**
	*This Method is used to delete using only where condition.
	**/ 
	public int delete(String whereCondition){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeDelete(TABLE_NAME,whereCondition);
		return result;
	}


	/**
	*This Method is used to Update using only where condition.
	**/ 
	public int update(HashMap<String,Object> fieldAndValues,String whereCondition){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeUpdate(Import_data_logDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Import_data_logDTO> findBy_Companyid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANYID+"="+data);
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Import_data_logDTO> findBy_Contract_type_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTRACT_TYPE_ID+"="+data);
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Import_data_logDTO> findBy_Error_messages(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.ERROR_MESSAGES+"='"+data+"'");
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Import_data_logDTO> findBy_Import_date(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.IMPORT_DATE+"='"+data+"'");
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Import_data_logDTO> findBy_Num_jobs_imported(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NUM_JOBS_IMPORTED+"="+data);
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Import_data_logDTO> findBy_Num_jobs_xml_file(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NUM_JOBS_XML_FILE+"="+data);
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Import_data_logDTO> findBy_Num_of_errors(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NUM_OF_ERRORS+"="+data);
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<Import_data_logDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<Import_data_logDTO> resultList = Import_data_logDTO.resultSetToDTOConversion(rs);
		return resultList;
	}

	/**
	*This Method is used to count the number of record in a table.
	**/ 
	public int countAllRecord(){
		SQLMaker maker = new SQLMaker();
		int result = maker.getTotalNumberOfRecord(TABLE_NAME);
		return result;
	}

	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Companyid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.COMPANYID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Companyid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.COMPANYID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Companyid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.COMPANYID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Contract_type_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.CONTRACT_TYPE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Contract_type_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.CONTRACT_TYPE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Contract_type_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.CONTRACT_TYPE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Num_jobs_imported(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.NUM_JOBS_IMPORTED,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Num_jobs_imported(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.NUM_JOBS_IMPORTED,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Num_jobs_imported(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.NUM_JOBS_IMPORTED,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Num_jobs_xml_file(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.NUM_JOBS_XML_FILE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Num_jobs_xml_file(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.NUM_JOBS_XML_FILE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Num_jobs_xml_file(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.NUM_JOBS_XML_FILE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Num_of_errors(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.NUM_OF_ERRORS,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Num_of_errors(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.NUM_OF_ERRORS,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Num_of_errors(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.NUM_OF_ERRORS,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}

}