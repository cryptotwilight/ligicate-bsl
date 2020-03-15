package com.ligicate.dashboard.model;

import java.util.List;

import com.ligicate.algo.markets.custody.CustodyOffer;
import com.ligicate.algo.markets.loan.LoanOffer;
import com.pawnmystuff.algo.model.Ligature;
import com.pawnmystuff.algo.model.Loan;

public class Dashboard {
	
	private List<Loan> loans; 
	private List<com.ligicate.algo.markets.loan.LoanOffer> loanOffers; 
	private List<CustodyOffer> custodyOffers; 
	private List<Ligature> ligatures;
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public List<LoanOffer> getLoanOffers() {
		return loanOffers;
	}
	public void setLoanOffers(List<LoanOffer> loanOffers) {
		this.loanOffers = loanOffers;
	}
	public List<CustodyOffer> getCustodyOffers() {
		return custodyOffers;
	}
	public void setCustodyOffers(List<CustodyOffer> custodyOffers) {
		this.custodyOffers = custodyOffers;
	}
	public List<Ligature> getLigatures() {
		return ligatures;
	}
	public void setLigatures(List<Ligature> ligatures) {
		this.ligatures = ligatures;
	} 
}
