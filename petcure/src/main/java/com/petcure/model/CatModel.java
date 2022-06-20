package com.petcure.model;

public class CatModel extends AnimalModel {
	private boolean isWild;

	public CatModel(String name, int weight, boolean isWild) {
		super(name, weight);
	}

	public boolean isWild() {
		return this.isWild;
	}

	@Override
	public String makeNoise() {
		return "Miau";
	}
}
