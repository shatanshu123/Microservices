package com.microservice.rest.webservices.restful_webservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonControlller {
	@GetMapping(path = "/v1/person", produces = "application/json")
	public PersonV1 getFirstVersion() {
		return new PersonV1("Shatanshu Agarwal");
	}
	@GetMapping(path = "/v2/person", produces = "application/json")
	public PersonV2 getSecondVersion() {
		return new PersonV2(new Name("Shatanshu", "Agarwal"));
	}
}
