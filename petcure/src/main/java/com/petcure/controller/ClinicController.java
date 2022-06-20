package com.petcure.controller;

import com.petcure.model.AnimalModel;
import com.petcure.model.ClinicModel;
import com.petcure.model.CustomerModel;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class ClinicController {
	private ClinicModel clinicModel;

	@FXML
	private AnchorPane menuPane;

	@FXML
	private AnchorPane clinicInfoPane;

	@FXML
	private AnchorPane customerListPane;

	@FXML
	private AnchorPane customerCreationPane;

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

	public ClinicController() {
		this.clinicModel = new ClinicModel();
	}

	private void setActivePane(AnchorPane pane) {
		menuPane.setVisible(false);
		clinicInfoPane.setVisible(false);
		customerListPane.setVisible(false);
		customerCreationPane.setVisible(false);

		pane.setVisible(true);
	}

	private void clearCustomerCreationInputs() {
		customerCreationNameInput.setText("");
		customerCreationPhoneInput.setText("");
		customerCreationDebtInput.setText("");
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

	}

	@FXML
	void menuStoreCustomers(ActionEvent event) {

	}

	@FXML
	void menuLoadCustomers(ActionEvent event) {

	}

	@FXML
	void customerCreationSave(ActionEvent event) throws IOException {
		String name = customerCreationNameInput.getText();
		String phone = customerCreationPhoneInput.getText();
		int debt = Integer.parseInt(customerCreationDebtInput.getText());
		clinicModel.addCustomer(name, phone, debt);
		clearCustomerCreationInputs();
		setActivePane(menuPane);
	}

	@FXML
	void customerCreationCancel(ActionEvent event) {
		clearCustomerCreationInputs();
		setActivePane(menuPane);
	}

	@FXML
	void goToMenu(ActionEvent event) {
		setActivePane(menuPane);
	}
}