/* SNO	DATE			OWNER		STATUS		CHANGES
* 1		11-05-2010		JUNED		CREATED
*/

package com.smarthopper.beans;

import java.util.HashMap;

import com.smarthopper.dbdao.SmarthoppercompanyDAO;

/**
*This class is used as a bean of Smarthoppercompany
**/ 
public class SmarthoppercompanyBean {

	//Member Variable Declaration.
	public static final long serialVersionUID	=	0;
	private int id;
	private String company_name;
	private int registered_office_addressid;
	private int postal_addressid;
	private int office_addressid;
	private int general_email_addresses_id;
	private int invoice_email_addresses_id;
	private int sales_email_addresses_id;
	private int support_email_addresses_id;
	private String phone_number;
	private String fax_number;
	private int sales_hotlines_id;
	private int support_hotlines_id;
	private int website_addresses_id;
	private String tax_number;
	private String vat_number;
	private String commercial_register_number;
	private String commercial_register;
	private String ceo;
	private int paymentid;
	private float vat_rate;
	private int minimum_reward_id;
	private int gross_sign_on_reward_id;
	private int n_signon_rewardwithreferral_id;
	private int n_signon_rewardwithoutreferral_id;

	//id Getter and Setter method.
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	//company_name Getter and Setter method.
	public String getCompany_name(){
		return company_name;
	}
	public void setCompany_name(String company_name){
		this.company_name = company_name;
	}

	//registered_office_addressid Getter and Setter method.
	public int getRegistered_office_addressid(){
		return registered_office_addressid;
	}
	public void setRegistered_office_addressid(int registered_office_addressid){
		this.registered_office_addressid = registered_office_addressid;
	}

	//postal_addressid Getter and Setter method.
	public int getPostal_addressid(){
		return postal_addressid;
	}
	public void setPostal_addressid(int postal_addressid){
		this.postal_addressid = postal_addressid;
	}

	//office_addressid Getter and Setter method.
	public int getOffice_addressid(){
		return office_addressid;
	}
	public void setOffice_addressid(int office_addressid){
		this.office_addressid = office_addressid;
	}

	//general_email_addresses_id Getter and Setter method.
	public int getGeneral_email_addresses_id(){
		return general_email_addresses_id;
	}
	public void setGeneral_email_addresses_id(int general_email_addresses_id){
		this.general_email_addresses_id = general_email_addresses_id;
	}

	//invoice_email_addresses_id Getter and Setter method.
	public int getInvoice_email_addresses_id(){
		return invoice_email_addresses_id;
	}
	public void setInvoice_email_addresses_id(int invoice_email_addresses_id){
		this.invoice_email_addresses_id = invoice_email_addresses_id;
	}

	//sales_email_addresses_id Getter and Setter method.
	public int getSales_email_addresses_id(){
		return sales_email_addresses_id;
	}
	public void setSales_email_addresses_id(int sales_email_addresses_id){
		this.sales_email_addresses_id = sales_email_addresses_id;
	}

