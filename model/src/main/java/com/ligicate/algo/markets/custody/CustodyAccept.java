package com.ligicate.algo.markets.custody;

public class CustodyAccept {

	private String encryptedTermStartTrigger; 
	private double custodyFee; 
	private String assetDescription; 
	private int assetId; 
	private String encryptedAssetReturnDetails;
	private String custodianBlockchainAddress; 
	
	public String getEncryptedTermStartTrigger() {
		return encryptedTermStartTrigger;
	}
	public void setEncryptedTermStart(String encryptedTermStartTrigger) {
		this.encryptedTermStartTrigger = encryptedTermStartTrigger;
	}
	public double getCustodyFee() {
		return custodyFee;
	}
	public void setCustodyFee(double custodyFee) {
		this.custodyFee = custodyFee;
	}
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	public String getEncryptedAssetReturnDetails() {
		return encryptedAssetReturnDetails;
	}
	public void setEncryptedAssetReturnDetails(String encryptedAssetReturnDetails) {
		this.encryptedAssetReturnDetails = encryptedAssetReturnDetails;
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
	
}
