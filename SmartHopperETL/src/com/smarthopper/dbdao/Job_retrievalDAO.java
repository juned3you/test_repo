/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.Job_retrievalDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Job_retrieval
**/ 
public class Job_retrievalDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="job_retrieval";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String JR_ID	=	"jr_id";
		String CONFIGURATION_NAME	=	"configuration_name";
		String DATE_CREATED	=	"date_created";
		String EMAIL_NOTIFICATION	=	"email_notification";
		String IS_THREE_TIMS_PER_DAY	=	"is_three_tims_per_day";
		String JOB_ATTRIBUTES_IDS	=	"job_attributes_ids";
		String NOTES	=	"notes";
		String STATUS	=	"status";
		String URL_OF_JOB	=	"url_of_job";
		String COMPANY_ID	=	"company_id";
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(Job_retrievalDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(Job_retrievalDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrievalDTO> findBy_Jr_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.JR_ID+"="+data);
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Configuration_name(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONFIGURATION_NAME+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Date_created(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DATE_CREATED+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Email_notification(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.EMAIL_NOTIFICATION+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Is_three_tims_per_day(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.IS_THREE_TIMS_PER_DAY+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Job_attributes_ids(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.JOB_ATTRIBUTES_IDS+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Notes(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NOTES+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Status(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.STATUS+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrievalDTO> findBy_Url_of_job(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.URL_OF_JOB+"='"+data+"'");
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrievalDTO> findBy_Company_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_ID+"="+data);
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<Job_retrievalDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<Job_retrievalDTO> resultList = Job_retrievalDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Jr_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.JR_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Jr_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.JR_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Jr_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.JR_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Company_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.COMPANY_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Company_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.COMPANY_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Company_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.COMPANY_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}

}