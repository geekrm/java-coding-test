package com.java_coding_test.rest_service.validation;

import java.util.Currency;

import com.java_coding_test.rest_service.model.Trade;

public class CurrenciesValidator<T extends Trade> implements Validator<T> {

	@Override
	public ValidationResult validate(T trade) {
		
		String ccyPair = trade.getCcyPair();
		
		if(ccyPair == null || ccyPair.length() != 6) {
			return new ValidationResult(false, String.format("Invalid Currencies Pair: '%s'. Currencies Pair has to be six characters string value.", ccyPair));
		}
		
		String ccy1 = ccyPair.substring(0, 3);
		String ccy2 = ccyPair.substring(3);
		
		boolean success = true;
		StringBuilder message = new StringBuilder();
		
		try {
			Currency.getInstance(ccy1);
		} catch(IllegalArgumentException e) {
			success = false;
			message.append(String.format("Invalid currency ISO 4217 code: '%s'. ", ccy1));
		}
		try {
			Currency.getInstance(ccy2);
		} catch(IllegalArgumentException e) {
			success = false;
			message.append(String.format("Invalid currency ISO 4217 code: '%s'. ", ccy2));
		}
		
		if(success) {
			return ValidationResult.OK;
		} else {
			return new ValidationResult(false, message.toString());
		}
		
	}

}
