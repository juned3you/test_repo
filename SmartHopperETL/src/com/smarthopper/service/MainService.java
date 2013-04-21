package com.smarthopper.service;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.smarthopper.utils.APIDetails;

/**
 * Act as base class for some common method and attributes.
 * @author junedkhan
 */
@SuppressWarnings("unchecked")
public abstract class MainService {
	
	public static final String PROPERTY_FILE_PATH = "mozendadetails.properties";
	public static final String RESULT = "Result";
	public static final String NAME = "NAME";
	public static final String COLLECTIONID = "CollectionID";
	public static final String DESCRIPTION = "Description";	
	
	private static Logger log = Logger.getLogger(MainService.class);	
	public static Properties propertiesFile;
	public abstract List getDataList();	
	
	public List getDataList(String param){
		return null;
	}
	
	/**
	 * Read Property File from the Src folder.
	 */
	protected void initializeProperties(){
		try{
			if(propertiesFile != null)
				return;
			
			propertiesFile = new Properties();			
			propertiesFile.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_PATH));			
		}catch(Exception e){
			log.error("ERROR in Property initialize --> "+e.getMessage());
		}
	}	
	
	/**
	 * Compose the url without method
	 * @return
	 */
	public String getURL(String operationName){
		initializeProperties();
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(APIDetails.URL);
		urlBuilder.append(APIDetails.SERVICE_PARAM+"="+"Mozenda10");		
		if(propertiesFile != null)			
			urlBuilder.append("&"+APIDetails.WEB_SERVICE_KEY_PARAM+"="+propertiesFile.getProperty(APIDetails.WEB_SERVICE_KEY_PARAM));		
		urlBuilder.append("&"+APIDetails.OPERATION_PARAM+"="+operationName);		
		return urlBuilder.toString();
	}		
}
