package com.java_coding_test.rest_service.model;



public class Forward extends Trade {

	
	@Override
	public String toString() {
		return "FORWARD: "+String.format("valueDate: %s, ", valueDate)+super.toString();
	}
	
}
