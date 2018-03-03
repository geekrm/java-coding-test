package com.java_coding_test.rest_service.validation;

import com.java_coding_test.rest_service.model.Trade;

public class ValidationRulesProvider {

	private static final ValidationRules spotValidationRules = 
			new ValidationRules()
			.add(new ValueAndTradeDateValidator())
			.add(new ValueDateNonWorkingDaysValidator())
			.add(new CounterpartySupportedValidator())
			.add(new CurrenciesValidator())
			.add(new LegalEntityValidator())
			;
	
	private static final ValidationRules forwardValidationRules = 
			new ValidationRules()
			.add(new ValueAndTradeDateValidator())
			.add(new ValueDateNonWorkingDaysValidator())
			.add(new CounterpartySupportedValidator())
			.add(new CurrenciesValidator())
			.add(new LegalEntityValidator())
			;
	
	private static final ValidationRules optionsValidationRules = 
			new ValidationRules()
			.add(new CounterpartySupportedValidator())
			.add(new OptionsCurrenciesValidator())
			.add(new LegalEntityValidator())
			.add(new StyleValidator())
			.add(new OptionsDatesValidator())
			;	
	
	public static ValidationRules getValidationRules(Trade trade) {
		
		switch(trade.getClass().getSimpleName()) {
		
			case "Spot": return spotValidationRules;
			case "Forward": return forwardValidationRules;
			case "Options": return optionsValidationRules;
			default: return null; 
		
		}
		
	}
	
}
