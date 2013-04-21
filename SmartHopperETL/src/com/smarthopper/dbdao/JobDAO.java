/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		01-04-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.JobDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;
import com.smarthopper.utils.SQLUtils;

/**
*This class is used to hold DAO of Job
**/ 
public class JobDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="job";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String JOBID	=	"jobid";
		String CONTRACT_TYPE_ID	=	"contract_type_id";
		String CLIENT_REFERENCE_ID	=	"client_reference_id";
		String CLIENT_REFERENCE_URL	=	"client_reference_url";
		String JOB_DETAIL_ID	=	"job_detail_id";
		String KICKER	=	"kicker";
		String TITLE	=	"title";
		String TASKS	=	"tasks";
		String SKILLS	=	"skills";
		String EXPERIENCE	=	"experience";
		String EXPECTATIONS	=	"expectations";
		String EDUCATION	=	"education";
		String LOCATION	=	"location";
		String POSTAL_CODE	=	"postal_code";
		String COUNTRY_CODE	=	"country_code";
		String START	=	"start";
		String END	=	"end";
		String DURATION	=	"duration";
		String DATE_POSTED	=	"date_posted";
		String COMPANYID	=	"companyid";
		String COMPANY_DESCRIPTION	=	"company_description";
		String CONTACT_EMAIL	=	"contact_email";
		String REWARD	=	"reward";
		String KEYWORDID	=	"keywordid";
		String VISIBLE	=	"visible";
		String ACTIVE	=	"active";
		String DATE_CREATED	=	"date_created";
	}

	/**
	*This Method is used to find the record based on Id.
	**/ 
	public JobDTO findById(int id){
		SQLMaker maker = new SQLMaker();

		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.JOBID+"="+id);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList.size()==0 ? null: resultList.get(0);
	}


	/**
	*This Method is used to delete the record based on Id.
	**/ 
	public int deleteById(int id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeDelete(TABLE_NAME,Columns.JOBID+"="+id);
		return result;
	}


	/**
	*This Method is used to Update the record based on Id.
	**/ 
	public int updateById(HashMap<String,Object> fieldAndValues,int  id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeUpdate(JobDAO.TABLE_NAME,fieldAndValues,Columns.JOBID+"="+id);
		return result;
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(JobDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(JobDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<JobDTO> findBy_Contract_type_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTRACT_TYPE_ID+"="+data);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Client_reference_id(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CLIENT_REFERENCE_ID+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Client_reference_url(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CLIENT_REFERENCE_URL+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<JobDTO> findBy_Job_detail_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.JOB_DETAIL_ID+"="+data);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Kicker(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.KICKER+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Title(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.TITLE+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Tasks(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.TASKS+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Skills(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.SKILLS+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Experience(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.EXPERIENCE+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Expectations(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.EXPECTATIONS+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Education(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.EDUCATION+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Location(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.LOCATION+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Postal_code(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.POSTAL_CODE+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<JobDTO> findBy_Country_code(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COUNTRY_CODE+"="+data);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Start(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.START+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_End(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.END+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Duration(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DURATION+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Date_posted(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DATE_POSTED+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<JobDTO> findBy_Companyid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANYID+"="+data);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Company_description(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_DESCRIPTION+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Contact_email(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTACT_EMAIL+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on double.
	**/ 
	public List<JobDTO> findBy_Reward(double data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.REWARD+"="+data);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<JobDTO> findBy_Keywordid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.KEYWORDID+"="+data);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Visible(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.VISIBLE+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Active(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.ACTIVE+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<JobDTO> findBy_Date_created(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DATE_CREATED+"='"+data+"'");
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<JobDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<JobDTO> resultList = JobDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Jobid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.JOBID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Jobid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.JOBID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Jobid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.JOBID,TABLE_NAME);
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
	public int getMaximumOf_Job_detail_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.JOB_DETAIL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Job_detail_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.JOB_DETAIL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Job_detail_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.JOB_DETAIL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Country_code(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.COUNTRY_CODE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Country_code(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.COUNTRY_CODE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Country_code(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.COUNTRY_CODE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
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
	*This Method is used to find the maximum based on double.
	**/ 
	public double getMaximumOf_Reward(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.REWARD,TABLE_NAME);
		return Double.parseDouble(result);
	}


	/**
	*This Method is used to find the minimum based on double.
	**/ 
	public double getMinimumOf_Reward(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.REWARD,TABLE_NAME);
		return Double.parseDouble(result);
	}


	/**
	*This Method is used to find the Average based on double.
	**/ 
	public double getAverageOf_Reward(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.REWARD,TABLE_NAME);
		return Double.parseDouble(result);
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Keywordid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.KEYWORDID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Keywordid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.KEYWORDID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Keywordid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.KEYWORDID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}
	
	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<JobDTO> doQuery(String query){		
		ResultSet rs = SQLUtils.doQuery(query);
		List<JobDTO> resultList = JobDTO.resultSetToJobDetails(rs);
		return resultList;
	}
	
	/**
	*This Method is used to find the record based on int.
	**/ 
	public int doUpdate(HashMap<String, Object> values,
			String query){	
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE "+TABLE_NAME+", "+Job_detailDAO.TABLE_NAME);
		SQLMaker maker = new SQLMaker();
		builder.append(maker.getQuery(values, query));		
		return SQLUtils.do_DML_Operation(builder.toString());
	}
	
}