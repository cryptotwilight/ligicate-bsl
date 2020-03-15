package com.ligicate.dashboard.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.ligicate.keys.NavigationKeys;
import com.opensymphony.xwork2.ActionSupport;

public class DashboardAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session; 

	private static final String DASHBOARD_PAGE = "dashboard"; 
	private MoneyManagerDashboard dashboard; 
	
	public String execute() {
		String result = DASHBOARD_PAGE; 
		try {
			setDashboard(DashboardBuilder.getMoneyManagerDashBoad(session));
		} catch (Exception e) {
			e.printStackTrace();
			result = NavigationKeys.ERROR; 
		}
		
		return result; 
	}
	
	public MoneyManagerDashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(MoneyManagerDashboard dashboard) {
		System.out.println("dashboard: " + dashboard);
		this.dashboard = dashboard;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session; 
	}

}
