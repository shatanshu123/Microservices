package com.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) throws Exception {
		CurrencyExchange currencyExchange=currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange==null) {
			throw new Exception("Unable to find data for"+ from + " to "+to);
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
}
