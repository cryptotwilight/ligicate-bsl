package com.ligicate.algo.markets.loan;

public class LoanRequest {
	
	private String assetDescription; 
	private double loanAmount; 
	private int loanTerm; 
	private String loanTermUnits; // days / weeks / months
	private int assetId; 
	
	
	public String getAssetDescription() {
		return assetDescription;
	}
	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public String getLoanTermUnits() {
		return loanTermUnits;
	}
	public void setLoanTermUnits(String loanTermUnits) {
		this.loanTermUnits = loanTermUnits;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	
}
