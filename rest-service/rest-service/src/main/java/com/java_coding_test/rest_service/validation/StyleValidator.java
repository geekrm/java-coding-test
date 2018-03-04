package com.java_coding_test.rest_service.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.java_coding_test.rest_service.model.Options;

public class StyleValidator  implements Validator<Options> {

	private final List<String> VALID_STYLES
		= new ArrayList<String>(Arrays.asList(new String[]{"EUROPEAN", "AMERICAN"}));
	
	@Override
	public ValidationResult validate(Options trade) {
		String style = trade.getStyle();
		
		if(VALID_STYLES.contains(style)) {
			return ValidationResult.OK;
		} else {
			return new ValidationResult(false, String.format("Invalid style: '%s'. Style has to be one of following values: %s.", style, VALID_STYLES));
		}
		
	}

}
