package com.giridhar.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.giridhar.microservices.pojo.ExchangeValue;
import com.giridhar.microservices.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@Autowired
	Environment environment;
	@Autowired
	ExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		String property = environment.getProperty("local.server.port");
		log.info("from: "+from+" to: "+to+" exchangeValue: "+exchangeValue+" port: "+property);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;

	}

}
