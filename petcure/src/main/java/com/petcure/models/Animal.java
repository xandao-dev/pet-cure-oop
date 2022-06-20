package com.petcure.models;

import java.io.Serializable;

public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
