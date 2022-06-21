package com.petcure.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

public class ClinicModel {
	private String name;
	private String phone;
	private ArrayList<CustomerModel> customers;
	private Faker faker;

	public ClinicModel() {
		this.faker = new Faker(new Locale("pt-BR"));
		this.name = "PetCure";
		this.phone = this.faker.phoneNumber().cellPhone();
		this.customers = new ArrayList<CustomerModel>();
	}

	public ClinicModel(String name) {
		this.faker = new Faker(new Locale("pt-BR"));
		this.name = name;
		this.phone = this.faker.phoneNumber().cellPhone();
		this.customers = new ArrayList<CustomerModel>();
	}

	public ClinicModel(String name, String phone) {
		this.faker = new Faker(new Locale("pt-BR"));
		this.name = name;
		this.phone = phone;
		this.customers = new ArrayList<>();

	}

	public void addSampleCustomer() {
		String name = faker.name().fullName();
		String phone = faker.phoneNumber().cellPhone();
		CustomerModel customer = new CustomerModel(name, phone);
		int debt = faker.number().numberBetween(0, 2000);
		if (debt > 1000) {
			debt = 0; // 50% zero
		}
		customer.setDebt(debt);
		this.customers.add(customer);
	}

	public CustomerModel addCustomer(String name, String phone, int debt) {
		CustomerModel customer = new CustomerModel(name, phone);
		customer.setDebt(debt);
		this.customers.add(customer);
		return customer;
	}

	public void removeCustomers(ArrayList<CustomerModel> customers) {
		this.customers.removeAll(customers);
	}

	public ArrayList<CustomerModel> getCustomers() {
		return this.customers;
	}

	public void storeCustomers(ArrayList<CustomerModel> customers) {
		try {
			FileOutputStream fos = new FileOutputStream("customers.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(customers);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadCustomers() {
		try {
			FileInputStream fis = new FileInputStream("customers.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.customers = (ArrayList<CustomerModel>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String info = "";
		info += "Nome: " + this.name + "\n";
		info += "Telefone: " + this.phone;
		return info;
	}
}
