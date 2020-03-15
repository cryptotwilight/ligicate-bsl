package com.pawnmystuff.algo.moneymanager;

import java.math.BigInteger;

import com.algorand.algosdk.account.Account;

public class MoneyManagerActions {

	// create a fund of FT
	public CurrencyFund createCurrencyFund() {
		CurrencyFund cf = new CurrencyFund(); 
		
		return cf; 
	}
	
	// create a fund of NFT
	public LigatureFund createLigatureFund() { 
		LigatureFund lf = new LigatureFund(); 
		
		return lf; 
	}
	
	
	private AlgoFund createFund() throws Exception {
		AlgoFund algoFund = new AlgoFund(); 
    	Account account = new Account(); 
    	Account creator = new Account(); 
    	Account manager = new Account();
    	Account reserve = new Account();  
    	Account freeze = new Account(); 
    	Account clawback = new Account(); 
    	
    	Integer assetDecimals = 3; 
    	boolean defaultFrozen = false;
    	String name = "Rama Coin";
    	BigInteger totalAssetSupply = BigInteger.valueOf(1000000000);
    	String assetUnitName = "Ramas";
    	byte[] metadataHash = new byte[128];
    	String url = "http://www.pawnmystuff.com/";
    	
    	return algoFund; 
    			
	}
}
