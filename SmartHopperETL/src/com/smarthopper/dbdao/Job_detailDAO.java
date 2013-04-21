/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.Job_detailDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Job_detail
**/ 
public class Job_detailDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="job_detail";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String ID	=	"id";
		String INDUSTRY	=	"industry";
		String COMPANY_CLIENT_DESCRIPTION	=	"company_client_description";
		String COMPANY_INFORMATION_URL	=	"company_information_url";
		String SALARY	=	"salary";
		String WORKLOAD	=	"workload";
		String CONTACT_FIRST_NAME	=	"contact_first_name";
		String CONTACT_SECOND_NAME	=	"contact_second_name";
		String CONTACT_PHONE	=	"contact_phone";
		String CONTACT_FAX	=	"contact_fax";
		String NOTE	=	"note";
		String DATE_MODIFIED	=	"date_modified";
	}

	/**
	*This Method is used to find the record based on Id.
	**/ 
	public Job_detailDTO findById(int id){
		SQLMaker maker = new SQLMaker();

		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.ID+"="+id);
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList.size()==0 ? null: resultList.get(0);
	}


	/**
	*This Method is used to delete the record based on Id.
	**/ 
	public int deleteById(int id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeDelete(TABLE_NAME,Columns.ID+"="+id);
		return result;
	}


	/**
	*This Method is used to Update the record based on Id.
	**/ 
	public int updateById(HashMap<String,Object> fieldAndValues,int  id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeUpdate(Job_detailDAO.TABLE_NAME,fieldAndValues,Columns.ID+"="+id);
		return result;
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(Job_detailDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(Job_detailDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Industry(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.INDUSTRY+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Company_client_description(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_CLIENT_DESCRIPTION+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Company_information_url(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_INFORMATION_URL+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Salary(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.SALARY+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Workload(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.WORKLOAD+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Contact_first_name(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTACT_FIRST_NAME+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Contact_second_name(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTACT_SECOND_NAME+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Contact_phone(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTACT_PHONE+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Contact_fax(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CONTACT_FAX+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Note(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NOTE+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Job_detailDTO> findBy_Date_modified(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DATE_MODIFIED+"='"+data+"'");
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<Job_detailDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<Job_detailDTO> resultList = Job_detailDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}

}