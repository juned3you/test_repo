package com.smarthopper.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smarthopper.beans.JobDetail;
import com.smarthopper.utils.APIDetails;
import com.smarthopper.utils.XmlUtils;

@SuppressWarnings("unchecked")
public class JobDetailService extends MainService{
	private static Logger log = Logger.getLogger(JobDetailService.class);
	private final String TITLE = "title";
	private final String LOCATION = "location";
	private final String SALARY = "salary";
	private final String DATE_POSTED = "date-posted";
	private final String CLIENT_REF_URL = "client-reference-id";
	private final String COMPANY_CLIENT = "company-client";
	private final String FULLTEXT = "fulltext";
	private final String URL = "url";
	private final String START="start";
	private final String END="end";
	private final String CONTACT_EMAIL="contact-email";
	private final String CONTACT_PHONE="contact-phone";
	private final String DURATION = "duration";
	private final String TASKS = "tasks";
	private final String SKILLS = "skills";
	private final String COMPANY_DESCRIPTION = "company-description";
	private final String COMPANY_DESCRIPTION1 = "company description";
	private final String INDUSTRY = "industry";
	
	@Override
	public List getDataList() {	
		return null;
	}	
	
	@Override
	public List getDataList(String param) {
		log.info("Starting JobService extraction");
		List<JobDetail> collectionList = new ArrayList<JobDetail>();
		
		String url = getURL(APIDetails.VIEWS_GETITEMS);
		url = url+"&"+APIDetails.VIEWID_PARAM+"="+param;
		
		NodeList collectionListNodes = XmlUtils.getNodeListFromURL(url, "ItemList");		
		
		if (collectionListNodes == null)
			return null;
		
		for(int counter = 0 ; counter < collectionListNodes.getLength(); counter++){
			Node collectionNode = collectionListNodes.item(counter);
			if(collectionNode == null)
				continue;
			
			if(collectionNode.getNodeName().equalsIgnoreCase("Item")){
				NodeList childrenNodes = collectionNode.getChildNodes();
				collectionList.add(getBean(childrenNodes));			
			}
		}
		log.info("JobService extraction done.");
		return collectionList;
	}



	/**
	 * Creates Job Details from the Collection node.
	 * @param nodelist
	 * @return
	 */
	private JobDetail getBean(NodeList nodelist){
		JobDetail bean = new JobDetail();
		for(int counter = 0 ; counter < nodelist.getLength(); counter++){
			Node parentNode = nodelist.item(counter);
			NodeList children = parentNode.getChildNodes();
			Node node = children.item(0);
					
			if(node == null)
				continue;
			
			String nodeName = parentNode.getNodeName();
			String nodeValue = node.getNodeValue();
			
			//check for Invalid data.
			if(XmlUtils.isInvalidData(nodeValue))
				continue;
			
			if(nodeName.equalsIgnoreCase(TITLE)){				
				bean.setTitle(nodeValue);
			}else if(nodeName.equalsIgnoreCase(LOCATION)){
				bean.setLocation(nodeValue);
			}else if(nodeName.equalsIgnoreCase(SALARY)){
				bean.setSalary(nodeValue);
			}else if(nodeName.equalsIgnoreCase(DATE_POSTED)){
				bean.setDate_posted(nodeValue);
			}else if(nodeName.equalsIgnoreCase(CLIENT_REF_URL)){
				bean.setClient_reference_id(nodeValue);
			}else if(nodeName.equalsIgnoreCase(COMPANY_CLIENT)){
				bean.setCompany_client(nodeValue);
			}else if(nodeName.equalsIgnoreCase(FULLTEXT)){
				bean.setFullText(nodeValue);
			}else if(nodeName.equalsIgnoreCase(URL)){
				bean.setUrl(nodeValue);
			}else if(nodeName.equalsIgnoreCase(START)){
				bean.setStart(nodeValue);
			}else if(nodeName.equalsIgnoreCase(DURATION)){
				bean.setDuration(nodeValue);
			}else if(nodeName.equalsIgnoreCase(COMPANY_DESCRIPTION)){
				bean.setCompany_description(nodeValue);				
			}else if(nodeName.equalsIgnoreCase(COMPANY_DESCRIPTION1)){
				bean.setCompany_description(nodeValue);
			}else if(nodeName.equalsIgnoreCase(TASKS)){
				bean.setTasks(nodeValue);
			}else if(nodeName.equalsIgnoreCase(SKILLS)){
				bean.setSkills(nodeValue);
			}else if(nodeName.equalsIgnoreCase(END)){
				bean.setEnd(nodeValue);
			}else if(nodeName.equalsIgnoreCase(CONTACT_EMAIL)){
				bean.setContact_email(nodeValue);
			}else if(nodeName.equalsIgnoreCase(CONTACT_PHONE)){
				bean.setContact_phone(nodeValue);
			}else if(nodeName.equalsIgnoreCase(INDUSTRY)){
				bean.setIndustry(nodeValue);
			}								
		}
		return bean;
	}	
}
