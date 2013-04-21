package com.smarthopper.agent.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smarthopper.beans.AgentList;
import com.smarthopper.service.MainService;
import com.smarthopper.utils.APIDetails;
import com.smarthopper.utils.XmlUtils;

@SuppressWarnings("unchecked")
public class AgentListService extends MainService{
	private Logger log = Logger.getLogger(AgentListService.class);
	private final String SETTINGS = "Settings";
	private final String CREATED = "Created";
	private final String MODIFIED = "Modified";
	private final String AGENTID = "AgentID";	
			
	@Override
	public List getDataList() {
		log.info("Starting AgentList extraction");
		List<AgentList> collectionList = new ArrayList<AgentList>();
		
		String url = getURL(APIDetails.AGENT_GETLIST);		
		NodeList collectionListNodes = XmlUtils.getNodeListFromURL(url, "AgentList");		
		
		if (collectionListNodes == null)
			return null;
		
		for(int counter = 0 ; counter < collectionListNodes.getLength(); counter++){
			Node collectionNode = collectionListNodes.item(counter);
			if(collectionNode == null)
				continue;
			
			if(collectionNode.getNodeName().equalsIgnoreCase("Agent")){
				NodeList childrenNodes = collectionNode.getChildNodes();
				collectionList.add(getBean(childrenNodes));			
			}
		}
		log.info("AgentListService extraction done.");
		return collectionList;
	}



	/**
	 * Creates Job Details from the Collection node.
	 * @param nodelist
	 * @return
	 */
	private AgentList getBean(NodeList nodelist){
		AgentList bean = new AgentList();
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
			
			if(nodeName.equalsIgnoreCase(NAME)){				
				bean.setName(nodeValue);
			}else if(nodeName.equalsIgnoreCase(DESCRIPTION)){
				bean.setDescription(nodeValue);
			}else if(nodeName.equalsIgnoreCase(SETTINGS)){
				bean.setSettings(nodeValue);
			}else if(nodeName.equalsIgnoreCase(CREATED)){
				bean.setCreated(nodeValue);
			}else if(nodeName.equalsIgnoreCase(MODIFIED)){
				bean.setModified(nodeValue);
			}else if(nodeName.equalsIgnoreCase(AGENTID)){
				if (XmlUtils.isNumeric(nodeValue))
					bean.setAgentID(Integer.parseInt(nodeValue));
			}					
		}
		return bean;
	}	
}
