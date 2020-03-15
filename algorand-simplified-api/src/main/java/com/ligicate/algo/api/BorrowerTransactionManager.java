package com.ligicate.algo.api;

import java.math.BigInteger;
import java.util.Map;

import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.crypto.Address;
import com.ligicate.algo.markets.MarketFees;
import com.ligicate.algo.markets.Markets;
import com.ligicate.algo.markets.custody.CustodyAccept;
import com.ligicate.algo.markets.custody.CustodyRequest;
import com.ligicate.algo.markets.loan.BorrowerSwapRequest;
import com.ligicate.algo.markets.loan.LoanAccept;
import com.ligicate.algo.markets.loan.LoanRequest;
import com.ligicate.algo.registration.borrower.BorrowerDetails;

public class BorrowerTransactionManager extends RoleTransactionManager {

	public static final String registerBorrower(Map<String, Object> session, BorrowerDetails details) throws Exception { 
		String jsonMessage = "{\"ligicate\": {request: {"
				+ "{\"type\": \"registration\"}, "
				+ "{\"register\":\""+BorrowerDetails.BORROWER+"\"}, "
				+ "{\"location\":\""+details.getLocation()+"\"},"
				+ "{\"identyHash\": "+details.getIdentityHash()+"\"}"
				+ 	"}"
				+ "}";  
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Markets.CUSTODIAL_MARKET_ADDRESS.getBytes()), MarketFees.CUSTODIAL_MARKET_FEE, jsonMessage);
		return transactionId.getTxId(); 
	}
	
	public static final String requestCustodian(Map<String, Object> session, CustodyRequest request) throws Exception {
		
		String jsonMessage = "{\"ligicate\": {request: {"
				+ "{\"type\": \"custody\"}, "
				+ "{\"assetDescription\":\""+request.getAssetDescription()+"\"}, "
				+ "{\"custodyLocationRestriction\":\""+request.getCustodyLocationRestriction()+"\"},"
				+ "{\"custodyTerm\": "+request.getCustodyTerm()+"\"},"
				+ "{\"custodyTermUnits\": "+request.getCustodyTermUnits()+"\"},"
				+ "{\"ownerLocation\": "+request.getOwnerLocation()+"\"}"
				+ 	"}"
				+ "}";
		
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Markets.CUSTODIAL_MARKET_ADDRESS.getBytes()), MarketFees.CUSTODIAL_MARKET_FEE, jsonMessage);
		return transactionId.getTxId(); 
	}
	
	public static final String requestLoan(Map<String, Object> session, LoanRequest request) throws Exception {
		String jsonMessage = "{\"ligicate\": {request: {"
				+ "{\"type\": \"loan\"}, "
				+ "{\"assetId\":\""+request.getAssetId()+"\"}, "
				+ "{\"assetDescription\":\""+request.getAssetDescription()+"\"}, "
				+ "{\"loanAmount\":\""+request.getLoanAmount()+"\"},"
				+ "{\"loanTerm\": "+request.getLoanTerm()+"\"},"
				+ "{\"loanTermUnits\": "+request.getLoanTermUnits()+"\"}"
				+ 	"}"
				+ "}";
		
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Markets.LOAN_MARKET_ADDRESS.getBytes()), MarketFees.LOAN_MARKET_FEE, jsonMessage);
		return transactionId.getTxId(); 
	}
	
	public static String acceptLoan(Map<String, Object> session, LoanAccept acceptance) throws Exception {
		String jsonMessage = "{\"ligicate\": {accept: {"
				+ "{\"type\": \"loan\"}, "
				+ "{\"assetId\":\""+acceptance.getAssetId()+"\"}, "
				+ "{\"ligatureId\":\""+acceptance.getLigatureId()+"\"},"
				+ "{\"swapAddress\": "+acceptance.getSwapAddress()+"\"}"
				+ 	"}"
				+ "}";
		
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Markets.LOAN_MARKET_ADDRESS.getBytes()), MarketFees.LOAN_MARKET_FEE, jsonMessage);
		return transactionId.getTxId(); 
	}
	
	public static String acceptCustody(Map<String, Object> session, CustodyAccept acceptance) throws Exception {
		String jsonMessage = "{\"ligicate\": {accept: {"
				+ "{\"type\": \"custody\"}, "
				+ "{\"assetId\":\""+acceptance.getAssetId()+"\"}, "
				+ "{\"assetDescription\":\""+acceptance.getAssetDescription()+"\"}, "
				+ "{\"custodyFee\":\""+acceptance.getCustodyFee()+"\"},"
				+ "{\"encryptedAssetReturnDetails\": "+acceptance.getEncryptedAssetReturnDetails()+"\"},"
				+ "{\"encryptedTermStartTrigger\": "+acceptance.getEncryptedTermStartTrigger()+"\"}"
				+ 	"}"
				+ "}";
		
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(acceptance.getCustodianBlockchainAddress().getBytes()), BigInteger.valueOf(Long.valueOf(acceptance.getCustodyFee()+"")), jsonMessage);
		return transactionId.getTxId(); 
	}
	
	public static String swap(Map<String, Object> session, BorrowerSwapRequest request) throws Exception {
		String jsonMessage = "{\"ligicate\": {swap: {"
				+ "{\"type\": \"borrow\"}, "
				+ "{\"assetId\":\""+request.getAssetId()+"\"}, "
				+ "{\"ligatureCount\":\""+request.getLigatureCount()+"\"},"
				+ "{\"assetDescription\": "+request.getAssetDescription()+"\"},"
				+ "{\"custodian\": "+request.getCustodian()+"\"}"
				+ 	"}"
				+ "}";
		
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Markets.LOAN_MARKET_ADDRESS.getBytes()), MarketFees.LOAN_MARKET_FEE, jsonMessage);
		return transactionId.getTxId(); 
	}
	

}
