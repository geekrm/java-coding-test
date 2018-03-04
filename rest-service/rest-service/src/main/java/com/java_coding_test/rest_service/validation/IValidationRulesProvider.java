package com.java_coding_test.rest_service.validation;

import com.java_coding_test.rest_service.model.Trade;

public interface IValidationRulesProvider {

	public ValidationRules getValidationRules(Trade trade);
	
}
