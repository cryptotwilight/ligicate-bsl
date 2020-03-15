package com.ligicate.dashboard.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ligicate.keys.NavigationKeys;
import com.opensymphony.xwork2.ActionSupport;

public class DashboardAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session; 

	private static final String DASHBOARD_PAGE = "dashboard"; 
	
	public String execute() {
		String result = DASHBOARD_PAGE; 
		
		
		return result; 
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session; 
	}

}
