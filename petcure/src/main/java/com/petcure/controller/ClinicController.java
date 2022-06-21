package com.petcure.controller;

import com.petcure.model.AnimalModel;
import com.petcure.model.ClinicModel;
import com.petcure.model.CustomerModel;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ClinicController {
	private ClinicModel clinicModel;
	private CustomerModel lastCustomerAdded;
	private ArrayList<AnimalModel> lastAnimalsAdded;

	@FXML
	private AnchorPane menuPane;

	@FXML
	private AnchorPane clinicInfoPane;

	@FXML
	private AnchorPane customerListPane;

	@FXML
	private AnchorPane customerCreationPane;

	@FXML
	private AnchorPane petCreationPane;

	@FXML
	private VBox dogCreationBox;

	@FXML
	private VBox catCreationBox;

	@FXML
	private Label clinicInfoLabel;

	@FXML
	private TreeView<String> customersTree;

	@FXML
	private TextField customerCreationNameInput;

	@FXML
	private TextField customerCreationPhoneInput;

	@FXML
	private TextField customerCreationDebtInput;

	@FXML
	private TextField dogCreationNameInput;

	@FXML
	private TextField dogCreationWeightInput;

	@FXML
	private TextField dogCreationBreedInput;

	@FXML
	private TextField catCreationNameInput;

	@FXML
	private TextField catCreationWeightInput;

	@FXML
	private CheckBox catCreationWildCheckbox;

	public ClinicController() {
		this.clinicModel = new ClinicModel();
		this.lastAnimalsAdded = new ArrayList<AnimalModel>();
	}

	private void setActivePane(AnchorPane pane) {
		menuPane.setVisible(false);
		clinicInfoPane.setVisible(false);
		customerListPane.setVisible(false);
		customerCreationPane.setVisible(false);
		petCreationPane.setVisible(false);

		pane.setVisible(true);
	}

	private void clearCustomerCreationInputs() {
		customerCreationNameInput.setText("");
		customerCreationPhoneInput.setText("");
		customerCreationDebtInput.setText("");
	}

	private void clearPetCreationInputs() {
		dogCreationNameInput.setText("");
		dogCreationWeightInput.setText("");
		dogCreationBreedInput.setText("");
		catCreationNameInput.setText("");
		catCreationWeightInput.setText("");
		catCreationWildCheckbox.setSelected(false);
	}

	private void setActivePetCreationBox(VBox box) {
		dogCreationBox.setVisible(false);
		catCreationBox.setVisible(false);

		if (box != null) {
			box.setVisible(true);
		}
	}

	private void addDogOrCatToCustomer() {
		if (dogCreationBox.isVisible()) {
			String name = dogCreationNameInput.getText();
			int weight = Integer.parseInt(dogCreationWeightInput.getText());
			String breed = dogCreationBreedInput.getText();
			AnimalModel lastAnimalAdded = lastCustomerAdded.addDog(name, weight, breed);
			lastAnimalsAdded.add(lastAnimalAdded);
		} else if (catCreationBox.isVisible()) {
			String name = catCreationNameInput.getText();
			int weight = Integer.parseInt(catCreationWeightInput.getText());
			boolean wild = catCreationWildCheckbox.isSelected();
			AnimalModel lastAnimalAdded = lastCustomerAdded.addCat(name, weight, wild);
			lastAnimalsAdded.add(lastAnimalAdded);
		}
	}

	@FXML
	void menuShowClinicInfo(ActionEvent event) throws IOException {
		String info = clinicModel.toString();
		clinicInfoLabel.setText(info);
		setActivePane(clinicInfoPane);
	}

	@FXML
	void menuShowCustomers(ActionEvent event) {
		ArrayList<CustomerModel> customers = clinicModel.getCustomers();
		TreeItem<String> root = new TreeItem<String>("Clientes");

		for (CustomerModel customer : customers) {
			TreeItem<String> nameItem = new TreeItem<String>(customer.getName());

			String phone = "Celular: " + customer.getPhone();
			TreeItem<String> phoneItem = new TreeItem<String>(phone);

			int debt = customer.getDebt();
			String debtString = "Dívida: R$" + debt;
			TreeItem<String> debtItem = new TreeItem<String>(debtString);

			ArrayList<AnimalModel> pets = customer.getPets();
			String petsString = "Pets: ";
			for (AnimalModel pet : pets) {
				if (pets.indexOf(pet) == pets.size() - 1) {
					petsString += pet.getName();
				} else {
					petsString += pet.getName() + ", ";
				}
			}
			TreeItem<String> petsItem = new TreeItem<String>(petsString);

			nameItem.getChildren().add(phoneItem);
			nameItem.getChildren().add(debtItem);
			nameItem.getChildren().add(petsItem);
			root.getChildren().add(nameItem);
		}

		customersTree.setRoot(root);
		customersTree.showRootProperty().set(false);
		setActivePane(customerListPane);
	}

	@FXML
	void menuAddSampleCustomer(ActionEvent event) {
		clinicModel.addSampleCustomer();
		// Set message OK
	}

	@FXML
	void menuAddCustomer(ActionEvent event) {
		setActivePane(customerCreationPane);
	}

	@FXML
	void menuRemoveCustomers(ActionEvent event) {
		ArrayList<CustomerModel> customers = clinicModel.getCustomers();
		clinicModel.removeCustomers(customers);
		// Set message OK
	}

	@FXML
	void menuStoreCustomers(ActionEvent event) {
		ArrayList<CustomerModel> customers = clinicModel.getCustomers();
		clinicModel.storeCustomers(customers);
		// Set message OK
	}

	@FXML
	void menuLoadCustomers(ActionEvent event) {
		clinicModel.loadCustomers();
		// Set message OK
	}

	@FXML
	void customerCreationSave(ActionEvent event) throws IOException {
		String name = customerCreationNameInput.getText();
		String phone = customerCreationPhoneInput.getText();
		int debt = Integer.parseInt(customerCreationDebtInput.getText());
		lastCustomerAdded = clinicModel.addCustomer(name, phone, debt);
		clearCustomerCreationInputs();
		setActivePane(petCreationPane);
	}

	@FXML
	void customerCreationCancel(ActionEvent event) {
		clearCustomerCreationInputs();
		setActivePane(menuPane);
	}

	@FXML
	void petCreationAddDog(ActionEvent event) {
		clearPetCreationInputs();
		setActivePetCreationBox(dogCreationBox);
	}

	@FXML
	void petCreationAddCat(ActionEvent event) {
		clearPetCreationInputs();
		setActivePetCreationBox(catCreationBox);
	}

	@FXML
	void petCreationCancel(ActionEvent event) {
		lastCustomerAdded.removePets(lastAnimalsAdded);
		lastAnimalsAdded.clear();

		ArrayList<CustomerModel> lastCustomerAddedArr = new ArrayList<CustomerModel>() {
			{
				add(lastCustomerAdded);
			}
		};
		clinicModel.removeCustomers(lastCustomerAddedArr);
		lastCustomerAdded = null;

		clearPetCreationInputs();
		setActivePetCreationBox(null);
		setActivePane(menuPane);
	}

	@FXML
	void petCreationNewPet(ActionEvent event) {
		addDogOrCatToCustomer();
		clearPetCreationInputs();
		setActivePetCreationBox(null);
	}

	@FXML
	void petCreationSave(ActionEvent event) {
		addDogOrCatToCustomer();
		lastCustomerAdded = null;
		lastAnimalsAdded.clear();
		clearPetCreationInputs();
		setActivePetCreationBox(null);
		setActivePane(menuPane);
	}

	@FXML
	void goToMenu(ActionEvent event) {
		setActivePane(menuPane);
	}
}