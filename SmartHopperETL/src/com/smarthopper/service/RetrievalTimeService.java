package com.smarthopper.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.smarthopper.dbdao.Job_retrievalDAO;
import com.smarthopper.dbdto.Job_retrievalDTO;
import com.smarthopper.dbdto.Job_retrieval_country_contract_pairDTO;
import com.smarthopper.utils.NumericUtils;

public class RetrievalTimeService {

	public final String ACTIVE = "Active";
	public final String DEACTIVE = "Deactivate";
	public final String SETUP = "Setup";
	public final String REQUESTED = "Requested";

	private Logger log = Logger.getLogger(RetrievalTimeService.class);

	private final String DELIMITER = "-";	
	private List<Job_retrievalDTO> jobRetrievalList = null;
	private Job_retrievalDTO jobDTo = null;
	private Job_retrieval_country_contract_pairDTO ccPair = null;	

	private int companyid;
	private int contractTypeid;
	private int countryid;
	private String name;
	private boolean isError = false;	
	
	public boolean isError() {
		return isError;
	}

	public Job_retrievalDTO getJobRetrieval() {
		return jobDTo;
	}	
	
	public Job_retrieval_country_contract_pairDTO getCcPair() {
		return ccPair;
	}

	public void setCcPair(Job_retrieval_country_contract_pairDTO ccPair) {
		this.ccPair = ccPair;
	}

	public RetrievalTimeService(String name) {		
		this.name = name;
		splitName();
		initializeData();
	}

	private void splitName() {
		String[] splitCompanyName = name.split(DELIMITER);
		if (splitCompanyName.length != 3) {
			isError = true;
		}

		if (!NumericUtils.isInteger(splitCompanyName[0])) {
			isError = true;
		} else {
			companyid = Integer.parseInt(splitCompanyName[0]);
		}

		if (!NumericUtils.isInteger(splitCompanyName[1])) {
			isError = true;
		} else {
			countryid = Integer.parseInt(splitCompanyName[1]);
		}

		if (!NumericUtils.isInteger(splitCompanyName[2])) {
			isError = true;
		} else {
			contractTypeid = Integer.parseInt(splitCompanyName[2]);
		}

		if (isError)
			log.error("Error in agent name --> " + name);
	}

	private void initializeData() {
		if (isError) {
			log.error("Error in agent name --> " + name);
			return;
		}
		Job_retrievalDAO jobRetrievalDAO = new Job_retrievalDAO();
		jobRetrievalList = jobRetrievalDAO.findBy_Company_id(companyid);
		isValidPair();
	}

	private boolean isValidPair() {
		boolean flag = false;
		if (isError) {
			log.error("Error in agent name --> " + name);
			return flag;
		}

		for (Job_retrievalDTO jrDTO : jobRetrievalList) {
			for (Job_retrieval_country_contract_pairDTO ccDTO : jrDTO
					.getCcList()) {
				if (contractTypeid == ccDTO.getContract_type_id()
						&& ccDTO.getCountry_id() == countryid) {
					if (!jrDTO.getStatus().trim().equals(ACTIVE)) {
						flag = false;
						log.info(name + " is not active. Status found is "
								+ jrDTO.getStatus());						
					} else if(ccDTO.getIsactive().equals("y")){
						jobDTo = jrDTO;
						ccPair = ccDTO;						
						flag = true;						
					}
					break;
				}
			}
		}
		return flag;
	}
}
