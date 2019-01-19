package com.chinthana.learn.springboot.restfull.currencyconversionservice.data;

import java.math.BigDecimal;

public class CurrencyConverter {
	
	
	private Long id;
	private String from;	
	private String to;	
	private BigDecimal conversionMultiple;
	private BigDecimal value;
	private BigDecimal convertedValue;
	private String port;
	
	public CurrencyConverter() {
		super();
	}

	public CurrencyConverter(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal value,
			BigDecimal convertedValue, String port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.value = value;
		this.convertedValue = convertedValue;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}	

}
