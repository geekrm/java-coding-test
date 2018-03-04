package com.java_coding_test.rest_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.java_coding_test.rest_service.validation.IValidationRulesProvider;
import com.java_coding_test.rest_service.validation.ValidationRulesProvider;

@Configuration
public class ValidationConfig {

	@Bean
	IValidationRulesProvider createProvider() {
		return new ValidationRulesProvider();
	}

}
