package com.petcure.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.github.javafaker.Faker;

public class ClinicModel {
	private String name;
	private String phone;
	private ArrayList<CustomerModel> customers;
	private Faker faker;

	public ClinicModel() {
		this.faker = new Faker();
		this.name = "PetCure";
		this.phone = this.faker.phoneNumber().cellPhone();
		this.customers = new ArrayList<CustomerModel>();
	}

	public ClinicModel(String name) {
		this.faker = new Faker();
		this.name = name;
		this.phone = this.faker.phoneNumber().cellPhone();
		this.customers = new ArrayList<CustomerModel>();
	}

	public ClinicModel(String name, String phone) {
		this.faker = new Faker();
		this.name = name;
		this.phone = phone;
		this.customers = new ArrayList<>();

	}

	public void addSampleCustomer() {
		String name = faker.name().fullName();
		String phone = faker.phoneNumber().cellPhone();
		this.customers.add(new CustomerModel(name, phone));
	}

	public void addCustomer(String name, String phone, int debt) {
		CustomerModel customer = new CustomerModel(name, phone);
		customer.setDebt(debt);
		this.customers.add(customer);
	}

	public void removeCustomers(ArrayList<CustomerModel> customers) {
		for (CustomerModel customer : customers) {
			this.customers.remove(customer);
		}
	}

	public ArrayList<CustomerModel> getCustomers() {
		return this.customers;
	}

	public void saveCustomers(ArrayList<CustomerModel> customers) {
		/*
		 * ObjectOutputStream outputStream = null;
		 * try {
		 * outputStream = new ObjectOutputStream(new
		 * FileOutputStream("c:\\temp\\petStore.dados"));
		 * for (int i = 0; i < mamiferos.size(); i++)
		 * outputStream.writeObject(mamiferos.get(i));
		 * } catch (FileNotFoundException ex) {
		 * JOptionPane.showMessageDialog(null, "Erro! Impossível criar o arquivo.");
		 * } catch (IOException ex) {
		 * } finally {
		 * try {
		 * if (outputStream != null) {
		 * outputStream.flush();
		 * outputStream.close();
		 * }
		 * } catch (IOException ex) {
		 * }
		 * }
		 */

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

	public ArrayList<CustomerModel> loadCustomers() {
		/*
		 * ArrayList<PequenoPorte> mamiferosTemp = new ArrayList<>();
		 * ObjectInputStream inputStream = null;
		 * try {
		 * inputStream = new ObjectInputStream(new
		 * FileInputStream("c:\\temp\\petStore.dados"));
		 * Object obj = null;
		 * while ((obj = inputStream.readObject()) != null) {
		 * if (obj instanceof PequenoPorte) {
		 * mamiferosTemp.add((PequenoPorte) obj);
		 * }
		 * }
		 * } catch (EOFException ex) {
		 * System.out.println("Fim de arquivo.");
		 * } catch (ClassNotFoundException ex) {
		 * } catch (FileNotFoundException ex) {
		 * JOptionPane.showMessageDialog(null, "Erro! Arquivo inexistente.");
		 * } catch (IOException ex) {
		 * } finally {
		 * try {
		 * if (inputStream != null) {
		 * inputStream.close();
		 * }
		 * } catch (final IOException ex) {
		 * }
		 * return mamiferosTemp;
		 * }
		 */
		ArrayList<CustomerModel> customers = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("customers.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			customers = (ArrayList<CustomerModel>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public String toString() {
		String info = "";
		info += "Nome: " + this.name + "\n";
		info += "Telefone: " + this.phone;
		return info;
	}
}
