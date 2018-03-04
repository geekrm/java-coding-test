package com.java_coding_test.rest_service.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java_coding_test.rest_service.model.*;
import com.java_coding_test.rest_service.validation.IValidationRulesProvider;
import com.java_coding_test.rest_service.validation.ValidationRules;

@RestController
public class TradesController {

	@Autowired
	IValidationRulesProvider validationRulesProvider;
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public List<Trade> validate(@RequestBody List<Trade> trades){
		
		try(Stream<Trade> tradesStream = trades.stream()){
			
			tradesStream.forEach(trade -> {
				ValidationRules rules = validationRulesProvider.getValidationRules(trade);
				rules.validate(trade);
			});
			
		}

		return trades;
	}
	
}
