package com.java_coding_test.rest_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.java_coding_test.rest_service.model.*;

@RestController
public class TradesController {

	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public List<Trade> validate(@RequestBody List<Trade> trades){
		
		for(Trade trade : trades)
			System.out.println(trade.toString());
		return trades;
	}
	
}
