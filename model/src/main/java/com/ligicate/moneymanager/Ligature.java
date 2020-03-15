package com.ligicate.moneymanager;

public class Ligature {
	
	private String custodianAddress; 
	private int ligatureId; 
	private long ligatureTotal; 
	private String custodianId; 
	private String ligatureIssuanceNotes;
	
	
	public String getCustodianAddress() {
		return custodianAddress;
	}
	public void setCustodianAddress(String custodianAddress) {
		this.custodianAddress = custodianAddress;
	}
	public int getLigatureId() {
		return ligatureId;
	}
	public void setLigatureId(int ligatureId) {
		this.ligatureId = ligatureId;
	}
	public long getLigatureTotal() {
		return ligatureTotal;
	}
	public void setLigatureTotal(long ligatureTotal) {
		this.ligatureTotal = ligatureTotal;
	}
	public String getLigatureIssuanceNotes() {
		return ligatureIssuanceNotes;
	}
	public void setLigatureIssuanceNotes(String ligatureIssuanceNotes) {
		this.ligatureIssuanceNotes = ligatureIssuanceNotes;
	}
	public String getCustodianId() {
		return custodianId;
	}
	public void setCustodianId(String custodianId) {
		this.custodianId = custodianId;
	} 

}
