package com.microservice.rest.webservices.restful_webservices.versioning;

public class PersonV2 {
	private Name name;

	public Name getName() {
		return name;
	}

	public PersonV2(Name name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
}
