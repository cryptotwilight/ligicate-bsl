package com.ligicate.algo.markets.loan;

public class BorrowerSwapRequest extends SwapRequest {
	private int assetId; 
	private int ligatureId; 
	private int ligatureCount; // this should always be 1; 
	private String custodian;
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getLigatureId() {
		return ligatureId;
	}
	public void setLigatureId(int ligatureId) {
		this.ligatureId = ligatureId;
	}
	public int getLigatureCount() {
		return ligatureCount;
	}
	public void setLigatureCount(int ligatureCount) {
		this.ligatureCount = ligatureCount;
	}
	public String getCustodian() {
		return custodian;
	}
	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	private String assetDescription; 
	
}
