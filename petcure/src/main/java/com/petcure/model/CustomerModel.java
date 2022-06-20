package com.petcure.model;

import java.util.ArrayList;

public class CustomerModel extends PersonModel {
	private int debt = 0;
	private ArrayList<AnimalModel> pets = new ArrayList<>();

	public CustomerModel(String name) {
		super(name);
	}

	public CustomerModel(String name, String phone) {
		super(name, phone);
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public ArrayList<AnimalModel> getPets() {
		return pets;
	}

	public void addDog(String name, int weight, String breed) {
		AnimalModel pet = new DogModel(name, weight, breed);
		this.pets.add(pet);
	}

	public void addCat(String name, int weight, boolean isWild) {
		AnimalModel pet = new CatModel(name, weight, isWild);
		this.pets.add(pet);
	}

	@Override
	public String toString() {
		String customer = "";
		customer += "Name: " + getName() + "\n";
		customer += "Phone: " + getPhone() + "\n";
		customer += "Debt: " + this.debt + "\n";
		customer += "Pets: " + this.pets.toString() + "\n";
		return customer;
	}
}
