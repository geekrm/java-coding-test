package com.java_coding_test.rest_service.model;

import java.util.Currency;
import java.util.Date;

public class Options extends Trade {

	private String style;
	private String strategy;
	private Date deliveryDate, expiryDate, premiumDate;
	private Currency payCcy;
	private float premium;
	private Currency premiumCcy;
	private String premiumType;
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getPremiumDate() {
		return premiumDate;
	}

	public void setPremiumDate(Date premiumDate) {
		this.premiumDate = premiumDate;
	}

	public Currency getPayCcy() {
		return payCcy;
	}

	public void setPayCcy(Currency payCcy) {
		this.payCcy = payCcy;
	}

	public float getPremium() {
		return premium;
	}

	public void setPremium(float premium) {
		this.premium = premium;
	}

	public Currency getPremiumCcy() {
		return premiumCcy;
	}

	public void setPremiumCcy(Currency premiumCcy) {
		this.premiumCcy = premiumCcy;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	@Override
	public String toString() {
		return "OPTIONS: "+String.format("premiumCcy: %s, ", premiumCcy)+super.toString();
	}
	
}
