package com.java_coding_test.rest_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java_coding_test.rest_service.model.*;
import com.java_coding_test.rest_service.validation.ValidationRules;
import com.java_coding_test.rest_service.validation.ValidationRulesProvider;

@RestController
public class TradesController {

	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public List<Trade> validate(@RequestBody List<Trade> trades){
		
		for(Trade trade : trades) {
			System.out.println(trade.toString());
			ValidationRules rules = ValidationRulesProvider.getValidationRules(trade);
			System.out.println(rules.getValidators().size());
		}
		return trades;
	}
	
}
