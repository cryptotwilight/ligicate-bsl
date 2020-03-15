package com.ligicate.borrower.action;

import com.ligicate.algo.markets.custody.CustodyAccept;
import com.ligicate.keys.BorrowerNavigationKeys;

public class AcceptCustodyOfferAction {

	private CustodyAccept custodyAccept; 
	
	public String execute() { 
		String result  = BorrowerNavigationKeys.CUSTODY_ACCEPTED; 
		// send acceptance to the blockchain
		return result; 
	}

	public CustodyAccept getCustodyAccept() {
		return custodyAccept;
	}

	public void setCustodyAccept(CustodyAccept custodyAccept) {
		this.custodyAccept = custodyAccept;
	}
	
	
}
