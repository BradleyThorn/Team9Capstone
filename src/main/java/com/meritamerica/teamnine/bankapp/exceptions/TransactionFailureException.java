package com.meritamerica.teamnine.bankapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionFailureException extends Exception{
	public TransactionFailureException () {
	super("TRANSACTION FAILED");
	}
}
