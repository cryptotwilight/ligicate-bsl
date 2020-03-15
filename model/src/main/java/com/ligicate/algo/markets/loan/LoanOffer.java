package com.ligicate.algo.markets.loan;

public class LoanOffer {
	private int assetId; 
	private double loanAmount; // algos
	private int loanTerm; // initial term for the loan
	private double interestRate; 
	private String interestRatePeriod; // months/days/weeks
	private int defaultLimit; // how many times you can default
	private int extendLimit; // how many times you can extend
	private String administrator; // independent administrator and point of contact for this loan

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
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String getInterestRatePeriod() {
		return interestRatePeriod;
	}
	public void setInterestRatePeriod(String interestRatePeriod) {
		this.interestRatePeriod = interestRatePeriod;
	}
	public int getDefaultLimit() {
		return defaultLimit;
	}
	public void setDefaultLimit(int defaultLimit) {
		this.defaultLimit = defaultLimit;
	}
	public int getExtendLimit() {
		return extendLimit;
	}
	public void setExtendLimit(int extendLimit) {
		this.extendLimit = extendLimit;
	}
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
}
