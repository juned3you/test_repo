/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		01-04-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.Smarthopper_other_infoDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Smarthopper_other_info
**/ 
public class Smarthopper_other_infoDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="smarthopper_other_info";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String ID	=	"id";
		String REFERENCE_ID	=	"reference_id";
		String PARTICULAR	=	"particular";
		String COUNTRYID	=	"countryid";
	}

	/**
	*This Method is used to find the record based on Id.
	**/ 
	public Smarthopper_other_infoDTO findById(int id){
		SQLMaker maker = new SQLMaker();

		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.ID+"="+id);
		List<Smarthopper_other_infoDTO> resultList = Smarthopper_other_infoDTO.resultSetToDTOConversion(rs);
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
		int result = maker.executeUpdate(Smarthopper_other_infoDAO.TABLE_NAME,fieldAndValues,Columns.ID+"="+id);
		return result;
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(Smarthopper_other_infoDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(Smarthopper_other_infoDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Smarthopper_other_infoDTO> findBy_Reference_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.REFERENCE_ID+"="+data);
		List<Smarthopper_other_infoDTO> resultList = Smarthopper_other_infoDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<Smarthopper_other_infoDTO> findBy_Particular(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.PARTICULAR+"='"+data+"'");
		List<Smarthopper_other_infoDTO> resultList = Smarthopper_other_infoDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<Smarthopper_other_infoDTO> findBy_Countryid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COUNTRYID+"="+data);
		List<Smarthopper_other_infoDTO> resultList = Smarthopper_other_infoDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<Smarthopper_other_infoDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<Smarthopper_other_infoDTO> resultList = Smarthopper_other_infoDTO.resultSetToDTOConversion(rs);
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


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Reference_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.REFERENCE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Reference_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.REFERENCE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Reference_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.REFERENCE_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
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

}