package com.smarthopper.utils;
/**
 * Used as a Constant in Query Building.
 * @author juned 
 */
public interface DatabaseOperationConstant {
	String SELECT	=	"SELECT ";
	String INSERT_INTO	=	"INSERT INTO ";
	String UPDATE	=	"UPDATE ";
	String DELETE_FROM	=	"DELETE FROM ";
	String ALTER	= 	"ALTER ";
	String DROP 	=	"DROP ";
	
	String MAX	=	"MAX";
	String MIN	=	"MIN";
	String AVG	=	"AVG";
	String LAST_RECORD_ID	=	"LAST_INSERT_ID();";
}
