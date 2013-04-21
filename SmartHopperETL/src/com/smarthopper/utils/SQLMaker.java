package com.smarthopper.utils;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class SQLMaker {

	/**
	 * This method First build the Query and pass to SQLUTIL for execution.
	 */
	public ResultSet executeQuery(List<String> fieldsName, String tableName,
			String whereClause) {
		ResultSet resultSet = null;
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.SELECT + " ");
		fullQuery.append(extractList(fieldsName) + " FROM ");
		fullQuery.append(tableName + " WHERE " + whereClause + ";");		
		resultSet = SQLUtils.doQuery(fullQuery.toString());
		return resultSet;
	}

	/**
	 * This method First build the Query and pass to SQLUTIL for execution.
	 */
	public ResultSet executeQuery(List<String> fieldsName, String tableName) {
		ResultSet resultSet = null;
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.SELECT + " ");
		fullQuery.append(extractList(fieldsName) + " FROM " + tableName);		
		resultSet = SQLUtils.doQuery(fullQuery.toString());
		return resultSet;
	}

	/**
	 * This method First build the Insert Query and pass to SQLUTIL for
	 * execution.
	 */
	public int executeInsert(String tableName, HashMap<String, Object> values) {
		if (values.size() == 0) {
			return 200;
		}
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.INSERT_INTO + " ");
		fullQuery.append(tableName + " (" + extractMap(values.keySet())
				+ ") VALUES (" + addValues(values) + ");");		
		return SQLUtils.do_DML_Operation(fullQuery.toString());
	}

	/**
	 * This method First build the Query and pass to SQLUTIL for execution.
	 */
	public int executeDelete(String tableName, String whereClause) {
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.DELETE_FROM + " ");
		fullQuery.append(tableName + " WHERE " + whereClause + ";");		
		return SQLUtils.do_DML_Operation(fullQuery.toString());
	}

	/**
	 * This method First build the Query and pass to SQLUTIL for execution.
	 */
	public int executeDelete(String tableName) {
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.DELETE_FROM + " "
				+ tableName);		
		return SQLUtils.do_DML_Operation(fullQuery.toString());
	}

	/**
	 * This method First build the Query and pass to SQLUTIL for execution.
	 */
	public int executeUpdate( String tableName,HashMap<String, Object> values,
			String whereClause) {
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.UPDATE + " ");
		fullQuery.append(tableName + " SET " + formatQueryForUpdate(values));
		fullQuery.append(" WHERE " + whereClause + ";");		
		return SQLUtils.do_DML_Operation(fullQuery.toString());
	}
	
	public String getQuery(HashMap<String, Object> values,
			String whereClause){
		StringBuffer fullQuery = new StringBuffer();		
		fullQuery.append(" SET " + formatQueryForUpdate(values));
		fullQuery.append(" WHERE " + whereClause + ";");
		return fullQuery.toString();
	}

	/**
	 * This method First build the Query and pass to SQLUTIL for execution.
	 */
	public int executeUpdate( String tableName,HashMap<String, Object> values) {
		StringBuffer fullQuery = new StringBuffer();
		fullQuery.append(DatabaseOperationConstant.UPDATE + " ");
		fullQuery.append(tableName + " SET " + formatQueryForUpdate(values)
				+ ";");
		System.out.println("Query--> " + fullQuery.toString());
		return SQLUtils.do_DML_Operation(fullQuery.toString());
	}
	
	/**
	 * Used to get the total number of record.
	 */
	public int getTotalNumberOfRecord(String tableName){
		return SQLUtils.getRecordCount(tableName);
	}
	
	/**
	 * Used to get the Maximum of the column given.
	 */
	public String getMaximum(String column,String tableName){
		return SQLUtils.getMaximumOfColumn(column, tableName);
	}
	
	/**
	 * Used to get the minimum of the column given.
	 */
	public String getMinimum(String column,String tableName){
		return SQLUtils.getMinimumOfColumn(column, tableName);
	}
	
	/**
	 * Used to get the average of the column given.
	 */
	public String getAverage(String column,String tableName){
		return SQLUtils.getAverageOfColumn(column, tableName);
	}
	
	
	/**
	 * Format Special char and make comma separated String using List
	 */
	private String extractList(List<String> fieldsName) {
		StringBuilder allField = new StringBuilder();
		if (fieldsName.size() == 0)
			return "*";
		if (fieldsName.size() == 1)
			return fieldsName.get(0).toString();
		for (String field : fieldsName) {
			field = formatSpecialChar(field);
			allField.append(field + ", ");
		}
		return allField.substring(0, allField.length() - 2);
	}

	/**
	 * Format Special char and make comma separated String using Map
	 */
	private String extractMap(Set<String> fieldsName) {
		StringBuilder allField = new StringBuilder();
		for (String field : fieldsName) {
			field = formatSpecialChar(field);
			allField.append(field + ", ");
		}
		return allField.substring(0, allField.length() - 2);
	}

	/**
	 * Format values for Update Query
	 */
	private String formatQueryForUpdate(HashMap<String, Object> values) {
		StringBuilder allField = new StringBuilder();
		Collection<Object> col = values.values();
		ArrayList<Object> ar = new ArrayList<Object>(col);
		int i = 0;
		for (String field : values.keySet()) {
			field = formatSpecialChar(field);
			if (ar.get(i) == null)
				allField.append(field + "='" + ar.get(i) + "', ");
			else
				allField.append(field + "='" + formatSpecialChar(ar.get(i).toString()) + "', ");
			i++;
		}
		return allField.substring(0, allField.length() - 2);
	}

	/**
	 * Format Special char and make comma separated String for Insert
	 */
	private String addValues(HashMap<String, Object> values) {
		StringBuilder allField = new StringBuilder();
		Collection<Object> col = values.values();
		ArrayList<Object> ar = new ArrayList<Object>(col);
		int size = col.size();
		for (int i = 0; i < size; i++) {
			if (ar.get(i) == null)
				allField.append("null, ");
			else
				allField.append("\'" + formatSpecialChar(ar.get(i).toString())
						+ "\', ");
		}
		return allField.substring(0, allField.length() - 2);
	}

	/**
	 * Format Special char, replacing special char
	 */
	public String formatSpecialChar(String str) {
		str = str.replaceAll("\\\\", "\\\\\\\\");
		str = str.replaceAll("'", "\\\\'");
		str = str.replaceAll("\"", "\\\\\"");
		return str;
	}

	// Main Method
	public static void main(String str[]) {
		try {
			/*
			 * SQLMaker maker = new SQLMaker(); HashMap map = new HashMap();
			 * map.put("ID", 1); map.put("ID1", "Hello");
			 * maker.executeInsert("temp", map);
			 */
		} catch (Exception e) {
			System.out.println("Error--> " + e.getMessage());
		}
	}

}