	//support_email_addresses_id Getter and Setter method.
	public int getSupport_email_addresses_id(){
		return support_email_addresses_id;
	}
	public void setSupport_email_addresses_id(int support_email_addresses_id){
		this.support_email_addresses_id = support_email_addresses_id;
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

	//sales_hotlines_id Getter and Setter method.
	public int getSales_hotlines_id(){
		return sales_hotlines_id;
	}
	public void setSales_hotlines_id(int sales_hotlines_id){
		this.sales_hotlines_id = sales_hotlines_id;
	}

	//support_hotlines_id Getter and Setter method.
	public int getSupport_hotlines_id(){
		return support_hotlines_id;
	}
	public void setSupport_hotlines_id(int support_hotlines_id){
		this.support_hotlines_id = support_hotlines_id;
	}

	//website_addresses_id Getter and Setter method.
	public int getWebsite_addresses_id(){
		return website_addresses_id;
	}
	public void setWebsite_addresses_id(int website_addresses_id){
		this.website_addresses_id = website_addresses_id;
	}

	//tax_number Getter and Setter method.
	public String getTax_number(){
		return tax_number;
	}
	public void setTax_number(String tax_number){
		this.tax_number = tax_number;
	}

	//vat_number Getter and Setter method.
	public String getVat_number(){
		return vat_number;
	}
	public void setVat_number(String vat_number){
		this.vat_number = vat_number;
	}

	//commercial_register_number Getter and Setter method.
	public String getCommercial_register_number(){
		return commercial_register_number;
	}
	public void setCommercial_register_number(String commercial_register_number){
		this.commercial_register_number = commercial_register_number;
	}

	//commercial_register Getter and Setter method.
	public String getCommercial_register(){
		return commercial_register;
	}
	public void setCommercial_register(String commercial_register){
		this.commercial_register = commercial_register;
	}

	//ceo Getter and Setter method.
	public String getCeo(){
		return ceo;
	}
	public void setCeo(String ceo){
		this.ceo = ceo;
	}

	//paymentid Getter and Setter method.
	public int getPaymentid(){
		return paymentid;
	}
	public void setPaymentid(int paymentid){
		this.paymentid = paymentid;
	}

	//vat_rate Getter and Setter method.
	public float getVat_rate(){
		return vat_rate;
	}
	public void setVat_rate(float vat_rate){
		this.vat_rate = vat_rate;
	}

	//minimum_reward_id Getter and Setter method.
	public int getMinimum_reward_id(){
		return minimum_reward_id;
	}
	public void setMinimum_reward_id(int minimum_reward_id){
		this.minimum_reward_id = minimum_reward_id;
	}

	//gross_sign_on_reward_id Getter and Setter method.
	public int getGross_sign_on_reward_id(){
		return gross_sign_on_reward_id;
	}
	public void setGross_sign_on_reward_id(int gross_sign_on_reward_id){
		this.gross_sign_on_reward_id = gross_sign_on_reward_id;
	}

	//n_signon_rewardwithreferral_id Getter and Setter method.
	public int getN_signon_rewardwithreferral_id(){
		return n_signon_rewardwithreferral_id;
	}
	public void setN_signon_rewardwithreferral_id(int n_signon_rewardwithreferral_id){
		this.n_signon_rewardwithreferral_id = n_signon_rewardwithreferral_id;
	}

	//n_signon_rewardwithoutreferral_id Getter and Setter method.
	public int getN_signon_rewardwithoutreferral_id(){
		return n_signon_rewardwithoutreferral_id;
	}
	public void setN_signon_rewardwithoutreferral_id(int n_signon_rewardwithoutreferral_id){
		this.n_signon_rewardwithoutreferral_id = n_signon_rewardwithoutreferral_id;
	}

	//This method convert the Beans to HashMap conversion.
	public  HashMap<String,Object> beanToMapConversion(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put(SmarthoppercompanyDAO.Columns.COMPANY_NAME,getCompany_name());
		map.put(SmarthoppercompanyDAO.Columns.REGISTERED_OFFICE_ADDRESSID,getRegistered_office_addressid());
		map.put(SmarthoppercompanyDAO.Columns.POSTAL_ADDRESSID,getPostal_addressid());
		map.put(SmarthoppercompanyDAO.Columns.OFFICE_ADDRESSID,getOffice_addressid());
		map.put(SmarthoppercompanyDAO.Columns.GENERAL_EMAIL_ADDRESSES_ID,getGeneral_email_addresses_id());
		map.put(SmarthoppercompanyDAO.Columns.INVOICE_EMAIL_ADDRESSES_ID,getInvoice_email_addresses_id());
		map.put(SmarthoppercompanyDAO.Columns.SALES_EMAIL_ADDRESSES_ID,getSales_email_addresses_id());
		map.put(SmarthoppercompanyDAO.Columns.SUPPORT_EMAIL_ADDRESSES_ID,getSupport_email_addresses_id());
		map.put(SmarthoppercompanyDAO.Columns.PHONE_NUMBER,getPhone_number());
		map.put(SmarthoppercompanyDAO.Columns.FAX_NUMBER,getFax_number());
		map.put(SmarthoppercompanyDAO.Columns.SALES_HOTLINES_ID,getSales_hotlines_id());
		map.put(SmarthoppercompanyDAO.Columns.SUPPORT_HOTLINES_ID,getSupport_hotlines_id());
		map.put(SmarthoppercompanyDAO.Columns.WEBSITE_ADDRESSES_ID,getWebsite_addresses_id());
		map.put(SmarthoppercompanyDAO.Columns.TAX_NUMBER,getTax_number());
		map.put(SmarthoppercompanyDAO.Columns.VAT_NUMBER,getVat_number());
		map.put(SmarthoppercompanyDAO.Columns.COMMERCIAL_REGISTER_NUMBER,getCommercial_register_number());
		map.put(SmarthoppercompanyDAO.Columns.COMMERCIAL_REGISTER,getCommercial_register());
		map.put(SmarthoppercompanyDAO.Columns.CEO,getCeo());
		map.put(SmarthoppercompanyDAO.Columns.PAYMENTID,getPaymentid());
		map.put(SmarthoppercompanyDAO.Columns.VAT_RATE,getVat_rate());
		map.put(SmarthoppercompanyDAO.Columns.MINIMUM_REWARD_ID,getMinimum_reward_id());
		map.put(SmarthoppercompanyDAO.Columns.GROSS_SIGN_ON_REWARD_ID,getGross_sign_on_reward_id());
		map.put(SmarthoppercompanyDAO.Columns.N_SIGNON_REWARDWITHREFERRAL_ID,getN_signon_rewardwithreferral_id());
		map.put(SmarthoppercompanyDAO.Columns.N_SIGNON_REWARDWITHOUTREFERRAL_ID,getN_signon_rewardwithoutreferral_id());
		return map;
	}
}