package com.smarthopper.beans;

import java.io.Serializable;
import java.util.List;

public class CollectionsList implements Serializable{
	public static final long serialVersionUID = 0;
	private int collectionID;
	private String name;
	private String description;
	private int defaultViewID;
	private List<CollectionView> CollectionView;
	
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
	public int getDefaultViewID() {
		return defaultViewID;
	}
	public void setDefaultViewID(int defaultViewID) {
		this.defaultViewID = defaultViewID;
	}
	public List<CollectionView> getCollectionView() {
		return CollectionView;
	}
	public void setCollectionView(List<CollectionView> collectionView) {
		CollectionView = collectionView;
	}
		
}
