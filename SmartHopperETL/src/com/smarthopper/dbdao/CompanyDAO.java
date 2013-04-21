/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbdao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.smarthopper.dbdto.CompanyDTO;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLMaker;

/**
*This class is used to hold DAO of Company
**/ 
public class CompanyDAO {

	//This is the list of all columns in this tables to be used as Constant.
	public static final String TABLE_NAME	="company";	

	//This the list of all Attributes in the Table.
	public interface Columns{
		String COMPANYID	=	"companyid";
		String COMPANY_NAME	=	"company_name";
		String COMPANY_LOGO	=	"company_logo";
		String GENERAL_EMAIL_ADDRESS	=	"general_email_address";
		String BILLING_EMAIL_ADDRESS	=	"billing_email_address";
		String ADDITIONAL_EMAIL_ADDRESS	=	"additional_email_address";
		String PHONE_NUMBER	=	"phone_number";
		String FAX_NUMBER	=	"fax_number";
		String WEBSITE_ADDRESS	=	"website_address";
		String REGISTERED_ADDRESS_ID	=	"registered_address_id";
		String POSTAL_ADDRESS_ID	=	"postal_address_id";
		String VAT_ID	=	"vat_id";
		String COMMERCIAL_REGISTER_NUMBER	=	"commercial_register_number";
		String HAS_INVOICE_ADDRESS	=	"hasInvoiceAddress";
		String INVOICE_ADDRESS_ID	=	"invoice_address_id";
		String INVOICE_EMAIL_ADDRESS	=	"invoice_email_address";
		String PAYMENTID	=	"paymentid";
		String NUMBER_EMPLOYEEID	=	"number_employeeid";
		String DATE_MODIFIED	=	"date_modified";
	}

	/**
	*This Method is used to find the record based on Id.
	**/ 
	public CompanyDTO findById(int id){
		SQLMaker maker = new SQLMaker();

		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANYID+"="+id);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList.size()==0 ? null: resultList.get(0);
	}


	/**
	*This Method is used to delete the record based on Id.
	**/ 
	public int deleteById(int id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeDelete(TABLE_NAME,Columns.COMPANYID+"="+id);
		return result;
	}


	/**
	*This Method is used to Update the record based on Id.
	**/ 
	public int updateById(HashMap<String,Object> fieldAndValues,int  id){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeUpdate(CompanyDAO.TABLE_NAME,fieldAndValues,Columns.COMPANYID+"="+id);
		return result;
	}

	/**
	*This Method is used to record based on by using fieldName, Values as  a List.
	**/ 
	public int insert(HashMap<String,Object> fieldAndValues){
		SQLMaker maker = new SQLMaker();
		int result = maker.executeInsert(CompanyDAO.TABLE_NAME,fieldAndValues);
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
		int result = maker.executeUpdate(CompanyDAO.TABLE_NAME,fieldAndValues,whereCondition);
		return result;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Company_name(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_NAME+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Company_logo(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMPANY_LOGO+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_General_email_address(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.GENERAL_EMAIL_ADDRESS+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Billing_email_address(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.BILLING_EMAIL_ADDRESS+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Additional_email_address(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.ADDITIONAL_EMAIL_ADDRESS+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Phone_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.PHONE_NUMBER+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Fax_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.FAX_NUMBER+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Website_address(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.WEBSITE_ADDRESS+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CompanyDTO> findBy_Registered_address_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.REGISTERED_ADDRESS_ID+"="+data);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CompanyDTO> findBy_Postal_address_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.POSTAL_ADDRESS_ID+"="+data);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Vat_id(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.VAT_ID+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Commercial_register_number(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.COMMERCIAL_REGISTER_NUMBER+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Hasinvoiceaddress(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.HAS_INVOICE_ADDRESS+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CompanyDTO> findBy_Invoice_address_id(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.INVOICE_ADDRESS_ID+"="+data);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Invoice_email_address(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.INVOICE_EMAIL_ADDRESS+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CompanyDTO> findBy_Paymentid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.PAYMENTID+"="+data);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int.
	**/ 
	public List<CompanyDTO> findBy_Number_employeeid(int data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.NUMBER_EMPLOYEEID+"="+data);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on String.
	**/ 
	public List<CompanyDTO> findBy_Date_modified(String data){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName, TABLE_NAME,Columns.DATE_MODIFIED+"='"+data+"'");
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
		return resultList;
	}


	/**
	*This Method is used to find the record based on int using only where condition.
	**/ 
	public List<CompanyDTO> findAll(String whereCondition){
		SQLMaker maker = new SQLMaker();
		List<String> fieldsName = new ArrayList<String>();
		fieldsName.add("*");
		ResultSet rs = maker.executeQuery(fieldsName,TABLE_NAME,whereCondition);
		List<CompanyDTO> resultList = CompanyDTO.resultSetToDTOConversion(rs);
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
	public int getMaximumOf_Registered_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.REGISTERED_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Registered_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.REGISTERED_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Registered_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.REGISTERED_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Postal_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.POSTAL_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Postal_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.POSTAL_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Postal_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.POSTAL_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Invoice_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.INVOICE_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Invoice_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.INVOICE_ADDRESS_ID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Invoice_address_id(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.INVOICE_ADDRESS_ID,TABLE_NAME);
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
	*This Method is used to find the maximum based on int.
	**/ 
	public int getMaximumOf_Number_employeeid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMaximum(Columns.NUMBER_EMPLOYEEID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the minimum based on int.
	**/ 
	public int getMinimumOf_Number_employeeid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getMinimum(Columns.NUMBER_EMPLOYEEID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}


	/**
	*This Method is used to find the Average based on int.
	**/ 
	public int getAverageOf_Number_employeeid(){
		SQLMaker maker = new SQLMaker();
		String result = maker.getAverage(Columns.NUMBER_EMPLOYEEID,TABLE_NAME);
		int res = NumericUtils.removeDecimal(Double.parseDouble(result));
		return res;
	}

}