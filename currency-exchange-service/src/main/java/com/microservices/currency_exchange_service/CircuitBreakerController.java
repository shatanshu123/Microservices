package com.microservices.currency_exchange_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
	public String sampleAPI() {
		logger.info("Sample API call received");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
				String.class );
		return forEntity.getBody();
	}
	@GetMapping(" ")
	@CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String sampleAPIs() {
		logger.info("Sample API call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",
//				String.class);
//		return forEntity.getBody();
		return "sample-api";
	}

	public String hardCodedResponse(Exception ex) {
		return "fallback-response";
	}
}
