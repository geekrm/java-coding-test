package com.java_coding_test.rest_service.validation;

import com.java_coding_test.rest_service.model.Trade;

public class LegalEntityValidator implements Validator<Trade> {

	private static final String LEGAL_ENTITY = "CS Zurich";
	
	@Override
	public ValidationResult validate(Trade trade) {
		
		if(LEGAL_ENTITY.equals(trade.getLegalEntity())) {
			return ValidationResult.OK;
		} else {
			return new ValidationResult(false, String.format("Invalid legal entity: '%s'. Valid legal entity: '%s'", trade.getLegalEntity(), LEGAL_ENTITY));
		}
		
	}

}
