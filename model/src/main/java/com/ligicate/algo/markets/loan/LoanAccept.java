package com.ligicate.algo.markets.loan;

public class LoanAccept {

	private int assetId; 
	private int ligatureId; 
	private String acceptanceStatement; 
	private String swapAddress; // this is where the loan will be swapped for the ligature
	public int getLigatureId() {
		return ligatureId;
	}
	public void setLigatureId(int ligatureId) {
		this.ligatureId = ligatureId;
	}
	public String getAcceptanceStatement() {
		return acceptanceStatement;
	}
	public void setAcceptanceStatement(String acceptanceStatement) {
		this.acceptanceStatement = acceptanceStatement;
	}
	public String getSwapAddress() {
		return swapAddress;
	}
	public void setSwapAddress(String swapAddress) {
		this.swapAddress = swapAddress;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	
}
