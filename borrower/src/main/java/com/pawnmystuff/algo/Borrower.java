package com.pawnmystuff.algo;

import java.math.BigInteger;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.AlgodClient;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.model.TransactionID;
import com.algorand.algosdk.transaction.Transaction;
import com.ligicate.algo.api.TransactionManager;
public class Borrower {

	public static void main(String[] args) {
        final String ALGOD_API_ADDR = "https://testnet-algorand.api.purestake.io/ps1";

        AlgodClient client = new AlgodClient();
        client.setBasePath(ALGOD_API_ADDR);
        client.addDefaultHeader("X-API-Key", "{api-key}");
		// send asset to custodian 
		// pay custodial fee 
		// recieve securitized ligature
        AlgodApi api = new AlgodApi(client);
       
		// 
		try { 
			Account borrower = new Account("borrower-pms".getBytes());
			System.out.println("borrower: " + borrower.getAddress().toString());
			BigInteger assetId = BigInteger.valueOf(208511);
			testAccept(api, borrower, assetId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	private static void testAccept(AlgodApi api, Account account, BigInteger assetId) throws Exception {
		
		TransactionID id = TransactionManager.acceptAsset(api, account, assetId);
		System.out.println(" Transaction Id: " + id.getTxId());
	}
	
}
