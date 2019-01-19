package com.chinthana.learn.springboot.restfull.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chinthana.learn.springboot.restfull.currencyconversionservice.data.CurrencyConverter;
import com.chinthana.learn.springboot.restfull.service.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/{value}")
	public CurrencyConverter convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal value) {
		
		Map<String, String> pathVariablesMap = new HashMap<>();
		pathVariablesMap.put("from", from);
		pathVariablesMap.put("to", to);		
		
		ResponseEntity<CurrencyConverter> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverter.class, pathVariablesMap);
		
		CurrencyConverter response = responseEntity.getBody();
		
		return new CurrencyConverter(response.getId(), from, to, response.getConversionMultiple(), value, value.multiply(response.getConversionMultiple()), response.getPort());
		
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/{value}")
	public CurrencyConverter convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal value) {
		
		CurrencyConverter response = currencyExchangeServiceProxy.getCurrencyExchaneValue(from, to);
		return new CurrencyConverter(response.getId(), from, to, response.getConversionMultiple(), value, value.multiply(response.getConversionMultiple()), response.getPort());
	}

}
