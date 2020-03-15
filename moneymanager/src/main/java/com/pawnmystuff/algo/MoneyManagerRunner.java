package com.pawnmystuff.algo;


import java.math.BigInteger;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.AlgodClient;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.algod.client.model.TransactionParams;
import com.algorand.algosdk.crypto.Address;
import com.algorand.algosdk.crypto.Digest;
import com.algorand.algosdk.transaction.SignedTransaction;
import com.algorand.algosdk.transaction.Transaction;
import com.algorand.algosdk.util.Encoder;
import com.ligicate.algo.api.TransactionManager;

public class MoneyManagerRunner {

	private static BigInteger RAMAID = BigInteger.valueOf(208511);
	private static BigInteger ONE_LIGATURE = BigInteger.valueOf(1000000);
	
	public static void main(String args[]) {
        final String ALGOD_API_ADDR = "https://testnet-algorand.api.purestake.io/ps1";

        AlgodClient client = new AlgodClient();
        client.setBasePath(ALGOD_API_ADDR);
        client.addDefaultHeader("X-API-Key", "{api-key}");
        
        try {
        	AlgodApi api = new AlgodApi(client);
        	//createCoin(api);
//        	Account fromAccount = new Account("QXXTCKFDTRGY2JR42F52NBIP3AKM6FBMPZKW3CDENXPZ5KQEZDBFGYWWH4".getBytes());
//        	Account toAccount = new Account("borrower-pms".getBytes());
//        	transferCoin(fromAccount, toAccount, api, ONE_LIGATURE, "hi");
//        	
        	//transferAlgos(fromAccount, toAccount, api, BigInteger.valueOf(10000), "{transfer : 1}");
        	
        	// create monetary tokens 
        	// create ligatures
	
        	generateKeyAddresses(); 
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static TransactionID transferAlgos(Account fromAccount, Account toAccount, AlgodApi api, BigInteger amount, String message) throws Exception { 
		return TransactionManager.transferAlgos(api, fromAccount, toAccount, amount, message);
	}
	
	private static TransactionID transferCoin(Account fromAccount, Account toAccount, AlgodApi api, int ammount, String message) throws Exception { 
		return TransactionManager.transferAsset(api, fromAccount, toAccount, RAMAID, BigInteger.valueOf(ammount), message);
	}
	
	private static TransactionID transferCoin(Account fromAccount, Account toAccount, AlgodApi api, BigInteger amount, String message) throws Exception {
		return TransactionManager.transferAsset(api, fromAccount, toAccount, RAMAID, amount, message);
	}
	
	private TransactionID createCoin(AlgodApi api) throws Exception{
		Account sndr = new Account("QXXTCKFDTRGY2JR42F52NBIP3AKM6FBMPZKW3CDENXPZ5KQEZDBFGYWWH4".getBytes());
    	Account crtr = new Account("creator-pms".getBytes());
    	Account mngr = new Account("manager-pms".getBytes());
    	Account rsv = new Account("reserve-pms".getBytes());
    	Account frz = new Account("freeze-pms".getBytes()); 
    	Account clbk = new Account("clawback.pms".getBytes());
    	
    	Address sender = sndr.getAddress();
    	Address creator = crtr.getAddress(); 
    	Address manager = mngr.getAddress();
    	Address reserve = rsv.getAddress();  
    	Address freeze = frz.getAddress(); 
    	Address clawback = clbk.getAddress(); 
    	
      	Integer assetDecimals = 3; 
    	boolean defaultFrozen = false;
    	String assetName = "Rama Coin";
    	BigInteger assetTotal = BigInteger.valueOf(1000000000);
    	String assetUnitName = "Ramas";
    	
    	//byte[] metadataHash = Encoder.encodeToBase64(new byte[32]).getBytes();
    	
    	byte[] metadataHash = null; 
    	
    	String url = "http://www.pawnmystuff.com/";
    	
    	BigInteger fee = api.suggestedFee().getFee();
    	byte[] note = "this is a Rama test".getBytes();
    	
    	BigInteger firstValid = api.getStatus().getLastRound();
    	BigInteger lastValid = firstValid.add(BigInteger.valueOf(1000L));
    	TransactionParams params = api.transactionParams();
        Digest genesisHash = new Digest(params.getGenesishashb64());
        String genesisID = params.getGenesisID();

    	Transaction transaction = Transaction.createAssetCreateTransaction(sender, fee, firstValid, lastValid, note, genesisID, genesisHash, assetTotal, assetDecimals, defaultFrozen, assetUnitName, assetName, url, metadataHash, manager, reserve, freeze, clawback);
    	Account.setFeeByFeePerByte(transaction, fee);

    	SignedTransaction signedTransation = sndr.signTransaction(transaction);
    	  byte[] encodedTxBytes = Encoder.encodeToMsgPack(signedTransation);
          TransactionID id = api.rawTransaction(encodedTxBytes);
    	
    	
    	
    	
    	
    	note("transaction id: " +id );
    	note(transaction+ " " + sender.toString());
    	note(transaction.toString());
    	return id; 
	}
	// generate the fixed addresses for the system
	private static void generateKeyAddresses() throws Exception { 
		String custodialMarket = "custodial-market";
		String loanMarket = "loan-market";
		String moneyManager = "money-manager";
		note(custodialMarket +" : "+ getAccount(custodialMarket).getAddress());
		note(loanMarket +" : "+ getAccount(loanMarket).getAddress());
		note(moneyManager +" : "+ getAccount(moneyManager).getAddress());
	}
	
	private static Account getAccount(String seed) throws Exception {
		return new Account(seed.getBytes());
	}
	
	private static void note(String msg) {
		System.out.println("Ligicate :- " + msg);
	}
}

