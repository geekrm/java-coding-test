package com.java_coding_test.rest_service.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.java_coding_test.rest_service.model.Options;

public class OptionsDatesValidator  implements Validator<Options> {

	private final String DATE_FORMAT = "yyyy-MM-dd";
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	
	public OptionsDatesValidator() {
		dateFormat.setLenient(false);
	}
	
	@Override
	public ValidationResult validate(Options trade) {

		boolean success = true;
		StringBuilder message = new StringBuilder();
		
		String tradeDateString = trade.getTradeDate();
		String deliveryDateString = trade.getDeliveryDate();
		String expiryDateString = trade.getExpiryDate();
		String premiumDateString = trade.getPremiumDate();

		try {
			dateFormat.parse(tradeDateString);
		} catch (ParseException e) {
			success = false;
			message.append(String.format("Invalid trade date: '%s' (valid format: '%s'). ", tradeDateString, DATE_FORMAT));
		}
		
		Date deliveryDate = null;
		try {
			deliveryDate = dateFormat.parse(deliveryDateString);
		} catch (ParseException e) {
			success = false;
			message.append(String.format("Invalid delivery date: '%s' (valid format: '%s'). ", deliveryDateString, DATE_FORMAT));
		}

		Date expiryDate = null;
		try {
			expiryDate = dateFormat.parse(expiryDateString);
		} catch (ParseException e) {
			success = false;
			message.append(String.format("Invalid expiry date: '%s' (valid format: '%s'). ", expiryDateString, DATE_FORMAT));
		}
		
		Date premiumDate = null;
		try {
			premiumDate = dateFormat.parse(premiumDateString);
		} catch (ParseException e) {
			success = false;
			message.append(String.format("Invalid premium date: '%s' (valid format: '%s'). ", premiumDateString, DATE_FORMAT));
		}
		
		if(!success) {
			return new ValidationResult(success, message.toString());
		}
		
		if(expiryDate.getTime() < deliveryDate.getTime() 
				&& premiumDate.getTime() < deliveryDate.getTime()) {
			return ValidationResult.OK;
		} else {
			return new ValidationResult(false, 
					String.format("Expiry Date (%s) and Premium Date (%s) shall be before Delivery Date (%s).", expiryDateString, premiumDateString, deliveryDateString));
		}
		
	}

}
