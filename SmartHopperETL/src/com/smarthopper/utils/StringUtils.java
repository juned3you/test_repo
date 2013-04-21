package com.smarthopper.utils;


public class StringUtils {
	
	/**
	 *	Check if th given string is null or empty. 
	 */
	public static boolean isNullOrEmpty(String data){
		return (data ==	null || data.trim().length()<1) ? true : false;	
	}

}
