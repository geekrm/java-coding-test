package com.java_coding_test.rest_service.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java_coding_test.rest_service.model.Trade;

public class CounterpartySupportedValidator implements Validator<Trade> {

	private final List<String> VALID_COUNTERPARTIES
	= new ArrayList<String>(Arrays.asList(new String[]{"PLUTO1", "PLUTO2"}));

@Override
public ValidationResult validate(Trade trade) {
	String customer = trade.getCustomer();
	
	if(VALID_COUNTERPARTIES.contains(customer)) {
		return ValidationResult.OK;
	} else {
		return new ValidationResult(false, String.format("Invalid customer: '%s'. Customer has to be one of following values: %s.", customer, VALID_COUNTERPARTIES));
	}
	
}

}
