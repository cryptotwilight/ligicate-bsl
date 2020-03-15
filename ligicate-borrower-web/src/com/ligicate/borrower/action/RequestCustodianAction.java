package com.ligicate.borrower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ligicate.algo.api.BorrowerTransactionManager;
import com.ligicate.algo.markets.custody.CustodyRequest;
import com.ligicate.keys.NavigationKeys;
import com.ligicate.keys.SessionKeys;
import com.ligicate.keys.SessionKeys.TRANSACTION_TYPE;
import com.opensymphony.xwork2.ActionSupport;

public class RequestCustodianAction extends ActionSupport implements SessionAware {

	private static final String CUSTODY_REQUEST_PAGE = "custody_request_page";
	
	private CustodyRequest custodyRequest; 
	private Map<String, Object> session; 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2371627310134975266L;
// request custodian offers
	
	public String execute() { 
		String result = CUSTODY_REQUEST_PAGE; 
		if(custodyRequest == null) {
			return result; 
		}
		submit(custodyRequest);
		
		result = NavigationKeys.DASHBOARD; 
		
		return result; 
	}
	
	private void submit(CustodyRequest request) {
		try { 
			String transactionId = BorrowerTransactionManager.requestCustodian(session, request);
			session.put(SessionKeys.TRANSACTION_ID, transactionId);
			session.put(SessionKeys.TRANSACTION_TYPE, TRANSACTION_TYPE.CUSTODY_REQUEST);
		}
		catch(Exception e) {
			session.put(SessionKeys.ERROR, e);
			e.printStackTrace();
		}
		
	}

	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session; 
		
	}
	
	
}
