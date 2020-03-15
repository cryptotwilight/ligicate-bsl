package com.ligicate.algo.registration.custodian;

public class CustodianRegistrationAcceptance extends CustodianDetails {
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
	private String ligatureName; 
	private String ligatureUnitName;
	public String getLigatureName() {
		return ligatureName;
	}
	public void setLigatureName(String ligatureName) {
		this.ligatureName = ligatureName;
	}
	public String getLigatureUnitName() {
		return ligatureUnitName;
	}
	public void setLigatureUnitName(String ligatureUnitName) {
		this.ligatureUnitName = ligatureUnitName;
	} 
	

}
