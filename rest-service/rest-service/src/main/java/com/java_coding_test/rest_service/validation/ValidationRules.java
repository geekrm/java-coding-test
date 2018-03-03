package com.java_coding_test.rest_service.validation;

import java.util.ArrayList;
import java.util.List;

import com.java_coding_test.rest_service.model.Trade;


public class ValidationRules {

	private List<Validator> validators;
	
	public ValidationRules() {
		this.validators = new ArrayList<Validator>();
	}
	
	public ValidationRules(List<Validator> validators) {
		this.validators = validators;
	}
	
	public ValidationRules add(Validator validator) {
		validators.add(validator);
		return this;
	}
	
	public List<Validator> getValidators(){
		return validators;
	}
	
	public void validate(Trade trade) {
		
		boolean isSuccess = true;
		List<String> validationMsgList = new ArrayList<String>();
		
		for(Validator validator : validators) {
			ValidationResult result = validator.validate(trade);
			
			if(isSuccess) {
				isSuccess = result.isSuccess();
			}
			
			if(result.getMessage() != null)
				validationMsgList.add(result.getMessage());
		}
		
		trade.setValidationStatus(isSuccess ? "OK" : "FAILURE");
		trade.setValidationMsgList(validationMsgList);
	}
	
}
