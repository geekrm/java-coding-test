package com.java_coding_test.rest_service.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.java_coding_test.rest_service.model.Trade;

public class ValueAndTradeDateValidator implements Validator<Trade> {

	private final String DATE_FORMAT = "yyyy-MM-dd";
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	
	public ValueAndTradeDateValidator() {
		dateFormat.setLenient(false);
	}
	
	@Override
	public ValidationResult validate(Trade trade) {

		boolean success = true;
		StringBuilder message = new StringBuilder();
		
		String tradeDateString = trade.getTradeDate();
		String valueDateString = trade.getValueDate();
		
		Date tradeDate = null;
		try {
			tradeDate = dateFormat.parse(tradeDateString);
		} catch (ParseException e) {
			success = false;
			message.append(String.format("Invalid trade date: '%s' (valid format: '%s'). ", tradeDateString, DATE_FORMAT));
		}
		
		Date valueDate = null;
		try {
			valueDate = dateFormat.parse(valueDateString);
		} catch (ParseException e) {
			success = false;
			message.append(String.format("Invalid value date: '%s' (valid format: '%s'). ", valueDateString, DATE_FORMAT));
		}
		
		if(!success) {
			return new ValidationResult(success, message.toString());
		}
		
		if(valueDate.getTime() < tradeDate.getTime()) {
			return new ValidationResult(false, 
					String.format("Value Date (%s) cannot be before Trade Date (%s)", valueDateString, tradeDateString));
		} else {
			return ValidationResult.OK;
		}
		
	}

}
