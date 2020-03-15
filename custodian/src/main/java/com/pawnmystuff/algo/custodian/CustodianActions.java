package com.pawnmystuff.algo.custodian;

import com.pawnmystuff.algo.model.Asset;
import com.pawnmystuff.algo.model.Ligature;

public class CustodianActions {

	public Ligature recieveAsset(Asset custodialAsset, Account borrower) {
		// returns the ligature associated witht he asset 
		
		return null; 
	}
	// this is done while the asset is in transit 
	public String registerLigature(Ligature ligature, Account borrower) {
		// registers the money manager issued ligature 
		// returns a stature 
		return null; 
	}
	
	// issue the Ligature to the borrower's account 
	public String issueLigature(Account borrower, Ligature ligature) {
		// returns a status 
		// issues the associated ligature to the given borrower account
		
		return null; 
	}
	
}
