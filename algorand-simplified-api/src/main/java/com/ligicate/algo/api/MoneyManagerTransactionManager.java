package com.ligicate.algo.api;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import com.algorand.algosdk.algod.client.model.Transaction;
import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.algod.client.model.TransactionResults;
import com.algorand.algosdk.crypto.Address;
import com.algorand.algosdk.util.Encoder;
import com.ligicate.algo.registration.custodian.CustodianDetails;
import com.ligicate.algo.registration.custodian.CustodianOptInNotification;
import com.ligicate.algo.registration.custodian.CustodianRegistrationAcceptance;
import com.ligicate.algo.registration.custodian.CustodianRegistrationRequest;
import com.ligicate.moneymanager.Ligature;

public class MoneyManagerTransactionManager extends RoleTransactionManager{

	public static List<CustodianRegistrationRequest> findNewCustodianRegistrationRequests(Map<String, Object> session) throws Exception  { 
		// find registration requests 
		String [] searchParams = {"ligicate", "request", "registration", CustodianDetails.CUSTODIAN};
		System.out.println(" api " + getApi(session));
		List<Transaction> transactions = SearchManager.findTransactions(getApi(session), searchParams);
		return getCustodianRegistrationRequests(transactions);
	}
	
	public static final Ligature createLigature(Map<String, Object> session, CustodianRegistrationRequest request, String issuanceNotes ) throws Exception {
		
		String assetName = request.getName()+ "-Coin";
		String assetUnitName = assetName + "-Ligatures";
		long assetTotal = request.getCustodialAssetLimit(); 
		String custodianId =  new Date().getTime()+"";
		JsonObject jo = Json.createObjectBuilder().add("ligicate", 
															Json.createObjectBuilder().add("action", "create-asset")
																					  .add("asset-name", assetName)
																					  .add("asset-unit-Name", assetUnitName)
																					  .add("originator-address", request.getCustodianAddress())
																				  .add("originator-id", custodianId)).build();
		
		
		String message = getString(jo);		
		TransactionID transactionId = TransactionManager.createAsset(getApi(session), getAccount(session), assetName, assetUnitName, assetTotal, message);
		Transaction transaction = getApi(session).transaction(transactionId.getTxId());
		TransactionResults results = transaction.getTxresults();
		int ligatureId = results.getCreatedasset().intValue();
		
		Ligature ligature = new Ligature(); 
		ligature.setCustodianAddress(request.getCustodianAddress());
		ligature.setCustodianId(custodianId);
		ligature.setLigatureTotal(assetTotal);
		ligature.setLigatureId(ligatureId);
		ligature.setLigatureIssuanceNotes(issuanceNotes);
		return ligature; 
	}
	

	
	public static String issueRegistrationDecline(Map<String, Object> session, CustodianRegistrationRequest request) throws Exception {
	
		return null; 
	}
	
	
	public static String issueRegistrationAcceptance(Map<String, Object> session, CustodianRegistrationAcceptance cra) throws Exception { 
		
		// issue the ligature opt in
		JsonObject jo = Json.createObjectBuilder().add("ligicate",  
															Json.createObjectBuilder().add("accept", 
																	Json.createObjectBuilder().add("type", "registration")
																	.add("register", CustodianDetails.CUSTODIAN)
																	.add("name", cra.getName())
																	.add("location", cra.getLocation())
																	.add("ligature-id", cra.getLigatureId())
																	.add("ligature-name", cra.getLigatureName())
																	.add("ligature-unit-name", cra.getLigatureUnitName())
																	.add("asset-limit", cra.getCustodialAssetLimit())
																	.add("asset-types", cra.getCustodialAssetTypes())
																	.add("custodian-id",cra.getCustodianId())
																	.add("custodian-blockchain-address", cra.getCustodianAddress()))).build(); 
		String message = getString(jo);
		TransactionID id = TransactionManager.sendMessage(getApi(session), getAccount(session), new Address(cra.getCustodianAddress()), message);
		return id.getTxId();
	}
	
	public static List<CustodianOptInNotification> findNewCustodianOptInNotifications(Map<String, Object> session) throws Exception {
		String [] searchParams = {"notification", "optIn", CustodianDetails.CUSTODIAN};
		List<Transaction> transactions = SearchManager.findTransactions(getApi(session), searchParams);
		return getCustodianOptInNotifications(transactions); 
	}

	public static final String issueLigature(Map<String, Object> session, Ligature ligature) throws Exception { 
		JsonObject jo = Json.createObjectBuilder().add("ligicate",  
				Json.createObjectBuilder().add("ligature-transfer", 
						Json.createObjectBuilder().add("type", "initial")
						.add("custodian-blockchain-address", ligature.getCustodianAddress())
						.add("custodian-id", ligature.getCustodianId())
						.add("ligature-id", ligature.getLigatureId())
						.add("ligature-total", ligature.getLigatureTotal())
						.add("issuance-notes", ligature.getLigatureIssuanceNotes()))).build();
		String message = getString(jo);
		TransactionID id = TransactionManager.transferAsset(getApi(session), getAccount(session), new Address(ligature.getCustodianAddress()), ligature.getLigatureId(), ligature.getLigatureTotal(), message);
		return id.getTxId(); 
	}
	
	private static List<CustodianOptInNotification> getCustodianOptInNotifications(List<Transaction> transactions) throws Exception { 
		List<CustodianOptInNotification> notifications = new ArrayList<CustodianOptInNotification>();
	/*	for(Transaction transaction : transactions) {
			String message = new String(Encoder.decodeFromBase64(new String(transaction.getNoteb64())));
			StringReader sr = new StringReader(message);
			JsonReader jr = Json.createReader(sr);
			JsonObject ligicate = jr.readObject();
			JsonObject notification = ligicate.getJsonObject("notification");
			int custodianId = notification.getInt("custodianId");
			int ligicateId = notification.getInt("ligicateId");
			
			CustodianOptInNotification coin = new CustodianOptInNotification(); 
			coin.setCustodianId(custodianId);
			coin.setLigatureId(ligicateId);
			notifications.add(coin);
		}
		*/
		return notifications; 
	}
	private static void note(String msg) {
		System.out.println(" MM: " + msg);
	}
	
	private static List<CustodianRegistrationRequest> getCustodianRegistrationRequests(List<Transaction> transactions) {
		List<CustodianRegistrationRequest> requests = new ArrayList<CustodianRegistrationRequest>();
		for(Transaction transaction : transactions) {
			byte [] byte64 = transaction.getNoteb64();
			String str = new String(byte64);
			note("str: " + str);
			StringReader sr = new StringReader(str);
			JsonReader jr = Json.createReader(sr);
			JsonObject jo = jr.readObject();
			JsonObject ligicate = jo.getJsonObject("ligicate");
			JsonObject request = ligicate.getJsonObject("request");
			String name = request.getString(CustodianDetails.NAME);
			String location = request.getString(CustodianDetails.LOCATION);
			String assetTypes = request.getString(CustodianDetails.ASSET_TYPES);
			int assetLimit = request.getInt(CustodianDetails.ASSET_LIMIT);
			
			CustodianRegistrationRequest req = new CustodianRegistrationRequest(); 
			req.setName(name);
			req.setLocation(location);
			req.setCustodialAssetTypes(assetTypes);
			req.setCustodialAssetLimit(assetLimit);
			req.setCustodianAddress(transaction.getFrom());
			requests.add(req);
		}
		return requests;
	}
}
