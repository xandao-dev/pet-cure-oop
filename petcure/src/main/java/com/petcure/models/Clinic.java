package com.petcure.models;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Clinic {
	private String name;
	private String phone;
	private ArrayList<Customer> customers;

	public Clinic(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.customers = new ArrayList<>();
	}

	public void printClinic() {
		System.out.println("Clinic: " + this.name + " - " + this.phone);
	}

	public void addSampleCustomers() {
		this.customers.add(new Customer("John", "123456789"));
		this.customers.add(new Customer("Jane", "123456789"));
		this.customers.add(new Customer("Jack", "123456789"));
	}

	public void addCustomer() {
		// Data incoming from view
		String[] customerData = { "Alexandre", "123456789" };
		Customer customer = new Customer(customerData[0], customerData[1]);
		this.customers.add(customer);
	}

	public void removeCustomers(ArrayList<Customer> customers) {
		for (Customer customer : customers) {
			this.customers.remove(customer);
		}
	}

	public ArrayList<Customer> getCustomers() {
		return this.customers;
	}

	public void saveCustomers(ArrayList<Customer> customers) {
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

	public ArrayList<Customer> loadCustomers() {
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
		ArrayList<Customer> customers = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream("customers.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			customers = (ArrayList<Customer>) ois.readObject();
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

	public static void main(String[] args) {
		Clinic petCure = new Clinic("PetCure", "(00) 12345-6789");
		petCure.printClinic();

		petCure.addCustomer();
		for (Customer c : petCure.getCustomers()) {
			System.out.println(c.toString());
		}
		System.out.println("----\n");

		petCure.addCustomer();
		for (Customer c : petCure.getCustomers()) {
			System.out.println(c.toString());
		}
		System.out.println("----\n");

		ArrayList<Customer> customers = petCure.getCustomers();
		ArrayList<Customer> customersToRemove = new ArrayList<Customer>() {
			{
				add(customers.get(0));
			}
		};
		petCure.removeCustomers(customersToRemove);
		for (Customer c : petCure.getCustomers()) {
			System.out.println(c.toString());
		}
		System.out.println("----\n");

		petCure.saveCustomers(customers);
		ArrayList<Customer> loadedCustomers = petCure.loadCustomers();
		for (Customer c : loadedCustomers) {
			System.out.println(c.toString());
		}
	}
}
