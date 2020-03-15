package com.ligicate.algo.api;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.algorand.algosdk.algod.client.ApiException;
import com.algorand.algosdk.algod.client.api.AlgodApi;
import com.algorand.algosdk.algod.client.model.Block;
import com.algorand.algosdk.algod.client.model.Transaction;
import com.algorand.algosdk.util.Encoder;


public class SearchManager {

	public static final int BLOCK_SEARCH_WINDOW = 10000; 
	
	public static List<Transaction> findTransactions(AlgodApi api, String searchParams[]) throws Exception {
		List<Transaction> transactions = new ArrayList<Transaction>();
		String [] txids = {"TTUDIC52UWTTQQO7QHB2FSZQMJGGE63CVLHPAYJRKBRWCNWQK5GQ","FRXYAXB36GE23SG4JDJXSA4RXLZB7USDSLH4BANFBKFSDU7N4QVQ","5BC7DSF7OA7POOYRLFQR6DD6QJKG4SUCSSXUDOI6SEHD3GCG6OCA","OMFIFDTKR5WIA3NUNR2UBQMW75UJNX7ZBMS5JN4SWE3MYVBYM6DA","SM3J6SSZVS2Y5X3T2CW6ZCO4EPFH25M6ET2QTPNZJTCZMKQ7D3ZA"};
		for(int x = 0; x < txids.length; x++) {
			Transaction tx = api.transaction(txids[x]);
			transactions.add(tx);
		}
		/*
		
		BigInteger earliestBlock = getEarliestBlock(api);
		long start = earliestBlock.longValue(); 
		long end = getFirstRound(api).longValue(); 
		int paramCount = searchParams.length; 
		for(long x = end ; x > start ; x-- ) {
			Block block = api.getBlock(BigInteger.valueOf(x));
			System.out.println("block start: " + x + " block end " + x);
			List<Transaction> txns = block.getTxns().getTransactions();
			System.out.println("transaction count: " + txns.size());
			for(Transaction tx : txns) {
				byte [] bytes = tx.getNoteb64();
				if(bytes != null) {
					System.out.println("bytes:" + bytes.toString()); 
					String str = new String(tx.getNoteb64());
					System.out.println("String: " + str);
					String text = new String (Encoder.decodeFromBase64(str));
					System.out.println("text");
					int found = 0;
					for(String searchParam : searchParams) {
						if(text.contains(searchParam)) {
							found++;
						}
					}
					if(found == paramCount) {
						transactions.add(tx);
					}
				}
			}
		}
		*/
		return transactions; 
	}
	
	public static BigInteger getFirstRound(AlgodApi api) throws ApiException {
		return api.getStatus().getLastRound();
	}
	
	private static BigInteger getEarliestBlock(AlgodApi api) throws Exception { 
		BigInteger latestRound = getFirstRound(api);
		long lr = latestRound.longValue(); 
		long eb = lr - BLOCK_SEARCH_WINDOW; 
		return BigInteger.valueOf(eb);
	}
}
