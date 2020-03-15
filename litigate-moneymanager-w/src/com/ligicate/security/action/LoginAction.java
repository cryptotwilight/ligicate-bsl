package com.ligicate.security.action;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.AlgodClient;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.ligicate.keys.NavigationKeys;
import com.ligicate.keys.SessionKeys;
import com.ligicate.keys.UserKeys;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6512700184682725272L;
	private Map<String, Object> session; 
	private boolean logout; 
	private static final String LOGIN_PAGE = "login";
	private static final String LOGOUT_PAGE = "logout";
	private String username;
	private String mnemonic; 
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}
	
	public String execute() { 
		String result = LOGIN_PAGE; 
		// authenticate 
		if(isLogout()) {
			return logout(); 
		}
		if(isAuthentic()) {
			Map<String, String> user = new HashMap<String, String>();
			user.put(UserKeys.USERNAME, getUsername());
			user.put(UserKeys.MNEMONIC, getMnemonic());
			session.put(SessionKeys.USER, user);
			initializeAlgorand();
			result = NavigationKeys.DASHBOARD; 
		}
		System.out.println("going to: " + result);
		return result;
	}
	
	private void initializeAlgorand() {
		
		String ALGOD_API_ADDR = "https://testnet-algorand.api.purestake.io/ps1";
		String API_KEY = "{api-key}";
		AlgodClient client = new AlgodClient();
		client.setBasePath(ALGOD_API_ADDR);
        client.addDefaultHeader("X-API-Key", API_KEY);
        AlgodApi api = new AlgodApi(client);
        
        
        session.put(SessionKeys.ALGORAND_API, api);
        session.put(SessionKeys.ALGORAND_API_ADDRESS, ALGOD_API_ADDR);
        session.put(SessionKeys.ALGORAND_API_CLIENT, client);
        session.put(SessionKeys.ALGORAND_API_KEY, API_KEY);
        try {
			session.put(SessionKeys.ALGORAND_USER_ACCOUNT, new Account("money-manager".getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}

	private boolean isAuthentic() {
		if(username != null && username.equals("test" ) && mnemonic != null && mnemonic.equals( "life sucks never")) {
			return true; 
		}
		return false; 
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session; 
	}
	
	public boolean isLogout() { 
		return logout;
	}
	
	public void setLogout(boolean log) {
		this.logout = log; 
	}
	private String logout() { 
		session.remove(SessionKeys.USER);
		return LOGOUT_PAGE;
	}
}
