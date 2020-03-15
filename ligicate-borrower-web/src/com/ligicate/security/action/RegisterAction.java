package com.ligicate.security.action;

import com.ligicate.keys.NavigationKeys;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	private static final String REGISTRATION_CONFIRMATION_PAGE = "confirmation";
	private static final String REGISTRATION_PAGE = "register";
	
	public String execute() { 
		String result = NavigationKeys.LOGIN; 
		
		
		
		return result; 
		
	}
	
}
