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
	@GetMapping(path = "/person",params="version=1", produces = "application/json")
	public PersonV1 getFirstVersionofPersonRequestParameter() {
		return new PersonV1("Shatanshu Agarwal");
	}
	@GetMapping(path = "/person", params="version=2",produces = "application/json")
	public PersonV2 getSecondVersionofPersonRequestParameter() {
		return new PersonV2(new Name("Shatanshu", "Agarwal"));
	}
	@GetMapping(path = "/person/header",headers="X-API-VERSION=1", produces = "application/json")
	public PersonV1 getFirstVersionofPersonRequestHeader() {
		return new PersonV1("Shatanshu Agarwal");
	}
	@GetMapping(path = "/person/header",headers="X-API-VERSION=2", produces = "application/json")
	public PersonV2 getSecondVersionofPersonRequestHeader() {
		return new PersonV2(new Name("Shatanshu", "Agarwal"));
	}
}
