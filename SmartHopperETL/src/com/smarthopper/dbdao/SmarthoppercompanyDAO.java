/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		01-04-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.SmarthoppercompanyDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Smarthoppercompany
**/ 
public class SmarthoppercompanyDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="smarthoppercompany";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String ID	=	"id";
		String COMPANY_NAME	=	"company_name";
		String REGISTERED_OFFICE_ADDRESSID	=	"registered_office_addressid";
		String POSTAL_ADDRESSID	=	"postal_addressid";
		String OFFICE_ADDRESSID	=	"office_addressid";
		String GENERAL_EMAIL_ADDRESSES_ID	=	"general_email_addresses_id";
		String INVOICE_EMAIL_ADDRESSES_ID	=	"invoice_email_addresses_id";
		String SALES_EMAIL_ADDRESSES_ID	=	"sales_email_addresses_id";
		String SUPPORT_EMAIL_ADDRESSES_ID	=	"support_email_addresses_id";
		String PHONE_NUMBER	=	"phone_number";
		String FAX_NUMBER	=	"fax_number";
		String SALES_HOTLINES_ID	=	"sales_hotlines_id";
		String SUPPORT_HOTLINES_ID	=	"support_hotlines_id";
		String WEBSITE_ADDRESSES_ID	=	"website_addresses_id";
		String TAX_NUMBER	=	"tax_number";
		String VAT_NUMBER	=	"vat_number";
		String COMMERCIAL_REGISTER_NUMBER	=	"commercial_register_number";
		String COMMERCIAL_REGISTER	=	"commercial_register";
		String CEO	=	"ceo";
		String PAYMENTID	=	"paymentid";
		String VAT_RATE	=	"vat_rate";
		String MINIMUM_REWARD_ID	=	"minimum_reward_id";
		String GROSS_SIGN_ON_REWARD_ID	=	"gross_sign_on_reward_id";
		String N_SIGNON_REWARDWITHREFERRAL_ID	=	"n_signon_rewardwithreferral_id";
		String N_SIGNON_REWARDWITHOUTREFERRAL_ID	=	"n_signon_rewardwithoutreferral_id";
	}

	/**
	*This Method is used to find the record based on Id.
	**/ 
	public SmarthoppercompanyDTO findById(int id){
		SQLMaker maker = new SQLMaker();

		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.ID+"="+id);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
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
		int result = maker.executeUpdate(SmarthoppercompanyDAO.TABLE_NAME,fieldAndValues,Columns.ID+"="+id);
		return result;
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(SmarthoppercompanyDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(SmarthoppercompanyDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Company_name(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_NAME+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Registered_office_addressid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.REGISTERED_OFFICE_ADDRESSID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Postal_addressid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.POSTAL_ADDRESSID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Office_addressid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.OFFICE_ADDRESSID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_General_email_addresses_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.GENERAL_EMAIL_ADDRESSES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Invoice_email_addresses_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.INVOICE_EMAIL_ADDRESSES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Sales_email_addresses_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.SALES_EMAIL_ADDRESSES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Support_email_addresses_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.SUPPORT_EMAIL_ADDRESSES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Phone_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.PHONE_NUMBER+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Fax_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.FAX_NUMBER+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Sales_hotlines_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.SALES_HOTLINES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Support_hotlines_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.SUPPORT_HOTLINES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Website_addresses_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.WEBSITE_ADDRESSES_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Tax_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.TAX_NUMBER+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Vat_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.VAT_NUMBER+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Commercial_register_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMMERCIAL_REGISTER_NUMBER+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Commercial_register(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMMERCIAL_REGISTER+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Ceo(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.CEO+"='"+data+"'");
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Paymentid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.PAYMENTID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on float.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Vat_rate(float data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.VAT_RATE+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Minimum_reward_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.MINIMUM_REWARD_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_Gross_sign_on_reward_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.GROSS_SIGN_ON_REWARD_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_N_signon_rewardwithreferral_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.N_SIGNON_REWARDWITHREFERRAL_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<SmarthoppercompanyDTO> findBy_N_signon_rewardwithoutreferral_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.N_SIGNON_REWARDWITHOUTREFERRAL_ID+"="+data);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<SmarthoppercompanyDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<SmarthoppercompanyDTO> resultList = SmarthoppercompanyDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Registered_office_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.REGISTERED_OFFICE_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Registered_office_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.REGISTERED_OFFICE_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Registered_office_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.REGISTERED_OFFICE_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Postal_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.POSTAL_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Postal_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.POSTAL_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Postal_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.POSTAL_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Office_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.OFFICE_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Office_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.OFFICE_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Office_addressid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.OFFICE_ADDRESSID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_General_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.GENERAL_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_General_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.GENERAL_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_General_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.GENERAL_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Invoice_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.INVOICE_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Invoice_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.INVOICE_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Invoice_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.INVOICE_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Sales_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.SALES_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Sales_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.SALES_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Sales_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.SALES_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Support_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.SUPPORT_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Support_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.SUPPORT_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Support_email_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.SUPPORT_EMAIL_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Sales_hotlines_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.SALES_HOTLINES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Sales_hotlines_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.SALES_HOTLINES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Sales_hotlines_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.SALES_HOTLINES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Support_hotlines_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.SUPPORT_HOTLINES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Support_hotlines_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.SUPPORT_HOTLINES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Support_hotlines_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.SUPPORT_HOTLINES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Website_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.WEBSITE_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Website_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.WEBSITE_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Website_addresses_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.WEBSITE_ADDRESSES_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Paymentid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.PAYMENTID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Paymentid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.PAYMENTID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Paymentid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.PAYMENTID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on float.
	**/ 
	public float getMaximumOf_Vat_rate(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.VAT_RATE,TABLE_NAME);
		return Float.parseFloat(result);
	}


	/**
	*This Method is used to find the minimum based on float.
	**/ 
	public float getMinimumOf_Vat_rate(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.VAT_RATE,TABLE_NAME);
		return Float.parseFloat(result);
	}


	/**
	*This Method is used to find the Average based on float.
	**/ 
	public float getAverageOf_Vat_rate(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.VAT_RATE,TABLE_NAME);
		return Float.parseFloat(result);
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Minimum_reward_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.MINIMUM_REWARD_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Minimum_reward_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.MINIMUM_REWARD_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Minimum_reward_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.MINIMUM_REWARD_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Gross_sign_on_reward_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.GROSS_SIGN_ON_REWARD_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Gross_sign_on_reward_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.GROSS_SIGN_ON_REWARD_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Gross_sign_on_reward_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.GROSS_SIGN_ON_REWARD_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_N_signon_rewardwithreferral_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.N_SIGNON_REWARDWITHREFERRAL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_N_signon_rewardwithreferral_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.N_SIGNON_REWARDWITHREFERRAL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_N_signon_rewardwithreferral_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.N_SIGNON_REWARDWITHREFERRAL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_N_signon_rewardwithoutreferral_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.N_SIGNON_REWARDWITHOUTREFERRAL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_N_signon_rewardwithoutreferral_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.N_SIGNON_REWARDWITHOUTREFERRAL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_N_signon_rewardwithoutreferral_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.N_SIGNON_REWARDWITHOUTREFERRAL_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}

}