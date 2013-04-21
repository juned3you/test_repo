package com.smarthopper.utils;

import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smarthopper.exceptions.XmlResultFailureException;
import com.smarthopper.service.CollectionListService;

public class XmlUtils {

	private static Logger log = Logger.getLogger(XmlUtils.class);
	private static DocumentBuilderFactory factory;
	private static DocumentBuilder builder;

	/**
	 * Initialize one time.
	 */
	static {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (Exception e) {
			log.error("Error in XmlUtils --> " + e.getMessage());
		}
	}
	
	/*
	 * TransformerFactory tFactory = TransformerFactory.newInstance();
	 * Transformer transformer = tFactory.newTransformer();
	 * 
	 * DOMSource source = new DOMSource(document); StreamResult result =
	 * new StreamResult(System.out); transformer.transform(source,
	 * result);
	 */
	
	/**
	 * This method is used to get the node value.
	 * 
	 * @param url
	 * @param nodeName
	 * @return
	 */
	public static NodeList getNodeListFromURL(String urlName, String nodeName) {
		try {
			log.info("Going to hit on "+urlName);
			URL url = new URL(urlName);
			URLConnection uConn = url.openConnection();
			Document document = builder.parse(uConn.getInputStream());
			log.info("Xml response received.");			

			// get RootNode.
			NodeList nl = document.getFirstChild().getChildNodes();

			for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
				String name = nl.item(i).getNodeName();
				if (name.equals(nodeName)) {
					return nl.item(i).getChildNodes();
				}else if(name.equals("Result")) {
					NodeList childrenNodes = nl.item(i).getChildNodes();
					Node node = childrenNodes.item(0);					
					
					if(!node.getNodeValue().equalsIgnoreCase("Success")){
						throw new XmlResultFailureException("Failure status found in Xml result while checking "+nodeName);
					}
				}
			}

		} catch (Exception error) {			
			log.error("Error in getNodeData-->" + error.getMessage());	
			CollectionListService.NUM_OF_ERROR++;
			CollectionListService.ERROR_MESSAGES.append(error.getMessage()+"\n");
		}
		return null;
	}
	
	/**
	 * This method is used to get the node value.
	 * 
	 * @param url
	 * @param nodeName
	 * @return
	 */
	public static NodeList getRootFromURL(String urlName) {
		try {
			log.info("Going to hit on "+urlName);
			URL url = new URL(urlName);
			URLConnection uConn = url.openConnection();
			Document document = builder.parse(uConn.getInputStream());
			log.info("Xml response received.");
			// get RootNode.
			return document.getFirstChild().getChildNodes();
				
		} catch (Exception error) {
			log.error("Error in getNodeData-->" + error.getMessage());
			CollectionListService.NUM_OF_ERROR++;
			CollectionListService.ERROR_MESSAGES.append(error.getMessage()+"\n");
		}
		return null;
	}

	/**
	 * Check for Space and related text.
	 * 
	 * @param name
	 * @return
	 */
	public static boolean isInvalidData(String name) {
		if (name == null)
			return true;

		name = name.trim();
		if (name.equals("null") || name.equals("#text") || name.equals("\n")
				|| name.equals(""))
			return true;

		return false;
	}

	public static boolean isNumeric(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static void printDOM(Node node) {

		int type = node.getNodeType();
		String name = node.getNodeName();
		switch (type) {

		// print the document element
		case Node.DOCUMENT_NODE: {
			log.info(name+" type-->"+"Document");
			printDOM(((Document) node).getDocumentElement());
			break;
		}

			// print element with attributes
		case Node.ELEMENT_NODE: {
			log.info(name+" type-->"+"Element");
			NodeList children = node.getChildNodes();
			if (children != null) {
				int len = children.getLength();
				for (int i = 0; i < len; i++)
					printDOM(children.item(i));
			}
			break;
		}
			// handle entity reference nodes
		case Node.ENTITY_REFERENCE_NODE: {
			log.info(name+" type-->"+"Entity ref");
			break;
		}

			// print cdata sections
		case Node.CDATA_SECTION_NODE: {
			log.info(name+" type-->"+"CDATA");
			break;
		}

			// print text
		case Node.TEXT_NODE: {
			log.info(node.getNodeValue().trim());
			// System.out.println(node.getNodeValue().trim());
			break;
		}

			// print processing instruction
		case Node.PROCESSING_INSTRUCTION_NODE: {
			log.info(name+" type-->"+"Processing");
			break;
		}
		}

	}
}
