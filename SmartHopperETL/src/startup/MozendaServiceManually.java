package startup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.smarthopper.beans.CollectionView;
import com.smarthopper.beans.CollectionsList;
import com.smarthopper.beans.JobDetail;
import com.smarthopper.dbdao.Import_data_logDAO;
import com.smarthopper.dbdao.JobDAO;
import com.smarthopper.dbdao.Job_detailDAO;
import com.smarthopper.dbdto.JobDTO;
import com.smarthopper.service.CollectionListService;
import com.smarthopper.utils.DateTimeUtils;
import com.smarthopper.utils.NumericUtils;
import com.smarthopper.utils.SQLUtils;

@SuppressWarnings("unchecked")
public class MozendaServiceManually implements Serializable {
	public static final long serialVersionUID = 0;
	public static final String COMPANYNAME_DELIMITER = "-";
	public static final String ACG_JOB_URL = "http://www.acg-gmbh.de/acg/index.php/Gesuchte-Skills/";
	public static final int ACG_COMPANY_ID = 8;
	
	private Logger log = Logger.getLogger(MozendaServiceManually.class);
	private final String FILE_PATH = "collectionlist.obj";
		
	private boolean canJobOverridden = false;
	private List<CollectionsList> list = null;
	private String collectionName = null;
	private String splitCompanyName[];	

	public MozendaServiceManually() {
	}

	/**
	 * Get the List of collection.
	 * 
	 * @return
	 */
	public List<CollectionsList> getList() {
		return list;
	}

	public boolean isCanJobOverridden() {
		return canJobOverridden;
	}

	/**
	 * If set true. Job already has overritten.
	 * 
	 * @param canJobOverridden
	 */
	public void setCanJobOverridden(boolean canJobOverridden) {
		this.canJobOverridden = canJobOverridden;
	}

	/**
	 * Start getting collection from Mozenda.
	 * 
	 * @param collectionIdOrName
	 *            or null(to extract all view.)
	 */
	public void startCollectionService(String collectionIdOrName) {

		CollectionListService serv = new CollectionListService();
		if (collectionIdOrName != null
				&& collectionIdOrName.trim().length() > 0)
			list = serv.getCollectioList(collectionIdOrName);
		else
			list = serv.getCollectioList(null);
		writeObject(list);
	}

	/**
	 * Insert Job in Database use viewID or null(to extract all view.)
	 * 
	 * @param viewID
	 */
	public void insertJob(int viewID) {
		if (list == null) {
			log.error("Error no collection found.");
			return;
		}

		for (CollectionsList colList : list) {
			log.info("CollectionID " + colList.getCollectionID()
					+ "Collection Name " + colList.getName());
			collectionName = colList.getName();
			splitCompanyName = getSeparatedCompanyName();
			if(splitCompanyName == null){
				log.info("No Company found.");
				continue;
			}
			for (CollectionView collectionView : colList.getCollectionView()) {
				int cViewID = collectionView.getViewID();
				log.info("View ID -- >" + cViewID);
				if (cViewID == viewID) {
					for (JobDetail job : collectionView.getJobDetails()) {
						/*if(isACGCompany())
							job.setUrl(ACG_JOB_URL);*/
						insertJob(job, collectionView);
						break;
					}
				}
			}
		}
		collectionName = null;
		insertImportLog();
		splitCompanyName = null;		
	}

	/**
	 * Insert Job in Database use viewID or null(to extract all view.)
	 * 
	 * @param viewID
	 */
	public void insertJob(CollectionsList colListID) {
		if (list == null) {
			log.error("Error no collection found.");
			return;
		}
		if (colListID == null)
			return;

		collectionName = colListID.getName();
		splitCompanyName = getSeparatedCompanyName();
		if(splitCompanyName == null){
			log.info("No Company found.");
			return;
		}
			
		for (CollectionView collectionView : colListID.getCollectionView()) {
			int cViewID = collectionView.getViewID();
			log.info("View ID -- >" + cViewID);
			if (collectionView == null)
				continue;

			if (collectionView.getJobDetails() == null)
				continue;

			for (JobDetail job : collectionView.getJobDetails()) {
				/*if(isACGCompany())
					job.setUrl(ACG_JOB_URL);*/
				insertJob(job, collectionView);
			}
		}
		collectionName = null;
		insertImportLog();
		splitCompanyName = null;		
	}

