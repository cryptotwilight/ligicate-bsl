package com.ligicate.keys;

import com.ligicate.algo.api.IntegrationKeys;

public interface SessionKeys extends IntegrationKeys {

	public static final String USER 				= "USER";
	public static final String ERROR 				= "ERROR";
	public static final String TRANSACTION_ID 		= "TRANSACTION_ID";
	public static final String TRANSACTION_TYPE 	= "TRANSACTION_TYPE";
	
	public enum TRANSACTION_TYPE {CUSTODY_REQUEST,CUSTODY_ACCEPT, LOAN_REQUEST, LOAN_ACCEPT };

	
	
}
