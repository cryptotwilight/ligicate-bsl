package com.ligicate.algo.api;

import java.math.BigInteger;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.ApiException;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.crypto.Address;
import com.algorand.algosdk.crypto.Digest;
import com.algorand.algosdk.transaction.SignedTransaction;
import com.algorand.algosdk.transaction.Transaction;
import com.algorand.algosdk.util.Encoder;
import com.ligicate.algo.markets.MessagingFees;
import com.ligicate.moneymanager.MoneyManagerAddresses;

public class TransactionManager {
	
	public static TransactionID acceptAsset(AlgodApi api, Account account, BigInteger assetId) throws Exception  {
		return acceptAsset(api, account, assetId, null);
	}
		
	public static TransactionID acceptAsset(AlgodApi api, Account account, BigInteger assetId, String message) throws Exception  {
		BigInteger firstRound = getFirstRound(api);
		Address address = account.getAddress(); 
		Transaction transaction = Transaction.createAssetAcceptTransaction(address, 
															BigInteger.valueOf(1000L), 
															firstRound, 
															getLastRound(firstRound), 
															(message != null?message.getBytes():null), 
															getGenesisId(api), 
															getGenesisHash(api), 
															assetId); 
		return commitTransaction(api, account, transaction);
	
	}
	
	public static TransactionID commitTransaction(AlgodApi api, Account account, Transaction transaction) throws Exception {
		Account.setFeeByFeePerByte(transaction, getFee(api));
		System.out.println(" account " + account.getAddress());
		SignedTransaction st = account.signTransaction(transaction);
		return sendTransaction(api, st);
	}
	
	public static TransactionID transferAsset(AlgodApi api, Account fromAccount, Account toAccount, BigInteger assetId, BigInteger assetAmount, String message) throws Exception  {
		Address reciever = toAccount.getAddress(); 
		return transferAsset(api, fromAccount, reciever, assetId, assetAmount, message);
	}
	
	public static TransactionID transferAsset(AlgodApi api, Account fromAccount, Address reciever, int assetId, long assetAmount, String message ) throws Exception {
		return transferAsset(api, fromAccount, reciever, BigInteger.valueOf(assetId), BigInteger.valueOf(assetAmount), message);
	}
	
	public static TransactionID transferAsset(AlgodApi api, Account fromAccount, Address reciever, BigInteger assetId, BigInteger assetAmount, String message ) throws Exception {
		Address sender = fromAccount.getAddress(); 
		Address closeTo = new Address();
		BigInteger firstRound = getFirstRound(api);
		Transaction transaction = Transaction.createAssetTransferTransaction(sender, reciever, closeTo, assetAmount, getFee(api), firstRound , getLastRound(firstRound), message.getBytes(), getGenesisId(api), getGenesisHash(api), assetId);
		return commitTransaction(api, fromAccount, transaction);
	}
	
	public static TransactionID transferAlgos(AlgodApi api, Account fromAccount, Account toAccount, BigInteger amount, String message) throws Exception {
		Address reciever = toAccount.getAddress(); 
		return transferAlgos(api, fromAccount, reciever, amount, message);
	}
	
	public static TransactionID transferAlgos(AlgodApi api, Account fromAccount, Address reciever, BigInteger amount, String message) throws Exception {
		Address sender = fromAccount.getAddress();
		BigInteger firstRound = getFirstRound(api);
		Transaction transaction = new Transaction(sender, getFee(api), firstRound, getLastRound(firstRound), message.getBytes(), amount, reciever, getGenesisId(api), getGenesisHash(api));
		return commitTransaction(api, fromAccount, transaction);
	}
	
	
	private static BigInteger getFee(AlgodApi api) throws Exception {
		return api.transactionParams().getFee();
	}
	
	public static TransactionID sendUnsignedTransaction(AlgodApi api, Transaction transaction) throws Exception {
		  byte[] encodedTxBytes = Encoder.encodeToMsgPack(transaction);
	  	  return api.rawTransaction(encodedTxBytes);
	}

	public static TransactionID createAsset(AlgodApi api, Account account, String assetName, String assetUnitName, long assetTotal, String message) throws Exception {
	
		  	Address sender = new Address(MoneyManagerAddresses.SENDER.getBytes());
	    	//Address creator = new Address(MoneyManagerAddresses.CREATOR.getBytes());
	    	Address manager = new Address(MoneyManagerAddresses.MANAGER.getBytes());
	    	Address reserve = new Address(MoneyManagerAddresses.RESERVE.getBytes()); 
	    	Address freeze = new Address(MoneyManagerAddresses.FREEZE.getBytes());
	    	Address clawback = new Address(MoneyManagerAddresses.CLAWBACK.getBytes()); 
	    	
	      	Integer assetDecimals = 3; 
	    	boolean defaultFrozen = false;
	    	BigInteger total = BigInteger.valueOf(assetTotal);
	    	
	    	//byte[] metadataHash = Encoder.encodeToBase64(new byte[32]).getBytes();
	    	
	    	byte[] metadataHash = null; 
	    	
	    	String url = "http://www.ligicate.com/";
	    	byte[] note = message.getBytes();
	    	BigInteger firstRound = getFirstRound(api);
	    	Transaction transaction = Transaction.createAssetCreateTransaction(sender, getFee(api), firstRound, getLastRound(firstRound), note, getGenesisId(api), getGenesisHash(api), total, assetDecimals, defaultFrozen, assetUnitName, assetName, url, metadataHash, manager, reserve, freeze, clawback);
	    	return commitTransaction(api,  account, transaction);
	}
	// sends a message across the blockchain, by sending a small amount of algos with the message
	public static TransactionID sendMessage(AlgodApi api, Account fromAccount, Address reciever,  String message)throws Exception { 
		return transferAlgos(api, fromAccount, reciever, MessagingFees.MESSAGING_FEE, message);
	}
	
	public static TransactionID sendTransaction(AlgodApi api, SignedTransaction signedTransaction) throws Exception {
  	  byte[] encodedTxBytes = Encoder.encodeToMsgPack(signedTransaction);
  	  return api.rawTransaction(encodedTxBytes);
	}
	
	private static String getGenesisId(AlgodApi api) throws Exception {
		return api.transactionParams().getGenesisID(); 
	}
	
	private static Digest getGenesisHash(AlgodApi api) throws Exception { 
		return new Digest(api.transactionParams().getGenesishashb64());
	}
	
	private static  BigInteger getLastRound(BigInteger firstRound) {
		return firstRound.add(BigInteger.valueOf(1000L));
	}

	public static BigInteger getFirstRound(AlgodApi api) throws ApiException {
		return api.getStatus().getLastRound();
	}
	
	
}
