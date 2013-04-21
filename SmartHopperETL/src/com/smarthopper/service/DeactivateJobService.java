package com.smarthopper.service;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.smarthopper.dbdao.JobDAO;
import com.smarthopper.dbdao.Job_detailDAO;
import com.smarthopper.dbdao.Job_retrievalDAO;
import com.smarthopper.dbdto.JobDTO;
import com.smarthopper.dbdto.Job_detailDTO;
import com.smarthopper.dbdto.Job_retrievalDTO;
import com.smarthopper.dbdto.Job_retrieval_country_contract_pairDTO;
import com.smarthopper.utils.DateTimeUtils;
import com.smarthopper.utils.SQLUtils;

public class DeactivateJobService {
	public static final short DAYS = 60;
	public static final int SEIMENS = 12;
	private Logger log = Logger.getLogger(DeactivateJobService.class);
	
	/**
	 * Start the deactivating process.
	 */
	public void start() {
		//doDeactivate();
		doDeactivateAfterCheckURL();		
	}

	/**
	 * Deactivate jobs more than 60 days.
	 */
	@SuppressWarnings("deprecation")
	protected void doDeactivate() {
		try {
			JobDAO jobDAO = new JobDAO();
			HashMap<String, Object> fields = new HashMap<String, Object>();
			fields.put(JobDAO.Columns.ACTIVE, "n");

			Date date = new Date();
			date.setDate(date.getDate() - DAYS);
			String formatteDate = DateTimeUtils.getFormattedDate(
					DateTimeUtils.PatternConstant.DATE_ANSI, date);
			
			String whereClause = JobDAO.Columns.ACTIVE +"="+"'n' and (("+JobDAO.Columns.DATE_POSTED+" != null and "+JobDAO.Columns.DATE_POSTED+" < '"
					+ formatteDate+"') or "+
						JobDAO.Columns.DATE_CREATED + " < '"
					+ formatteDate + "')";

			int result = jobDAO.update(fields, whereClause);
			log.info("Job " + DAYS + " days older deactivation result " + result);
			SQLUtils.doCommit();
		} catch (Exception e) {
			SQLUtils.doRollback();
			log.error("Error in Updating Job Active in db " + e.getMessage());
		}
	}

	/**
	 * Deactive job after checking URL.
	 */
	private void doDeactivateAfterCheckURL() {
		try {
			JobDAO jobDAO = new JobDAO();
			boolean isSeimens = false;
			String whereClause = JobDAO.Columns.ACTIVE + " = 'y'";
			List<JobDTO> jobList = jobDAO.findAll(whereClause);
			String ids = "";

			for (JobDTO jobd : jobList) {
				ids = ids + "," + jobd.getJob_detail_id();
			}

			ids = ids.substring(1);
			List<Job_detailDTO> jobDetailDTO = getJob_Detail(ids);

			for (Job_detailDTO jDto : jobDetailDTO) {
				String url = jDto.getCompany_information_url();
				boolean canMakeInactive = false;
				JobDTO jobDTO = getRelatedJob(jDto.getId(), jobList);				
				
				if(!isStatusOK(jobDTO))
					continue;
				
				if(url != null && url.trim().length() != 0){
					if(jobDTO.getCompanyid() != SEIMENS){
						canMakeInactive = isValidJobUrl(url, jobDTO);
						isSeimens = false;
					}else
						isSeimens = true;						
				}else if(jobDTO.getCompanyid() == SEIMENS){
					isSeimens = true;
				}

				if (canMakeInactive) {					
					HashMap<String, Object> fieldsMap = new HashMap<String, Object>();
					fieldsMap.put(JobDAO.Columns.ACTIVE, "n");
					fieldsMap.put(JobDAO.Columns.VISIBLE, "n");
					jobDAO.update(fieldsMap, JobDAO.Columns.JOB_DETAIL_ID + "="
							+ jDto.getId());
					SQLUtils.doCommit();
					log.info("Job " + jobDTO.getJobid() + " deactivated." );
				}else{
					if(isSeimens)
						log.info("Seimens Job " + jobDTO.getJobid() + " remain unchanged." );
					else
						log.info("Job " + jobDTO.getJobid() + " remain unchanged." );
				}

			}			
		} catch (Exception e) {
			SQLUtils.doRollback();
			log.error("Error in Updating Job Active in db " + e.getMessage());
		}
	}

