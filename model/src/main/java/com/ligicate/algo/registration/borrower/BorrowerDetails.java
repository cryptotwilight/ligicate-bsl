package com.ligicate.algo.registration.borrower;

public class BorrowerDetails {

	private String identityHash; 
	private String location; 
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setIdentityHash(String identityHash) {
		this.identityHash = identityHash;
	}

	public static final String BORROWER = "BORROWER";

	public String getIdentityHash() {
		return identityHash;
	}

}
