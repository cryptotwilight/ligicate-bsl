package com.ligicate.dashboard.action;

import java.util.List;

import com.ligicate.algo.registration.custodian.CustodianOptInNotification;
import com.ligicate.algo.registration.custodian.CustodianRegistrationRequest;

public class MoneyManagerDashboard {

	private List<CustodianRegistrationRequest> custodianRegistrationRequests;
	private List<CustodianOptInNotification> custodianOptInNotifications;
	
	public List<CustodianRegistrationRequest> getCustodianRegistrationRequests() {
		return custodianRegistrationRequests;
	}
	public void setCustodianRegistrationRequests(List<CustodianRegistrationRequest> custodianRegistrationRequests) {
		this.custodianRegistrationRequests = custodianRegistrationRequests;
	}
	public List<CustodianOptInNotification> getCustodianOptInNotifications() {
		return custodianOptInNotifications;
	}
	public void setCustodianOptInNotifications(List<CustodianOptInNotification> custodianOptInNotifications) {
		this.custodianOptInNotifications = custodianOptInNotifications;
	}
 
	
	
}
