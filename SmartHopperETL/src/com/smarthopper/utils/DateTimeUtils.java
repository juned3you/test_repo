package com.smarthopper.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used for getting various dateFormat and also can check for date
 * validation.
 * @author juned
 */
public class DateTimeUtils {

	/**
	 * This is the list of constant for pattern in SimpleFormat
	 * 
	 * @author juned
	 */
	public interface PatternConstant {

		String DATE_TIME_ANSI = "yyyy-MM-dd HH:mm:ss";
		String DATE_ANSI = "yyyy-MM-dd";

		String DATE_TIME_BRITISH = "dd-MM-yyyy HH:mm:ss";
		String DATE_BRITISH = "dd-MM-yyyy";

		String DATE_TIME_AMERICAN = "MM-dd-yyyy HH:mm:ss";
		String DATE_AMERICAN = "MM-dd-yyyy";

		String YEAR_FOUR_DIGIT = "yyyy";
		String YEAR_TWO_DIGIT = "yy";
		String NAME_OF_THE_MONTH = "MMM";
		String MONTH = "MM";
		String DATE = "dd";

		String TIME = "HH:mm:ss";
		String AM_PM = "aaa";
		String HOURS = "HH";
		String MINUTES = "mm";
		String SECONDS = "ss";

		String NAME_OF_THE_DAY = "EEE";
	}

	public interface DateValidation {
		String AMERICAN_FORMAT = "American";
		String BRITISH_FORMAT = "British";
		String ANSI_FORMAT = "Ansi";

		public interface ERROR {
			String MONTH_ERROR = "MONTH>12";
			String DATE_GT_28 = "DATE>28";
			String DATE_GT_29 = "DATE>29";
			String DATE_GT_30 = "DATE>30";
			String DATE_GT_31 = "DATE>31";
			String NO_ERROR = "NO_ERROR";
		}
	}

	/**
	 * Get Current Date with a pattern given as an argument.
	 */
	public static String getCurrentDateTime(String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date());
	}

	/**
	 * Get Date with a pattern given as a first argument and date to be
	 * formatted as a second argument.
	 */
	@SuppressWarnings({"deprecation"})
	public static String getFormattedDate(String pattern, String date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(new Date(date));
		} catch (Exception e) {
			System.out.println("Not a valid Date-->" + e.getMessage());
		}
		return null;
	}

	/**
	 * Get Date with a pattern given as a first argument and date to be
	 * formatted as a second argument.
	 */
	public static String getFormattedDate(String pattern, Date date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.format(date);
		} catch (Exception e) {
			System.out.println("Not a valid Date-->" + e.getMessage());
		}
		return null;
	}

	/**
	 * Get Date with a pattern given as a first argument and date to be
	 * formatted as a second argument.
	 */
	@SuppressWarnings({"deprecation"})
	public static Date getReturnAsDate(String pattern, String date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			String str = dateFormat.format(new Date(date));
			Date temp = new Date(str);
			return temp;
		} catch (Exception e) {
			System.out.println("Not a valid Date-->" + e.getMessage());
		}
		return null;
	}

	/**
	 * Get Date with a pattern given as a first argument and date to be
	 * formatted as a second argument.
	 */
	@SuppressWarnings({"deprecation"})
	public static Date getReturnAsDate(String pattern, Date date) {
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			String str = dateFormat.format(date);
			Date temp = new Date(str);
			return temp;
		} catch (Exception e) {
			System.out.println("Not a valid Date-->" + e.getMessage());
		}
		return null;
	}

	// Date validation

	

	/**
	 * Check enter date is according to month. <b>Example january has not more
	 * than 31 days.</b>
	 * 
	 * @return "ODD_ERROR", "EVEN_ERROR" ,"GT_29", "GT_28", "M_GT_12.
	 */
	public static String checkValidDateForMonth(int month, int date, int year) {

		String error = DateValidation.ERROR.NO_ERROR;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			if (date > 31)
				error = DateValidation.ERROR.DATE_GT_31;
			break;
		}

		case 4:
		case 6:
		case 9:
		case 11: {
			if (date > 30) {
				error = DateValidation.ERROR.DATE_GT_30;
			}
			break;
		}
		case 2: {
			if (year % 4 == 0 && date > 29)
				error = DateValidation.ERROR.DATE_GT_29;
			else if (date > 28)
				error = DateValidation.ERROR.DATE_GT_28;
			break;
		}
		default: {
			error = DateValidation.ERROR.MONTH_ERROR;
		}

		}

		return error;
	}

	/**
	 * Split date, provide the date validation like check for mm/dd/yy or
	 * dd/mm/yy or yy/mm/dd. You can use DateValidation interface defined in
	 * this class for format.
	 * 
	 * @return
	 */
	public static String checkValidDate(String date, String dateValidationFormat) {
		String splittedDate[] = date.split("/");

		if (splittedDate.length < 2)
			splittedDate = date.split("-");
		if (splittedDate.length < 2)
			return null;

		int mm = Integer.parseInt(splittedDate[0]);
		int dd = Integer.parseInt(splittedDate[1]);
		int yy = Integer.parseInt(splittedDate[2]);
		String result = null;

		if (dateValidationFormat.equals(DateValidation.AMERICAN_FORMAT))
			result = checkValidDateForMonth(mm, dd, yy);
		else if (dateValidationFormat.equals(DateValidation.BRITISH_FORMAT))
			result = checkValidDateForMonth(dd, mm, yy);
		else if (dateValidationFormat.equals(DateValidation.ANSI_FORMAT))
			result = checkValidDateForMonth(yy, mm, dd);

		return result;
	}

	// Main Method
	public static void main(String str[]) {
		try {
			// Date date = new Date();
			
			String dateStr = (new Date()).toString();
			System.out.println("Str Date -- > "+dateStr);
			String strDate = getFormattedDate(DateTimeUtils.PatternConstant.DATE_TIME_AMERICAN, (new Date(100)));
			
			
			System.out.println("Date--> " + strDate);
		} catch (Exception e) {
			System.out.println("Error--> " + e.getMessage());
		}
	}

}
