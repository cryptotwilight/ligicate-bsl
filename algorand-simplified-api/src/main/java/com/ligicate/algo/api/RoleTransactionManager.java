package com.ligicate.algo.api;

import java.io.StringWriter;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import com.algorand.algosdk.account.Account;
import com.algorand.algosdk.algod.client.api.AlgodApi;

public class RoleTransactionManager {
	protected static AlgodApi getApi(Map<String, Object> session) {
		return (AlgodApi)session.get(IntegrationKeys.ALGORAND_API);
	}
	
	protected static Account getAccount(Map<String, Object> session) {
		return (Account) session.get(IntegrationKeys.ALGORAND_USER_ACCOUNT);
	}
	
	protected static String getString(JsonObject jo) throws Exception { 
		StringWriter writer = new StringWriter(); 
		JsonWriter jw = Json.createWriter(writer);
		jw.write(jo);
		return writer.toString(); 
	}
}
