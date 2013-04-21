/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		31-03-2010		JUNED		CREATED
*/

package com.smarthopper.dbobject;

import java.util.HashMap;

import com.smarthopper.dbdao.CompanyDAO;

/**
*This class is used as a bean of Company
**/ 
public class CompanyBean{

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
	private int companyid;
	private String company_name;
	private String company_logo;
	private String general_email_address;
	private String billing_email_address;
	private String additional_email_address;
	private String phone_number;
	private String fax_number;
	private String website_address;
	private int registered_address_id;
	private int postal_address_id;
	private String vat_id;
	private String commercial_register_number;
	private String hasinvoiceaddress;
	private int invoice_address_id;
	private String invoice_email_address;
	private int paymentid;
	private int number_employeeid;
	private String date_modified;

	//companyid Getter and Setter method.
	public int getCompanyid(){
		return companyid;
	}
	public void setCompanyid(int companyid){
		this.companyid = companyid;
	}

	//company_name Getter and Setter method.
	public String getCompany_name(){
		return company_name;
	}
	public void setCompany_name(String company_name){
		this.company_name = company_name;
	}

	//company_logo Getter and Setter method.
	public String getCompany_logo(){
		return company_logo;
	}
	public void setCompany_logo(String company_logo){
		this.company_logo = company_logo;
	}

	//general_email_address Getter and Setter method.
	public String getGeneral_email_address(){
		return general_email_address;
	}
	public void setGeneral_email_address(String general_email_address){
		this.general_email_address = general_email_address;
	}

	//billing_email_address Getter and Setter method.
	public String getBilling_email_address(){
		return billing_email_address;
	}
	public void setBilling_email_address(String billing_email_address){
		this.billing_email_address = billing_email_address;
	}

	//additional_email_address Getter and Setter method.
	public String getAdditional_email_address(){
		return additional_email_address;
	}
	public void setAdditional_email_address(String additional_email_address){
		this.additional_email_address = additional_email_address;
	}

	//phone_number Getter and Setter method.
	public String getPhone_number(){
		return phone_number;
	}
	public void setPhone_number(String phone_number){
		this.phone_number = phone_number;
	}

	//fax_number Getter and Setter method.
	public String getFax_number(){
		return fax_number;
	}
	public void setFax_number(String fax_number){
		this.fax_number = fax_number;
	}

	//website_address Getter and Setter method.
	public String getWebsite_address(){
		return website_address;
	}
	public void setWebsite_address(String website_address){
		this.website_address = website_address;
	}

	//registered_address_id Getter and Setter method.
	public int getRegistered_address_id(){
		return registered_address_id;
	}
	public void setRegistered_address_id(int registered_address_id){
		this.registered_address_id = registered_address_id;
	}

	//postal_address_id Getter and Setter method.
	public int getPostal_address_id(){
		return postal_address_id;
	}
	public void setPostal_address_id(int postal_address_id){
		this.postal_address_id = postal_address_id;
	}

	//vat_id Getter and Setter method.
	public String getVat_id(){
		return vat_id;
	}
	public void setVat_id(String vat_id){
		this.vat_id = vat_id;
	}

	//commercial_register_number Getter and Setter method.
	public String getCommercial_register_number(){
		return commercial_register_number;
	}
	public void setCommercial_register_number(String commercial_register_number){
		this.commercial_register_number = commercial_register_number;
	}

	//hasinvoiceaddress Getter and Setter method.
	public String getHasinvoiceaddress(){
		return hasinvoiceaddress;
	}
	public void setHasinvoiceaddress(String hasinvoiceaddress){
		this.hasinvoiceaddress = hasinvoiceaddress;
	}

	//invoice_address_id Getter and Setter method.
	public int getInvoice_address_id(){
		return invoice_address_id;
	}
	public void setInvoice_address_id(int invoice_address_id){
		this.invoice_address_id = invoice_address_id;
	}

	//invoice_email_address Getter and Setter method.
	public String getInvoice_email_address(){
		return invoice_email_address;
	}
	public void setInvoice_email_address(String invoice_email_address){
		this.invoice_email_address = invoice_email_address;
	}

	//paymentid Getter and Setter method.
	public int getPaymentid(){
		return paymentid;
	}
	public void setPaymentid(int paymentid){
		this.paymentid = paymentid;
	}

	//number_employeeid Getter and Setter method.
	public int getNumber_employeeid(){
		return number_employeeid;
	}
	public void setNumber_employeeid(int number_employeeid){
		this.number_employeeid = number_employeeid;
	}

	//date_modified Getter and Setter method.
	public String getDate_modified(){
		return date_modified;
	}
	public void setDate_modified(String date_modified){
		this.date_modified = date_modified;
	}

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(CompanyDAO.Columns.COMPANY_NAME,getCompany_name());
		map.put(CompanyDAO.Columns.COMPANY_LOGO,getCompany_logo());
		map.put(CompanyDAO.Columns.GENERAL_EMAIL_ADDRESS,getGeneral_email_address());
		map.put(CompanyDAO.Columns.BILLING_EMAIL_ADDRESS,getBilling_email_address());
		map.put(CompanyDAO.Columns.ADDITIONAL_EMAIL_ADDRESS,getAdditional_email_address());
		map.put(CompanyDAO.Columns.PHONE_NUMBER,getPhone_number());
		map.put(CompanyDAO.Columns.FAX_NUMBER,getFax_number());
		map.put(CompanyDAO.Columns.WEBSITE_ADDRESS,getWebsite_address());
		map.put(CompanyDAO.Columns.REGISTERED_ADDRESS_ID,getRegistered_address_id());
		map.put(CompanyDAO.Columns.POSTAL_ADDRESS_ID,getPostal_address_id());
		map.put(CompanyDAO.Columns.VAT_ID,getVat_id());
		map.put(CompanyDAO.Columns.COMMERCIAL_REGISTER_NUMBER,getCommercial_register_number());
		map.put(CompanyDAO.Columns.HAS_INVOICE_ADDRESS,getHasinvoiceaddress());
		map.put(CompanyDAO.Columns.INVOICE_ADDRESS_ID,getInvoice_address_id());
		map.put(CompanyDAO.Columns.INVOICE_EMAIL_ADDRESS,getInvoice_email_address());
		map.put(CompanyDAO.Columns.PAYMENTID,getPaymentid());
		map.put(CompanyDAO.Columns.NUMBER_EMPLOYEEID,getNumber_employeeid());
		map.put(CompanyDAO.Columns.DATE_MODIFIED,getDate_modified());
		return map;
	}
}