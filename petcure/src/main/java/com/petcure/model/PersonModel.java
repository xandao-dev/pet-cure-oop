package com.petcure.model;

import java.io.Serializable;

public abstract class PersonModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String phone;

	public PersonModel(String name) {
		this.name = name;
		this.phone = null;
	}

	public PersonModel(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}
}