	/**
	 * Insert Job in Database use viewID or null(to extract all view.)
	 * 
	 * @param viewID
	 */
	public void insertAllJob() {
		if (list == null) {
			log.error("Error no collection found.");
			return;
		}

		for (CollectionsList colList : list) {
			log.info("CollectionID " + colList.getCollectionID()
					+ "Collection Name " + colList.getName());
			collectionName = colList.getName();
			splitCompanyName = getSeparatedCompanyName();
			if(splitCompanyName == null){
				log.info("No Company found.");
				continue;
			}
			for (CollectionView collectionView : colList.getCollectionView()) {
				log.info("View ID -- >" + collectionView.getViewID());
				for (JobDetail job : collectionView.getJobDetails()) {
					/*if(isACGCompany())
						job.setUrl(ACG_JOB_URL);*/					
					insertJob(job, collectionView);
				}
			}
		}
		collectionName = null;
		insertImportLog();
		splitCompanyName = null;		
	}
	
	/*private boolean isACGCompany(){
		// ACG company only. Acg has only One URl for all jobs.
		try {				
			if (Integer.parseInt(splitCompanyName[0]) == ACG_COMPANY_ID)
				return true;
		} catch (Exception e) {
			log.info("Error for ACG company URL --> " + e.getMessage());
		}
		return false;
	}*/
	
