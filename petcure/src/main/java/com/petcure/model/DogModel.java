package com.petcure.model;

public class DogModel extends AnimalModel {
	private String breed;

	public DogModel(String name, int weight, String breed) {
		super(name, weight);
		this.breed = breed;
	}

	public String getBreed() {
		return this.breed;
	}

	@Override
	public String makeNoise() {
		return "Woof";
	}
}