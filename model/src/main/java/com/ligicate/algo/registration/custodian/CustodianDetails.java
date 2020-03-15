package com.ligicate.algo.registration.custodian;

public class CustodianDetails {
	public static final String CUSTODIAN 	= "CUSTODIAN";
	public static final String NAME 		= "name";
	public static final String LOCATION 	= "location";
	public static final String ASSET_TYPES 	= "asset-types";
	public static final String ASSET_LIMIT 	= "asset-limit";
	private String name; 
	private String location; 
	private int custodialAssetLimit; 
	private String custodialAssetTypes;
	private String custodianAddress; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCustodialAssetLimit() {
		return custodialAssetLimit;
	}
	public void setCustodialAssetLimit(int custodialAssetLimit) {
		this.custodialAssetLimit = custodialAssetLimit;
	}
	public String getCustodialAssetTypes() {
		return custodialAssetTypes;
	}
	public void setCustodialAssetTypes(String custodialAssetTypes) {
		this.custodialAssetTypes = custodialAssetTypes;
	}
	public String getCustodianAddress() {
		return custodianAddress;
	}
	public void setCustodianAddress(String custodianAddress) {
		this.custodianAddress = custodianAddress;
	}
	
}
