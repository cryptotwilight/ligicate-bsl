package com.ligicate.algo.markets.custody;

public class CustodyRequest {
	private int assetId; 
	private String assetDescription; 
	private int custodyTerm; 
	private String custodyTermUnits; 
	private String custodyLocationRestriction;
	private String ownerLocation; 
	
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	public int getCustodyTerm() {
		return custodyTerm;
	}
	public void setCustodyTerm(int custodyTerm) {
		this.custodyTerm = custodyTerm;
	}
	public String getCustodyTermUnits() {
		return custodyTermUnits;
	}
	public void setCustodyTermUnits(String custodyTermUnits) {
		this.custodyTermUnits = custodyTermUnits;
	}
	public String getCustodyLocationRestriction() {
		return custodyLocationRestriction;
	}
	public void setCustodyLocationRestriction(String custodyLocationRestriction) {
		this.custodyLocationRestriction = custodyLocationRestriction;
	}
	public String getOwnerLocation() {
		return ownerLocation;
	}
	public void setOwnerLocation(String ownerLocation) {
		this.ownerLocation = ownerLocation;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	} 
}
