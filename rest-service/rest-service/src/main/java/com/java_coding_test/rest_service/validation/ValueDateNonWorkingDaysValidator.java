package com.java_coding_test.rest_service.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.LocalDate;

import com.java_coding_test.rest_service.model.Trade;

import net.objectlab.kit.datecalc.common.DateCalculator;
import net.objectlab.kit.datecalc.common.DefaultHolidayCalendar;
import net.objectlab.kit.datecalc.common.HolidayHandlerType;
import net.objectlab.kit.datecalc.joda.LocalDateKitCalculatorsFactory;

public class ValueDateNonWorkingDaysValidator implements Validator<Trade> {

	private final String DATE_FORMAT = "yyyy-MM-dd";
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	
	private DateCalculator<LocalDate> dateCalculator;
	
	public ValueDateNonWorkingDaysValidator() {
		this(new HashSet<LocalDate>());
	}
	
	public ValueDateNonWorkingDaysValidator(Set<LocalDate> holidays) {
		dateFormat.setLenient(false);
		
        DefaultHolidayCalendar<LocalDate> holidayCalendar =
            new DefaultHolidayCalendar<LocalDate>(holidays);

        LocalDateKitCalculatorsFactory.getDefaultInstance()
                .registerHolidays("holidays", holidayCalendar);
        dateCalculator = LocalDateKitCalculatorsFactory.getDefaultInstance()
                .getDateCalculator("holidays", HolidayHandlerType.FORWARD);

	}
	
	@Override
	public ValidationResult validate(Trade trade) {
	
		String valueDateString = trade.getValueDate();
		
		Date valueDate = null;
		try {
			valueDate = dateFormat.parse(valueDateString);
		} catch (ParseException e) {
			return new ValidationResult(false, String.format("Invalid value date: '%s' (valid format: '%s'). ", valueDateString, DATE_FORMAT));
		}
		
		LocalDate localValueDate = new LocalDate(valueDate.getTime());
		
		if(dateCalculator.isNonWorkingDay(localValueDate)) {
			return new ValidationResult(false, String.format("Value Date (%s) is a non working day.", valueDateString));
		} else {
			return ValidationResult.OK;
		}
		
	}

}