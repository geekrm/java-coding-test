package com.java_coding_test.rest_service.validation;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

import com.java_coding_test.rest_service.model.Trade;

public class ValidationRulesProvider implements IValidationRulesProvider {

	private final ValidationRules spotValidationRules = 
			new ValidationRules()
			.add(new ValueAndTradeDateValidator())
			.add(new ValueDateNonWorkingDaysValidator(getHolidays()))
			.add(new CounterpartySupportedValidator())
			.add(new CurrenciesValidator<Trade>())
			.add(new LegalEntityValidator())
			;

	private final ValidationRules forwardValidationRules = 
			new ValidationRules()
			.add(new ValueAndTradeDateValidator())
			.add(new ValueDateNonWorkingDaysValidator(getHolidays()))
			.add(new CounterpartySupportedValidator())
			.add(new CurrenciesValidator<Trade>())
			.add(new LegalEntityValidator())
			;

	private final ValidationRules optionsValidationRules = 
			new ValidationRules()
			.add(new CounterpartySupportedValidator())
			.add(new OptionsCurrenciesValidator())
			.add(new LegalEntityValidator())
			.add(new StyleValidator())
			.add(new OptionsDatesValidator())
			;	
	
	private Set<LocalDate> holidays = null;

	@Override
	public ValidationRules getValidationRules(Trade trade) {

		switch(trade.getClass().getSimpleName()) {

		case "Spot": return spotValidationRules;
		case "Forward": return forwardValidationRules;
		case "Options": return optionsValidationRules;
		default: return null; 

		}
	}
	
	private Set<LocalDate> getHolidays(){
		if(holidays == null)
			initializeHolidays();
		
		return holidays;
	}
	
	private void initializeHolidays() {
		holidays = new HashSet<LocalDate>();
		holidays.add(new LocalDate(2016, 1, 1));
		holidays.add(new LocalDate(2016, 1, 6));
		holidays.add(new LocalDate(2016, 3, 27));
		holidays.add(new LocalDate(2016, 3, 28));
		holidays.add(new LocalDate(2016, 5, 1));
		holidays.add(new LocalDate(2016, 5, 3));
		holidays.add(new LocalDate(2016, 5, 15));
		holidays.add(new LocalDate(2016, 5, 26));
		holidays.add(new LocalDate(2016, 8, 15));
		holidays.add(new LocalDate(2016, 11, 1));
		holidays.add(new LocalDate(2016, 11, 11));
		holidays.add(new LocalDate(2016, 12, 25));
		holidays.add(new LocalDate(2016, 12, 26));
	}

}
