package com.pawnmystuff.algo;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.AlgodClient;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.ligicate.algo.api.CustodianTransactionManager;
import com.ligicate.algo.api.IntegrationKeys;
import com.ligicate.algo.registration.custodian.CustodianDetails;

public class Custodian {

	public static void main(String[] args) {
		// create account 
		// recieve generated ligature 
		// recieve fee 
		// transfer ligature to borrower
		// getAccounts(); 
		registerWithMoneyManager();

	}

	private static void getAccounts() { 
		for(int x = 0; x < 5 ; x++) {
			try { 
			String seed = "custodian-"+x; 
			Account account = new Account(seed.getBytes());
			note("seed: " + seed + " - account :"+ account.getAddress() );
			
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void registerWithMoneyManager() {
		try {
			Map<String, Object> session = initializeAlgorand();
				for(int x = 0 ; x < 5; x++) {
					CustodianDetails details = new CustodianDetails();
					details.setCustodialAssetLimit(10000+x);
					details.setCustodialAssetTypes("jewellery, watch, furniture, antique, vehicle");
					details.setLocation("London, UK");
					details.setName("test-custodian");
					Account account = new Account(("custodian-"+x).getBytes());
					session.put(IntegrationKeys.ALGORAND_USER_ACCOUNT, account);
					details.setCustodianAddress(((Account)session.get(IntegrationKeys.ALGORAND_USER_ACCOUNT)).getAddress().toString());
					String txid = CustodianTransactionManager.registerWithMoneyManager(session, details);
					note("Transaction ID " + txid);
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void note(String msg) {
		System.out.println("custodian : " +msg);
	}

	private static Map<String, Object> initializeAlgorand() throws NoSuchAlgorithmException { 
		Map<String, Object> session = new HashMap<String, Object>();
		String ALGOD_API_ADDR = "https://testnet-algorand.api.purestake.io/ps1";
		String API_KEY = "{api-key}";
		AlgodClient client = new AlgodClient();
		client.setBasePath(ALGOD_API_ADDR);
        client.addDefaultHeader("X-API-Key", API_KEY);
        AlgodApi api = new AlgodApi(client);
        
        
        session.put(IntegrationKeys.ALGORAND_API, api);
        session.put(IntegrationKeys.ALGORAND_API_ADDRESS, ALGOD_API_ADDR);
        session.put(IntegrationKeys.ALGORAND_API_CLIENT, client);
        session.put(IntegrationKeys.ALGORAND_API_KEY, API_KEY);
       
        
        return session; 
	}
	
}
