package com.petcure.model;

import java.io.Serializable;

public abstract class AnimalModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int weight;

	public AnimalModel(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return this.name;
	}

	public int getWeight() {
		return this.weight;
	}

	public abstract String makeNoise();

	@Override
	public String toString() {
		String animal = "";
		animal += "Nome: " + this.name + "\n";
		animal += "Peso: " + this.weight + "kg\n";
		return animal;
	}
}
