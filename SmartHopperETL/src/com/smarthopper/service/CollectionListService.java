package com.smarthopper.service;

import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smarthopper.beans.CollectionView;
import com.smarthopper.beans.CollectionsList;
import com.smarthopper.utils.APIDetails;
import com.smarthopper.utils.XmlUtils;

@SuppressWarnings("unchecked")
public class CollectionListService extends MainService {
	public static short NUM_OF_ERROR = 0;
	public static int NUM_OF_JOBS = 0;
	public static StringBuilder ERROR_MESSAGES = new StringBuilder();
	
	private Logger log = Logger.getLogger(CollectionListService.class);
	public  final String DEFAULT_VIEW_ID = "DefaultViewID";
	private CollectionViewService collViewService;

	@Override
	public List getDataList() {
		log.info("Starting CollectionList extraction");
		collViewService = new CollectionViewService();
		List<CollectionsList> collectionList = new Vector<CollectionsList>();
		String url = getURL(APIDetails.COLLECTION_GETLIST);
		NodeList collectionListNodes = XmlUtils.getNodeListFromURL(url,
				"CollectionList");

		if (collectionListNodes == null)
			return null;

		for (int counter = 0; counter < collectionListNodes.getLength(); counter++) {
			Node collectionNode = collectionListNodes.item(counter);
			if (collectionNode == null)
				continue;

			if (collectionNode.getNodeName().equalsIgnoreCase("Collection")) {
				NodeList childrenNodes = collectionNode.getChildNodes();
				collectionList.add(getBean(childrenNodes));
			}
		}
		log.info("CollectionList extraction done.");
		return collectionList;
	}

	@Override
	public List getDataList(String param) {
		log.info("Starting CollectionList extraction");
		collViewService = new CollectionViewService();
		List<CollectionsList> collectionList = new Vector<CollectionsList>();

		String url = getURL(APIDetails.COLLECTION_GETLIST);
		url = url + "&" + APIDetails.COLLECTIONID_PARAM + "=" + param;

		NodeList collectionListNodes = XmlUtils.getNodeListFromURL(url,
				"CollectionList");

		if (collectionListNodes == null)
			return null;

		for (int counter = 0; counter < collectionListNodes.getLength(); counter++) {
			Node collectionNode = collectionListNodes.item(counter);
			if (collectionNode == null)
				continue;

			if (collectionNode.getNodeName().equalsIgnoreCase("Collection")) {
				NodeList childrenNodes = collectionNode.getChildNodes();
				collectionList.add(getBean(childrenNodes));
			}
		}
		log.info("CollectionList extraction done.");
		return collectionList;
	}

	/**
	 * Creates CollectionBEan from the Collection node.
	 * 
	 * @param nodelist
	 * @return
	 */
	private CollectionsList getBean(NodeList nodelist) {

		CollectionsList bean = new CollectionsList();
		for (int counter = 0; counter < nodelist.getLength(); counter++) {
			Node parentNode = nodelist.item(counter);
			NodeList children = parentNode.getChildNodes();
			Node node = children.item(0);

			if (node == null)
				continue;

			String nodeName = parentNode.getNodeName();
			String nodeValue = node.getNodeValue();

			// check for Invalid data.
			if (XmlUtils.isInvalidData(nodeValue))
				continue;

			if (nodeName.equalsIgnoreCase(COLLECTIONID)) {
				if (XmlUtils.isNumeric(nodeValue)){
					bean.setCollectionID(Integer.parseInt(nodeValue));
					List<CollectionView> viewList = collViewService
						.getDataList(nodeValue);
					bean.setCollectionView(viewList);
				}
			} else if (nodeName.equalsIgnoreCase(NAME)) {
				bean.setName(nodeValue);
			} else if (nodeName.equalsIgnoreCase(DESCRIPTION)) {
				bean.setDescription(nodeValue);
			} else if (nodeName.equalsIgnoreCase(DEFAULT_VIEW_ID)) {
				if (XmlUtils.isNumeric(nodeValue)) 
					bean.setDefaultViewID(Integer.parseInt(nodeValue));				
			}
		}
		return bean;
	}	
	
	/**
	 * Get the list based on Either collectionid or collectionname or null get all.
	 * @param param
	 * @return
	 */
	public List<CollectionsList> getCollectioList(String param){
		List<CollectionsList> list = null;
		List<CollectionsList> resultlist = null;		
		CollectionListService serv = new CollectionListService();		
		
		if(param == null || param.trim().length() == 0){			
			list =  serv.getDataList();
			return list;
		}else if(param != null){
			try{
				param = param.trim();
				Integer.parseInt(param);
				list =  serv.getDataList(param);
				return list;				
			}catch(Exception e){								
			}
		}		
		
		list =  serv.getDataList();	
		for (CollectionsList col: list){			
			if(col.getName().trim().equalsIgnoreCase(param)){
				resultlist = new Vector<CollectionsList>();
				resultlist.add(col);
				return resultlist;
			}			
		}
		return null;
	}
}
