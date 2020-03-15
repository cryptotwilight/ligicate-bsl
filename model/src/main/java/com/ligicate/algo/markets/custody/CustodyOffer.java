package com.ligicate.algo.markets.custody;

public class CustodyOffer {
	
	private int assetId; 
	private String assetDescription; 
	private int custodyTerm; 
	private int custodyUnits; 
	private double custodyFee; // including return fee 
	private int ligatureId; // id of the ligature that will be issued
	private String custodyLocation;  
	private String custodyNotes; // any notes or disclaimers about the custody
	private String custodianBlockchainAddress; 
	private long offEerExpiryDate; 
	
	public int getCustodyTerm() {
		return custodyTerm;
	}
	public void setCustodyTerm(int custodyTerm) {
		this.custodyTerm = custodyTerm;
	}
	public int getCustodyUnits() {
		return custodyUnits;
	}
	public void setCustodyUnits(int custodyUnits) {
		this.custodyUnits = custodyUnits;
	}
	public double getCustodyFee() {
		return custodyFee;
	}
	public void setCustodyFee(double custodyFee) {
		this.custodyFee = custodyFee;
	}
	public int getLigatureId() {
		return ligatureId;
	}
	public void setLigatureId(int ligatureId) {
		this.ligatureId = ligatureId;
	}
	public String getCustodyLocation() {
		return custodyLocation;
	}
	public void setCustodyLocation(String custodyLocation) {
		this.custodyLocation = custodyLocation;
	}

	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	public String getCustodyNotes() {
		return custodyNotes;
	}
	public void setCustodyNotes(String custodyNotes) {
		this.custodyNotes = custodyNotes;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public String getCustodianBlockchainAddress() {
		return custodianBlockchainAddress;
	}
	public void setCustodianBlockchainAddress(String custodianBlockchainAddress) {
		this.custodianBlockchainAddress = custodianBlockchainAddress;
	}
	public long getOffEerExpiryDate() {
		return offEerExpiryDate;
	}
	public void setOffEerExpiryDate(long offEerExpiryDate) {
		this.offEerExpiryDate = offEerExpiryDate;
	} 
}
