package com.smarthopper.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class SQLUtils {
	
	private static Logger log = Logger.getLogger(SQLUtils.class);
	private static final String PROPERTY_FILE_PATH = "dbdetails.properties";
	private static Connection connection = null;
	private static String SERVER = "server";
	private static String PORT = "port";	
	private static String USERNAME = "username";
	private static String PASSWORD = "password";
	private static String DATABASE = "database";	
	private static MysqlConnectionPoolDataSource mySql = null;
	
	private static HashMap<String, Savepoint> savePointsMap = new HashMap<String, Savepoint>();
	
	/**
	 * Make connection with db.
	 */
	private static void makeConnection(){		
		try{
		if(mySql == null){
			
			Properties propertiesFile = new Properties();			
			propertiesFile.load(SQLUtils.class.getClassLoader().getResourceAsStream(PROPERTY_FILE_PATH));
			
			/*propertiesFile.load(new FileInputStream(PROPERTY_FILE_PATH));
			if(propertiesFile == null)
				throw new Exception("Could not find db connection property file.");*/
			
			mySql = new MysqlConnectionPoolDataSource();			
			mySql.setServerName(propertiesFile.getProperty(SERVER));
			mySql.setDatabaseName(propertiesFile.getProperty(DATABASE));
			mySql.setUser(propertiesFile.getProperty(USERNAME));
			mySql.setPassword(propertiesFile.getProperty(PASSWORD));
			
			int port = Integer.parseInt(propertiesFile.getProperty(PORT));			
			mySql.setPort(port);
			mySql.setAutoReconnect(true);
			propertiesFile.clear();
			propertiesFile = null;
		}	
		}catch(Exception e){
			log.error("Error in making connection "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void createConnection(){
		try {
			if (connection == null) {
				makeConnection();				
				connection = mySql.getConnection();
				connection.setAutoCommit(false);
				/*Class.forName(driver);
				connection = DriverManager.getConnection(url + dataBase,
						userName, password);*/
				//connection.setAutoCommit(false);
				// initJNDI();
			}
		} catch (Exception e) {
			System.out.println("Error in Connection--> " + e.getMessage());
			connection = null;
		}
	}
	
	static {
		createConnection();
	}

	/*
	 * public static void initJNDI() { try { Context env = (Context) new
	 * InitialContext(); DataSource ds = (DataSource)
	 * env.lookup("java:/sh-unit"); connection = ds.getConnection();
	 * connection.setAutoCommit(false); } catch (Exception e) {
	 * System.out.println("Error in Connection--> " + e.getMessage());
	 * connection = null; } }
	 */

	
	/**
	 * Use for inserting SELECT query.
	 */
	public static ResultSet doQuery(String query) {		
		
		ResultSet resultSet = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			
			PreparedStatement pStmt = connection.prepareStatement(query);
			resultSet = pStmt.executeQuery();
		} catch (Exception e) {
			System.out.println("Error in doQuery-->" + e.getMessage());

		}
		return resultSet;
	}

	/**
	 * Use for Insert, Update, Delete operation.
	 */
	public static int do_DML_Operation(String query) {
		int isSuccessful = 0;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			PreparedStatement pStmt = connection.prepareStatement(query);
			isSuccessful = pStmt.executeUpdate();
			pStmt.close();
		} catch (Exception e) {
			System.out.println("Error in DDL Operation-->" + e.getMessage());

		}
		return isSuccessful;
	}

	/**
	 * Use to get last Record id for the DB.
	 */
	public static int getQueryLastInsertID() {
		ResultSet resultSet = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			PreparedStatement pStmt = connection
					.prepareStatement("SELECT LAST_INSERT_ID();");
			resultSet = pStmt.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				return resultSet.getInt(1);
			} else
				return 0;
		} catch (Exception e) {
			System.out.println("Error in getQueryLastInsertID-->"
					+ e.getMessage());

		}
		return 0;
	}

	/**
	 * Use to get maximum of column for the DB.
	 */
	public static String getMaximumOfColumn(String column, String tableName) {
		ResultSet resultSet = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			PreparedStatement pStmt = connection.prepareStatement("SELECT MAX("
					+ column + ") FROM " + tableName + ";");
			resultSet = pStmt.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				return resultSet.getString(1);
			} else
				return null;
		} catch (Exception e) {
			System.out.println("Error in getQueryLastInsertID-->"
					+ e.getMessage());

		}
		return null;
	}

	/**
	 * Use to get minimum of column for the DB.
	 */
	public static String getMinimumOfColumn(String column, String tableName) {
		ResultSet resultSet = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			PreparedStatement pStmt = connection.prepareStatement("SELECT MIN("
					+ column + ") FROM " + tableName + ";");
			resultSet = pStmt.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				return resultSet.getString(1);
			} else
				return null;
		} catch (Exception e) {
			System.out.println("Error in getQueryLastInsertID-->"
					+ e.getMessage());

		}
		return null;
	}

	/**
	 * Use to get average of column for the DB.
	 */
	public static String getAverageOfColumn(String column, String tableName) {
		ResultSet resultSet = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			PreparedStatement pStmt = connection.prepareStatement("SELECT AVG("
					+ column + ") FROM " + tableName + ";");
			resultSet = pStmt.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				return resultSet.getString(1);
			} else
				return null;
		} catch (Exception e) {
			System.out.println("Error in getQueryLastInsertID-->"
					+ e.getMessage());

		}
		return null;
	}

	/**
	 * Use to get total number of record.
	 */
	public static int getRecordCount(String tableName) {
		ResultSet resultSet = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			PreparedStatement pStmt = connection
					.prepareStatement("SELECT COUNT(*) FROM " + tableName + ";");
			resultSet = pStmt.executeQuery();
			if (resultSet != null) {
				resultSet.next();
				return resultSet.getInt(1);
			} else
				return 0;
		} catch (Exception e) {
			System.out.println("Error in getQueryLastInsertID-->"
					+ e.getMessage());

		}
		return 0;
	}

	/**
	 * Get the Prepared Statement for making Query.
	 */
	public static PreparedStatement getPreparedStatement(String query) {
		PreparedStatement pStmt = null;
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			pStmt = connection.prepareStatement(query);
		} catch (Exception e) {
			System.out.println("Error in getPreparedStatement-->"
					+ e.getMessage());

		}
		return pStmt;
	}

	/**
	 * return the Connection
	 */
	public static Connection getConnection() {
		return connection;
	}

	/**
	 * Set the autoCommitted property for transaction management.
	 */
	public static void setAutoCommit(boolean flag) {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			connection.setAutoCommit(flag);
		} catch (Exception e) {
			System.out.println("Error in setAutoCommit-->" + e.getMessage());

		}
	}

	/**
	 * Use to commit the transaction.
	 */
	public static void doCommit() {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			connection.commit();
		} catch (Exception e) {
			System.out.println("Error in doCommit-->" + e.getMessage());

		}
	}

	/**
	 * Use to Rollback the transaction.
	 */
	public static void doRollback() {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			connection.rollback();
		} catch (Exception e) {
			System.out.println("Error in doRollback-->" + e.getMessage());

		}
	}

	/**
	 * Use to Rollback at the name given for the transaction.
	 */
	public static void doRollback(String savePointName) {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			if (savePointsMap.size() > 0) {
				Savepoint savePoint = savePointsMap.get(savePointName);
				if (savePoint != null) {
					connection.rollback(savePoint);
					savePointsMap.remove(savePointName);
				} else
					System.out.println("No Savepoint Exist.");
			}
		} catch (Exception e) {
			System.out.println("Error in doRollback-->" + e.getMessage());

		}
	}

	/**
	 * Use to Savepoint the transaction.
	 */
	public static void doSavePoint() {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			connection.setSavepoint();
		} catch (Exception e) {
			System.out.println("Error in doSavePoint-->" + e.getMessage());

		}
	}

	/**
	 * Use to Savepoint at name given for the transaction.
	 */
	public static void doSavePoint(String savePointName) {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			Savepoint savepoint = connection.setSavepoint(savePointName);
			savePointsMap.put(savePointName, savepoint);
		} catch (Exception e) {
			System.out.println("Error in doSavePoint-->" + e.getMessage());

		}
	}

	public static SQLWarning getSQLWarning() {
		try {
			if(connection == null || connection.isClosed())
				createConnection();
			return connection.getWarnings();
		} catch (Exception e) {
			System.out.println("Error in SQLWarning-->" + e.getMessage());

		}
		return null;
	}

	/**
	 * Closing the connection
	 */
	public static void closeConnection() {
		try {
			connection.close();
			savePointsMap.clear();
			System.runFinalization();
			// connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			System.gc();
		} catch (Exception e) {
		}
	}
}
