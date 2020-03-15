package com.ligicate.dashboard.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ligicate.algo.api.MoneyManagerTransactionManager;
import com.ligicate.algo.registration.custodian.CustodianOptInNotification;
import com.ligicate.algo.registration.custodian.CustodianRegistrationRequest;

public class DashboardBuilder {

	public static MoneyManagerDashboard getMoneyManagerDashBoad(Map<String,Object> session) throws Exception {
		List<CustodianRegistrationRequest> registrationRequests = MoneyManagerTransactionManager.findNewCustodianRegistrationRequests(session);
		List<CustodianOptInNotification> optInNotifications = MoneyManagerTransactionManager.findNewCustodianOptInNotifications(session);
		MoneyManagerDashboard dashboard = new MoneyManagerDashboard(); 
		dashboard.setCustodianRegistrationRequests(registrationRequests);
		dashboard.setCustodianOptInNotifications(optInNotifications);
		return dashboard; 
	}
	
	private static List<CustodianRegistrationRequest> getDummyRegistrationRequests() { 
		List<CustodianRegistrationRequest> registrationRequests = new ArrayList<CustodianRegistrationRequest>();
		for(int x = 0; x < 5; x++) {
				CustodianRegistrationRequest request = new CustodianRegistrationRequest(); 
				request.setCustodialAssetLimit(100000);
				request.setCustodialAssetTypes("{jewellry, furniture, vehicles}");
				request.setCustodianAddress("{Blockchain Address}");
				request.setLocation("London, UK");
				request.setName("custodian-"+x);
				registrationRequests.add(request);
		}
		return registrationRequests; 
	}
	
	private static List<CustodianOptInNotification> getDummyOptInNotifications() { 
		List<CustodianOptInNotification> optInNotifications = new ArrayList<CustodianOptInNotification>();
		for(int x = 0; x < 5; x++) {
			CustodianOptInNotification notification = new CustodianOptInNotification(); 
			notification.setCustodianId(x);
			notification.setLigatureId(100000+x);
			
			
			optInNotifications.add(notification);
		}
		return optInNotifications; 
	}
}
