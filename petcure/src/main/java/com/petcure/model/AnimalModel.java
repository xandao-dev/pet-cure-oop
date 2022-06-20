package com.petcure.model;

import java.io.Serializable;

public class AnimalModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public AnimalModel(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
