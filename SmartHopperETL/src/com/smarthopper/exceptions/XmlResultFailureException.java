package com.smarthopper.exceptions;

public class XmlResultFailureException extends Exception{
	public static final long serialVersionUID = 0;
	public XmlResultFailureException(){
		
	}
	public XmlResultFailureException(String msg){
		super(msg);
	}
}