	private List<Job_detailDTO> getJob_Detail(String ids) {
		String whereClause = Job_detailDAO.Columns.ID + " IN (" + ids + ")";
		Job_detailDAO jdDAO = new Job_detailDAO();
		return jdDAO.findAll(whereClause);
	}

	private JobDTO getRelatedJob(int jobDetailId, List<JobDTO> jobList) {
		for (JobDTO jto : jobList) {
			if (jobDetailId == jto.getJob_detail_id())
				return jto;
		}
		return null;
	}

	/**
	 * Checking for URl response.
	 * 
	 * @param strUrl
	 * @return
	 */
	private boolean isValidJobUrl(String strUrl, JobDTO jobDTO) {
		boolean result = true;
		if (strUrl == null)
			return false;

		try {
			InputStream inputStream = isValidResponseCode(strUrl);
			if (inputStream == null)
				return false;

			result = isStringMatchInURL(inputStream, jobDTO);
			return !result;
		} catch (Exception e) {
			log.error("Error in URl -> " + e.getMessage());
			result = false;
		}
		return result;
	}

	private InputStream isValidResponseCode(String strUrl) {
		try {
			URL url = new URL(strUrl);
			URLConnection uConn = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) uConn;
			boolean isValid = checkValidHTTPCode(httpConnection
					.getResponseCode());
			if (isValid)
				return uConn.getInputStream();

		} catch (Exception e) {
			log.error("Error in getting response code " + e.getMessage());
		}
		return null;
	}

	private boolean checkValidHTTPCode(int responseCode) {
		switch (responseCode) {
			case HttpURLConnection.HTTP_NOT_FOUND:
				return false;
		}
		return true;
	}

	/**
	 * match the Client_reference_id and Job title in string received from URL.
	 * 
	 * @param inputStream
	 * @param jobdto
	 * @return
	 */
	private boolean isStringMatchInURL(InputStream inputStream, JobDTO jobdto) {
		try {
			DataInputStream dataInput = new DataInputStream(inputStream);

			byte[] bytes = new byte[1024];
			int flag = 0;
			StringBuilder builder = new StringBuilder();

			while (flag != -1) {
				flag = dataInput.read(bytes);
				builder.append(new String(bytes,"UTF-8"));
			}
			
			String urlStr = builder.toString().toLowerCase().trim();			
			String client_reference_id = jobdto.getClient_reference_id();			
			String title = jobdto.getTitle();		
			
			if(client_reference_id == null || client_reference_id.trim().length() == 0)
				client_reference_id = null;
			
			if(title == null || title.trim().length() == 0)
				title = null;
			
			if (client_reference_id!=null && urlStr.indexOf(client_reference_id.toLowerCase().trim()) >= 0)
				return true;

			if (title != null && urlStr.indexOf(title.toLowerCase().trim()) >= 0)
				return true;

		} catch (Exception e) {
		}
		return false;
	}
	
	/**
	 * Check for that status in ccPair.
	 * @param jDTO
	 * @return
	 */
	private boolean isStatusOK(JobDTO jDTO){
		boolean flag = false;
		Job_retrievalDAO jobRet = new Job_retrievalDAO();
		List<Job_retrievalDTO> jobRetList  = jobRet.findBy_Company_id(jDTO.getCompanyid());		
		
		for (Job_retrievalDTO jrDTO: jobRetList){						
			for (Job_retrieval_country_contract_pairDTO ccDTO: jrDTO.getCcList()){
				if(jDTO.getContract_type_id() == ccDTO.getContract_type_id() && ccDTO.getCountry_id() == jDTO.getCountry_code()){
					if(ccDTO.getIs_use_for_deactivation().equals("y")){
						flag = true;
						break;
					}
				}
			}
		}
		jobRet = null;
		jobRetList = null;		
		return flag;
	}
	
	//&& ccDTO.getIsactive().equals("y")
}
