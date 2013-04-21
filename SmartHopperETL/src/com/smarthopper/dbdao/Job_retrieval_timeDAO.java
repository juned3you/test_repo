/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.Job_retrieval_timeDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Job_retrieval_time
**/ 
public class Job_retrieval_timeDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="job_retrieval_time";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String TIME_ID	=	"time_id";
		String LAST_RUN	=	"last_run";
		String TIME	=	"time";
		String JR_ID	=	"jr_id";
		String DATE_UPDATED	=	"date_updated";
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(Job_retrieval_timeDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(Job_retrieval_timeDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_timeDTO> findBy_Time_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.TIME_ID+"="+data);
		List<Job_retrieval_timeDTO> resultList = Job_retrieval_timeDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_timeDTO> findBy_Last_run(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.LAST_RUN+"='"+data+"'");
		List<Job_retrieval_timeDTO> resultList = Job_retrieval_timeDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_timeDTO> findBy_Time(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.TIME+"='"+data+"'");
		List<Job_retrieval_timeDTO> resultList = Job_retrieval_timeDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_timeDTO> findBy_Jr_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.JR_ID+"="+data+"ORDER BY "+Columns.TIME);
		List<Job_retrieval_timeDTO> resultList = Job_retrieval_timeDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_timeDTO> findBy_Date_updated(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DATE_UPDATED+"='"+data+"'");
		List<Job_retrieval_timeDTO> resultList = Job_retrieval_timeDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<Job_retrieval_timeDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<Job_retrieval_timeDTO> resultList = Job_retrieval_timeDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Time_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.TIME_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Time_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.TIME_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Time_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.TIME_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
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

}