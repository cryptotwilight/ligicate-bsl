package com.ligicate.algo.api;

import java.math.BigInteger;

import com.algorand.algosdk.algod.client.AlgodClient;
import com.algorand.algosdk.algod.client.ApiException;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.auth.ApiKeyAuth;
import com.algorand.algosdk.algod.client.model.Block;

public class BlockchainListener {

	private static final String ALGOD_API_TOKEN = null;
	private static final String ALGOD_API_ADDR = null;

	public static void main(String args[]) { 
        AlgodClient client = (AlgodClient) new AlgodClient().setBasePath(ALGOD_API_ADDR);
        ApiKeyAuth api_key = (ApiKeyAuth) client.getAuthentication("api_key");
        api_key.setApiKey(ALGOD_API_TOKEN);
        AlgodApi api = new AlgodApi(client);
        try {
			Block block = api.getBlock(BigInteger.valueOf(12313));
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
