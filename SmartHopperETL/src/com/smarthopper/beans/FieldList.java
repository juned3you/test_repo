package com.smarthopper.beans;

import java.io.Serializable;

public class FieldList implements Serializable{
	public static final long serialVersionUID = 0;
	
	private int fieldID;
	private int collectionID;
	private String name;
	private String description;
	private boolean isSystem;
	private boolean isMatchUp;
	
	public int getFieldID() {
		return fieldID;
	}
	public void setFieldID(int fieldID) {
		this.fieldID = fieldID;
	}
	public int getCollectionID() {
		return collectionID;
	}
	public void setCollectionID(int collectionID) {
		this.collectionID = collectionID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isSystem() {
		return isSystem;
	}
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	public boolean isMatchUp() {
		return isMatchUp;
	}
	public void setMatchUp(boolean isMatchUp) {
		this.isMatchUp = isMatchUp;
	}	
}
