package com.java_coding_test.rest_service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.*;
import com.java_coding_test.rest_service.validation.ValidationRules;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
	@JsonSubTypes.Type(name = "Forward", value = Forward.class),
	@JsonSubTypes.Type(name = "Spot", value = Spot.class),
	@JsonSubTypes.Type(name = "VanillaOption", value = Options.class),
	// to add new Product create new class extending Trade and add 
	// @JsonSubTypes.Type annotation like above
})
public abstract class Trade {

	protected String customer;
	protected String ccyPair;
	protected String direction;
	protected Date tradeDate;
	protected BigDecimal amount1, amount2;
	protected float rate;
	protected String legalEntity;
	protected String trader;
	protected Date valueDate;

	private String validationStatus = "OK";
	private List<String> validationMsgList = new ArrayList<String>();

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCcyPair() {
		return ccyPair;
	}

	public void setCcyPair(String ccyPair) {
		this.ccyPair = ccyPair;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public BigDecimal getAmount1() {
		return amount1;
	}

	public void setAmount1(BigDecimal amount1) {
		this.amount1 = amount1;
	}

	public BigDecimal getAmount2() {
		return amount2;
	}

	public void setAmount2(BigDecimal amount2) {
		this.amount2 = amount2;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getValidationStatus() {
		return validationStatus;
	}

	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}

	public List<String> getValidationMsgList() {
		return validationMsgList;
	}

	public void setValidationMsgList(List<String> validationMsgList) {
		this.validationMsgList = validationMsgList;
	}
	
	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}


	@Override
	public String toString() {
		return String.format(
				"customer: %s, tradeDate: %s, amount1: %s", customer, tradeDate, amount1);
	}
	
}
