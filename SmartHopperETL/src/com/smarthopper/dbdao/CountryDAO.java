/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.CountryDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Country
**/ 
public class CountryDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="country";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String COUNTRYID	=	"countryid";
		String NAME	=	"name";
		String CODE	=	"code";
		String LANGUAGE_ID	=	"language_id";
	}

	/**
	*This Method is used to find the record based on Id.
	**/ 
	public CountryDTO findById(int id){
		SQLMaker maker = new SQLMaker();

		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COUNTRYID+"="+id);
		List<CountryDTO> resultList = CountryDTO.resultSetToDTOConversion(rs);
		return resultList.size()==0 ? null: resultList.get(0);
	}


	/**
	*This Method is used to delete the record based on Id.
	**/ 
	public int deleteById(int id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeDelete(TABLE_NAME,Columns.COUNTRYID+"="+id);
		return result;
	}


	/**
	*This Method is used to Update the record based on Id.
	**/ 
	public int updateById(HashMap<String,Object> fieldAndValues,int  id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeUpdate(CountryDAO.TABLE_NAME,fieldAndValues,Columns.COUNTRYID+"="+id);
		return result;
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(CountryDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(CountryDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CountryDTO> findBy_Name(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NAME+"='"+data+"'");
		List<CountryDTO> resultList = CountryDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CountryDTO> findBy_Code(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CODE+"="+data);
		List<CountryDTO> resultList = CountryDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CountryDTO> findBy_Language_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.LANGUAGE_ID+"="+data);
		List<CountryDTO> resultList = CountryDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<CountryDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<CountryDTO> resultList = CountryDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Countryid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.COUNTRYID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Countryid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.COUNTRYID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Countryid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.COUNTRYID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Code(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.CODE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Code(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.CODE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Code(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.CODE,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Language_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.LANGUAGE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Language_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.LANGUAGE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Language_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.LANGUAGE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}

}