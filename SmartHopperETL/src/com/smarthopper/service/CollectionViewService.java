package com.smarthopper.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smarthopper.beans.CollectionView;
import com.smarthopper.beans.JobDetail;
import com.smarthopper.utils.APIDetails;
import com.smarthopper.utils.XmlUtils;

@SuppressWarnings("unchecked")
public class CollectionViewService extends MainService {
	private static Logger log = Logger.getLogger(CollectionViewService.class);
	public static final String VIEW_ID = "ViewID";	
	
	private JobDetailService jobdetailService;

	@Override
	public List getDataList() {		
		return null;
	}

	@Override
	public List getDataList(String param) {
		log.info("Starting CollectionList extraction");
		jobdetailService = new JobDetailService();
		List<CollectionView> collectionList = new ArrayList<CollectionView>();

		String url = getURL(APIDetails.COLLECTION_GETVIEWS);
		url = url + "&" + APIDetails.COLLECTIONID_PARAM + "=" + param;

		NodeList collectionListNodes = XmlUtils.getNodeListFromURL(url,
				"ViewList");

		if (collectionListNodes == null)
			return null;

		for (int counter = 0; counter < collectionListNodes.getLength(); counter++) {
			Node collectionNode = collectionListNodes.item(counter);
			if (collectionNode == null)
				continue;

			if (collectionNode.getNodeName().equalsIgnoreCase("View")) {
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
	private CollectionView getBean(NodeList nodelist) {

		CollectionView bean = new CollectionView();
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
				if (XmlUtils.isNumeric(nodeValue))
					bean.setCollectionID(Integer.parseInt(nodeValue));
			} else if (nodeName.equalsIgnoreCase(NAME)) {
				bean.setName(nodeValue);
			} else if (nodeName.equalsIgnoreCase(DESCRIPTION)) {
				bean.setDescription(nodeValue);
			} else if (nodeName.equalsIgnoreCase(VIEW_ID)) {
				if (XmlUtils.isNumeric(nodeValue)) {
					bean.setViewID(Integer.parseInt(nodeValue));
					List<JobDetail> jobList = jobdetailService
							.getDataList(nodeValue);
					bean.setJobDetails(jobList);
				}
			}
		}
		return bean;
	}
}