	/**
	 * Copy beans
	 * 
	 * @param jobDetail
	 * @return
	 */
	private void insertJob(JobDetail jobDetail, CollectionView collectionView) {		
		if (jobDetail.getClient_reference_id() == null
				&& jobDetail.getTitle() == null)
			return;

		if (jobDetail.getClient_reference_id().trim().length() == 0
				&& jobDetail.getTitle().trim().length() == 0)
			return;
		
		/*if (jobDetail.getUrl() == null)
			return;

		if (jobDetail.getUrl().trim().length() == 0)
			return;*/

		HashMap<String, Object> jobHashMap = new HashMap<String, Object>();
		String whereClause = "";
		int jobid = -1;
		List<JobDTO> listJob = null;
		Job_detailDAO jobDetailDAO = new Job_detailDAO();
		String jobTable = JobDAO.TABLE_NAME;
		String jobDetailTable = Job_detailDAO.TABLE_NAME;
		
		//Use use query if client_reference null then search using job title.
		if (jobDetail.getClient_reference_id() == null
				|| jobDetail.getClient_reference_id().trim().length() == 0) {
			StringBuilder queryString = new StringBuilder();			
			queryString.append("SELECT * FROM "+jobTable+", "+jobDetailTable + " WHERE ");
			queryString.append( jobTable+"." + JobDAO.Columns.COMPANYID + " = "+splitCompanyName[0]+" ");
			queryString.append(" AND "+jobTable+"." + JobDAO.Columns.TITLE + " = '"+jobDetail.getTitle().trim()+"' ");
			
			if(jobDetail.getUrl() != null && jobDetail.getUrl().trim().length() > 0)
				queryString.append(" AND "+jobDetailTable+"." + Job_detailDAO.Columns.COMPANY_INFORMATION_URL + " = '"+jobDetail.getUrl().trim()+"' ");
			
			queryString.append(" AND "+jobTable+"." + JobDAO.Columns.JOB_DETAIL_ID + " = "+jobDetailTable+"."+Job_detailDAO.Columns.ID);
			
			whereClause = queryString.toString();
			
			listJob = getMatchJobs(whereClause);
		} else {
			
			StringBuilder queryString = new StringBuilder();			
			queryString.append("SELECT * FROM "+jobTable+", "+jobDetailTable + " WHERE ");
			queryString.append( jobTable+"." + JobDAO.Columns.COMPANYID + " = "+splitCompanyName[0]+" ");
			queryString.append(" AND "+jobTable+"." + JobDAO.Columns.CLIENT_REFERENCE_ID + " = '"+jobDetail.getClient_reference_id().trim()+"' ");
			
			if(jobDetail.getUrl() != null && jobDetail.getUrl().trim().length() > 0)
				queryString.append(" AND "+jobDetailTable+"." + Job_detailDAO.Columns.COMPANY_INFORMATION_URL + " = '"+jobDetail.getUrl().trim()+"' ");
			
			queryString.append(" AND "+jobTable+"." + JobDAO.Columns.JOB_DETAIL_ID + " = "+jobDetailTable+"."+Job_detailDAO.Columns.ID);
			
			whereClause = queryString.toString();			
			listJob = getMatchJobs(whereClause);
		}

		if (listJob == null || listJob.size() == 0)
			jobid = -1;
		else
			jobid = listJob.size();

		try {
			// Insert Job Detail.
			jobHashMap.put(Job_detailDAO.Columns.SALARY, jobDetail.getSalary());
			jobHashMap.put(Job_detailDAO.Columns.COMPANY_CLIENT_DESCRIPTION,
					jobDetail.getCompany_client());

			jobHashMap.put(Job_detailDAO.Columns.COMPANY_INFORMATION_URL,
					jobDetail.getUrl());		

			jobHashMap.put(Job_detailDAO.Columns.CONTACT_PHONE, jobDetail
					.getContact_phone());
			jobHashMap.put(Job_detailDAO.Columns.NOTE, jobDetail.getFullText());

			if (jobid == -1) {
				jobDetailDAO.insert(jobHashMap);
				log.info("JobDetails Inserted ID ");
			}
		} catch (Exception e) {
			log.error("Error in JOb Details Insertion " + e.getMessage());
			SQLUtils.doRollback();
			return;
		}

		try {
			int jobDetailsId = SQLUtils.getQueryLastInsertID();

			// Setting Job fields.
			jobHashMap = new HashMap<String, Object>();

			jobHashMap.put(JobDAO.Columns.CLIENT_REFERENCE_ID, jobDetail
					.getClient_reference_id());

			jobHashMap.put(JobDAO.Columns.REWARD, 800.00);
			jobHashMap
					.put(
							JobDAO.Columns.DATE_CREATED,
							DateTimeUtils
									.getCurrentDateTime(DateTimeUtils.PatternConstant.DATE_TIME_ANSI));
			jobHashMap.put(JobDAO.Columns.TITLE, jobDetail.getTitle());
			jobHashMap.put(JobDAO.Columns.LOCATION, jobDetail.getLocation());
			jobHashMap.put(JobDAO.Columns.COMPANY_DESCRIPTION, jobDetail
					.getCompany_description());
			jobHashMap.put(JobDAO.Columns.TASKS, jobDetail.getTasks());
			jobHashMap.put(JobDAO.Columns.SKILLS, jobDetail.getSkills());
			jobHashMap.put(JobDAO.Columns.DURATION, jobDetail.getDuration());
			jobHashMap.put(JobDAO.Columns.COMPANYID, splitCompanyName[0]);
			jobHashMap.put(JobDAO.Columns.COUNTRY_CODE, splitCompanyName[1]);
			jobHashMap
					.put(JobDAO.Columns.CONTRACT_TYPE_ID, splitCompanyName[2]);

			if (jobDetail.getDate_posted() != null)
				jobHashMap.put(JobDAO.Columns.DATE_POSTED, jobDetail
						.getDate_posted());

			jobHashMap.put(JobDAO.Columns.START, jobDetail.getStart());
			jobHashMap.put(JobDAO.Columns.END, jobDetail.getEnd());
			jobHashMap.put(JobDAO.Columns.CONTACT_EMAIL, jobDetail
					.getContact_email());
			jobHashMap.put(JobDAO.Columns.ACTIVE, "y");
			jobHashMap.put(JobDAO.Columns.VISIBLE, "y");
			jobHashMap.put(JobDAO.Columns.JOB_DETAIL_ID, jobDetailsId);

			JobDAO jobDAO = new JobDAO();
			int result = 0;

			if (canJobOverridden && jobid != -1) {
				String ids = "";
				whereClause = whereClause.substring(whereClause.indexOf("WHERE")+5);
				for (JobDTO dto : listJob) {
					ids = ids + dto.getJob_detail_id() + ",";
					jobHashMap.put(JobDAO.Columns.JOB_DETAIL_ID, dto
							.getJob_detail_id());
					/*jobHashMap.put(JobDAO.Columns.DATE_CREATED, dto
							.getDate_created());*/
					jobHashMap
					.put(
							JobDAO.Columns.DATE_CREATED,
							DateTimeUtils
									.getCurrentDateTime(DateTimeUtils.PatternConstant.DATE_TIME_ANSI));
					whereClause = whereClause + " AND "
					+ JobDAO.Columns.JOB_DETAIL_ID + " = "
					+ dto.getJob_detail_id();
					
					result = jobDAO.doUpdate(jobHashMap, whereClause);
				}

				ids = ids.substring(0, ids.length() - 1);

				String JobDwhereClause = Job_detailDAO.Columns.ID + " IN ("
						+ ids + ")";

				// Insert Job Detail.
				jobHashMap = new HashMap<String, Object>();
				jobHashMap.put(Job_detailDAO.Columns.SALARY, jobDetail
						.getSalary());
				jobHashMap.put(
						Job_detailDAO.Columns.COMPANY_CLIENT_DESCRIPTION,
						jobDetail.getCompany_client());
				jobHashMap.put(Job_detailDAO.Columns.COMPANY_INFORMATION_URL,
						jobDetail.getUrl());
				jobHashMap.put(Job_detailDAO.Columns.NOTE, jobDetail
						.getFullText());

				jobDetailDAO.update(jobHashMap, JobDwhereClause);
				log.info("Job Updated at jobid " + jobDetail.getTitle()+" Update status "+result);

			} else if (jobid == -1) {
				result = jobDAO.insert(jobHashMap);				
				log.info("Job Inserted ID " + jobDetail.getTitle()+" Insert status "+result);
			}
			SQLUtils.doCommit();			
			CollectionListService.NUM_OF_JOBS++;
		} catch (Exception e) {
			log.error("Error in Job Insertion " + e.getMessage());
			SQLUtils.doRollback();
		}
	}

