package com.ligicate.algo.registration.custodian;

public class CustodianOptInNotification {
	
	public int getCustodianId() {
		return custodianId;
	}
	public void setCustodianId(int custodianId) {
		this.custodianId = custodianId;
	}
	public int getLigatureId() {
		return ligatureId;
	}
	public void setLigatureId(int ligatureId) {
		this.ligatureId = ligatureId;
	}
	private int custodianId; 
	private int ligatureId; 

}
