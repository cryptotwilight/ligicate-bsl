package com.ligicate.algo.api;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonString;

import com.algorand.algosdk.algod.client.model.Transaction;
import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.crypto.Address;
import com.algorand.algosdk.util.Encoder;
import com.ligicate.algo.markets.MessagingFees;
import com.ligicate.algo.markets.Registers;
import com.ligicate.algo.markets.RegistrationFees;
import com.ligicate.algo.markets.custody.CustodyAccept;
import com.ligicate.algo.markets.custody.CustodyOffer;
import com.ligicate.algo.markets.custody.CustodyRequest;
import com.ligicate.algo.registration.custodian.CustodianDetails;
import com.ligicate.algo.registration.custodian.CustodianOptInNotification;
import com.pawnmystuff.algo.model.Ligature;

public class CustodianTransactionManager extends RoleTransactionManager {
	
	public static int LIGATURE_COUNT = 1; 

	public static List<CustodyRequest> findCustodyRequests(Map<String, Object> session) throws Exception {
		
		
		return null; 
	}
	
	public static String offerCustody(Map<String, Object> session, CustodyOffer offer) throws Exception  {
		
		return null; 
	}
	
	public static List<CustodyAccept> findAcceptedCustodyOffers (Map<String, Object> session) throws Exception { 
		
		return null; 
	}
	
	
	public static String issueLigature(Map<String, Object> session, Ligature ligature) throws Exception {
	
		
		return null; 
	}
	
	
	
	public static String registerWithMoneyManager(Map<String, Object> session, CustodianDetails details) throws Exception {
		JsonObject jo = Json.createObjectBuilder().add("ligicate",  
										Json.createObjectBuilder().add("request", 
													Json.createObjectBuilder().add("type", "registration")
													.add("register", CustodianDetails.CUSTODIAN)
													.add("location", details.getLocation())
													.add("name", details.getName())
													.add("asset-types", details.getCustodialAssetTypes())
													.add("asset-limit", details.getCustodialAssetLimit()))).build();
		
		String jsonMessage = getString(jo);  
		TransactionID  transactionId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Registers.CUSTODIAN_REGISTRATION_ADDRESS), RegistrationFees.CUSTODIAN_REGISTRATION_FEE, jsonMessage);
		return transactionId.getTxId(); 
	}
	
	public static String findRegistrationResponse(Map<String, Object> session, String custodianName) throws Exception { 
		String [] searchParams = new String[1];
		searchParams[0] = custodianName;
		List<Transaction> transactions = SearchManager.findTransactions(getApi(session), searchParams);
		if(transactions.size() >0) {
			String message = new String( Encoder.decodeFromBase64(new String(transactions.get(0).getNoteb64())));
			return message; 
		}
		return null; 
	}
	
	
	public static String optIn(Map<String, Object> session, CustodianOptInNotification optIn) throws Exception {
		JsonObject jo = Json.createObjectBuilder().add("ligicate",  
				Json.createObjectBuilder().add("notification", 
							Json.createObjectBuilder().add("type", "opt-in")
							.add("custodian-id", optIn.getCustodianId())
							.add("ligature-id", optIn.getLigatureId()))).build(); 
		String jsonMessage = getString(jo);  
		TransactionID transactionId = TransactionManager.acceptAsset(getApi(session), getAccount(session), BigInteger.valueOf(optIn.getLigatureId()), jsonMessage);
		
		JsonString txId = Json.createValue(transactionId.getTxId());	
				
				
		jo.getJsonObject("ligicate").getJsonObject("notification").put("transaction-id", txId); 
		String notification = getString(jo);
		TransactionID notificationId = TransactionManager.transferAlgos(getApi(session), getAccount(session), new Address(Registers.CUSTODIAN_REGISTRATION_ADDRESS), MessagingFees.MESSAGING_FEE, notification); 
		return notificationId.getTxId();
	}
}
