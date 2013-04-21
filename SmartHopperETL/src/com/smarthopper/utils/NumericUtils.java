package com.smarthopper.utils;

import java.math.BigDecimal;

/**
 * 	This class is use as Number utility for testing the given number
 * 	is number or not, also check for length. We can also set the decimal for
 * 	the given value.
 * @author juned
 */
public class NumericUtils {

	/**
	 * Check for Integer value.
	 */
	public static boolean isInteger(String number) {

		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check for Float value.
	 */
	public static boolean isFloat(String number) {

		try {
			Float.parseFloat(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check for Byte value.
	 */
	public static boolean isByte(String number) {

		try {
			Byte.parseByte(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check for Short value.
	 */
	public static boolean isShort(String number) {

		try {
			Short.parseShort(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check for double value.
	 */
	public static boolean isDouble(String number) {

		try {
			Double.parseDouble(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check for long value.
	 */
	public static boolean isLong(String number) {

		try {
			Long.parseLong(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check length of any datatype given.
	 */
	public static int checkLength(Object data) {
		try {
			String temp = String.valueOf(data);
			if (temp == null || temp.equalsIgnoreCase("null"))
				return -1;
			return temp.trim().length();
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * Check for Zero value.
	 */
	public static boolean isZero(Number data) {
		try {			
			double d = data.doubleValue();
			if(d == 0.0)
				return true;
			else			
				return false;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Check for Negative value.
	 */
	public static boolean isNegative(Number data) {
		try {			
			double d = data.doubleValue();			
			if(d < 0.0)
				return true;
			else			
				return false;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Check for positive value.
	 */
	public static boolean isPositive(Number data) {
		try {			
			double d = data.doubleValue();
			
			if(d > 0.0)
				return true;
			else			
				return false;
			
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Set the Decimal of the given value arg is the value to be formatted
	 * numberOfDecimal arg is the number of decimal point to set.
	 */
	public static float setDecimal(float value, int numberOfDecimal) {
		BigDecimal dec = new BigDecimal(value);
		dec = dec.setScale(numberOfDecimal, BigDecimal.ROUND_HALF_UP);
		return dec.floatValue();
	}
	
	/**
	 * remove the Decimal of the given value arg is the value to be formatted
	 */
	public static int removeDecimal(double value) {
		BigDecimal dec = new BigDecimal(value);		
		return dec.intValue();
	}

	/**
	 * Set the Decimal of the given value value arg is the value to be formatted
	 * numberOfDecimal argis the number of decimal point to set.
	 */
	public static double setDecimal(double value, int numberOfDecimal) {
		BigDecimal dec = new BigDecimal(value);
		dec = dec.setScale(numberOfDecimal, BigDecimal.ROUND_HALF_UP);
		return dec.doubleValue();
	}

	public static void main(String s[]) {
		System.out.println("Neg Value--> " + isNegative(-6.0));
		System.out.print("Pos Value--> " + isPositive(-6.0));		
	}
}
