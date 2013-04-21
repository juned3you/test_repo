/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		19-05-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.Job_retrieval_country_contract_pairDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Job_retrieval_country_contract_pair
**/ 
public class Job_retrieval_country_contract_pairDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="job_retrieval_country_contract_pair";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String PAIR_ID	=	"pair_id";
		String AUTOMATIC_ACTIVATION_OF_JOBS	=	"automatic_activation_of_jobs";
		String AUTOMATIC_ASSIGNED_REWARD	=	"automatic_assigned_reward";
		String CONTRACT_TYPE_ID	=	"contract_type_id";
		String COUNTRY_ID	=	"country_id";
		String INITIAL_RETRIEVAL_JOBS	=	"initial_retrieval_jobs";
		String IS_USE_FOR_DEACTIVATION	=	"is_use_for_deactivation";
		String NEW_JOB_PER_DAY	=	"new_job_per_day";
		String JR_ID	=	"jr_id";
		String IS_ACTIVE	=	"isActive";
		String LAST_RUN	=	"last_run";
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(Job_retrieval_country_contract_pairDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(Job_retrieval_country_contract_pairDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Pair_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.PAIR_ID+"="+data);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Automatic_activation_of_jobs(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.AUTOMATIC_ACTIVATION_OF_JOBS+"='"+data+"'");
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on double.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Automatic_assigned_reward(double data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.AUTOMATIC_ASSIGNED_REWARD+"="+data);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Contract_type_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTRACT_TYPE_ID+"="+data);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Country_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COUNTRY_ID+"="+data);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Initial_retrieval_jobs(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.INITIAL_RETRIEVAL_JOBS+"='"+data+"'");
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Is_use_for_deactivation(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.IS_USE_FOR_DEACTIVATION+"='"+data+"'");
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_New_job_per_day(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NEW_JOB_PER_DAY+"="+data);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Jr_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.JR_ID+"="+data);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findBy_Isactive(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.IS_ACTIVE+"='"+data+"'");
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<Job_retrieval_country_contract_pairDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<Job_retrieval_country_contract_pairDTO> resultList = Job_retrieval_country_contract_pairDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Pair_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.PAIR_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Pair_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.PAIR_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Pair_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.PAIR_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on double.
	**/ 
	public double getMaximumOf_Automatic_assigned_reward(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.AUTOMATIC_ASSIGNED_REWARD,TABLE_NAME);
		return Double.parseDouble(result);
	}


	/**
	*This Method is used to find the minimum based on double.
	**/ 
	public double getMinimumOf_Automatic_assigned_reward(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.AUTOMATIC_ASSIGNED_REWARD,TABLE_NAME);
		return Double.parseDouble(result);
	}


	/**
	*This Method is used to find the Average based on double.
	**/ 
	public double getAverageOf_Automatic_assigned_reward(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.AUTOMATIC_ASSIGNED_REWARD,TABLE_NAME);
		return Double.parseDouble(result);
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
	public int getMaximumOf_Country_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.COUNTRY_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Country_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.COUNTRY_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Country_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.COUNTRY_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_New_job_per_day(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.NEW_JOB_PER_DAY,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_New_job_per_day(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.NEW_JOB_PER_DAY,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_New_job_per_day(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.NEW_JOB_PER_DAY,TABLE_NAME);
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