	/**
	 * Return the job id, after finding based on job title and
	 * client_reference_id
	 * 
	 * @param jobTitle
	 * @param client_reference_id
	 * @return
	 */
	public List<JobDTO> getMatchJobs(String whereClause) {
		try {
			JobDAO jDAo = new JobDAO();		
			
			List<JobDTO> jobList = jDAo.doQuery(whereClause);				
			return jobList;
		} catch (Exception e) {
			log.error("Error in finding job id " + e.getMessage());
		}
		return null;
	}

	/**
	 * Split the name of collection and extract the company-country-contract
	 * 
	 * @return
	 */
	private String[] getSeparatedCompanyName() {
		String splitCompanyName[] = new String[3];

		splitCompanyName = collectionName.split(COMPANYNAME_DELIMITER);
		if (splitCompanyName.length != 3) {
			return null;
		}

		if (!NumericUtils.isInteger(splitCompanyName[0])) {
			return null;
		}

		if (!NumericUtils.isInteger(splitCompanyName[1])) {
			return null;
		}

		if (!NumericUtils.isInteger(splitCompanyName[2])) {
			return null;
		}

		return splitCompanyName;
	}

	/**
	 * write object for CollectionList
	 * 
	 * @return
	 */
	public void writeObject(List<CollectionsList> list) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream(FILE_PATH));
			out.writeObject(list);
			out.close();
			out = null;
		} catch (Exception e) {
		}
	}

	/**
	 * Read object for CollectionList
	 * 
	 * @return
	 */
	public List<CollectionsList> readObject() {
		try {
			ObjectInputStream out = new ObjectInputStream(new FileInputStream(
					FILE_PATH));
			List<CollectionsList> list = (List<CollectionsList>) out
					.readObject();
			out.close();
			out = null;
			return list;
		} catch (Exception e) {
			log.error("Error in reading Object -- >" + e.getMessage());
		}
		return null;
	}

	/**
	 * Main method for testing
	 * 
	 * @param str
	 */
	public static void main(String str[]) {
		MozendaServiceManually mozendaService = new MozendaServiceManually();
		//mozendaService.startCollectionService(null);
		//List<CollectionsList> collectionList = mozendaService.getList();
		mozendaService.setCanJobOverridden(false);
		mozendaService.list = mozendaService.readObject();				
		for (CollectionsList colList : mozendaService.list) {
			if (colList.getDescription().startsWith("hays") ) {
				System.out.println("Name --> " + colList.getDescription());
				mozendaService.insertJob(colList);				
			}
		}
	}

	/**
	 * Make entry in Import log.
	 */
	private void insertImportLog() {
		try {
			Import_data_logDAO imDAO = new Import_data_logDAO();
			HashMap<String, Object> fields = new HashMap<String, Object>();
			fields.put(Import_data_logDAO.Columns.COMPANYID,
					splitCompanyName[0]);
			fields.put(Import_data_logDAO.Columns.CONTRACT_TYPE_ID,
					splitCompanyName[2]);
			fields.put(Import_data_logDAO.Columns.ERROR_MESSAGES,
					CollectionListService.ERROR_MESSAGES.toString());
			fields.put(Import_data_logDAO.Columns.NUM_OF_ERRORS,
					CollectionListService.NUM_OF_ERROR);
			fields
					.put(
							Import_data_logDAO.Columns.IMPORT_DATE,
							DateTimeUtils
									.getCurrentDateTime(DateTimeUtils.PatternConstant.DATE_TIME_ANSI));

			int numOfJobs = CollectionListService.NUM_OF_JOBS;
			fields.put(Import_data_logDAO.Columns.NUM_JOBS_IMPORTED, numOfJobs);
			fields.put(Import_data_logDAO.Columns.NUM_JOBS_XML_FILE, numOfJobs);
			imDAO.insert(fields);
			SQLUtils.doCommit();
			log.info("Import data log has been inserted.");
		} catch (Exception e) {
			log.error("Error in Import LOG " + e.getMessage());
			SQLUtils.doRollback();
		}
	}

}
