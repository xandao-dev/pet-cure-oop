package com.petcure.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private int debt = 0;
	private ArrayList<Animal> pets = new ArrayList<>();

	public Customer(String name) {
		super(name);
	}

	public Customer(String name, String phone) {
		super(name, phone);
	}

	public int getDebt() {
		return debt;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}

	public ArrayList<Animal> getPets() {
		return pets;
	}

	public void addPet() {
		// Data incoming from view
		String[] petData = { "Xandim" };
		Animal pet = new Animal(petData[0]);
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
