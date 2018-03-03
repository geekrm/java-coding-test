package com.java_coding_test.rest_service.model;



import com.java_coding_test.rest_service.validation.ValidationRules;

public class Spot extends Trade {

	@Override
	public String toString() {
		return "SPOT: "+String.format("valueDate: %s, ", valueDate)+super.toString();
	}
	
}
