package com.java_coding_test.rest_service.validation;

import java.util.Currency;

import com.java_coding_test.rest_service.model.Options;

public class OptionsCurrenciesValidator extends CurrenciesValidator<Options> {

	@Override
	public ValidationResult validate(Options trade) {
		ValidationResult result = super.validate(trade);
		
		String payCcy = trade.getPayCcy();
		String premiumCcy = trade.getPremiumCcy();
		String premiumType = trade.getPremiumType() != null ? 
				trade.getPremiumType().replaceAll("%", "") : "";
		
		boolean success = result.isSuccess();
		StringBuilder message = new StringBuilder(
				result.getMessage() == null ? "" : result.getMessage());
		
		try {
			Currency.getInstance(payCcy);
		} catch(Exception e) {
			success = false;
			message.append(String.format("Invalid payCcy currency ISO 4217 code: '%s'. ", payCcy));
		}
		
		try {
			Currency.getInstance(premiumCcy);
		} catch(Exception e) {
			success = false;
			message.append(String.format("Invalid premiumCcy currency ISO 4217 code: '%s'. ", premiumCcy));
		}
		
		try {
			Currency.getInstance(premiumType);
		} catch(Exception e) {
			success = false;
			message.append(String.format("Invalid premiumType currency ISO 4217 code: '%s'. ", trade.getPremiumType()));
		}
		
		result.setSuccess(success);
		result.setMessage(message.toString());
		
		return result;
	}

}
