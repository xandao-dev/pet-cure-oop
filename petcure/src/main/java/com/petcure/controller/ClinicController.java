package com.petcure.controller;

import com.petcure.model.AnimalModel;
import com.petcure.model.ClinicModel;
import com.petcure.model.CustomerModel;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

public class ClinicController {
	private ClinicModel clinicModel = new ClinicModel();

	@FXML
	private AnchorPane menuPane;

	@FXML
	private AnchorPane clinicInfoPane;

	@FXML
	private AnchorPane clientListPane;

	@FXML
	private AnchorPane clientCreationPane;

	@FXML
	private Label clinicInfoLabel;

	@FXML
	private TreeView<String> clientsTree;

	private void setActivePane(AnchorPane pane) {
		menuPane.setVisible(false);
		clinicInfoPane.setVisible(false);
		clientListPane.setVisible(false);
		clientCreationPane.setVisible(false);

		pane.setVisible(true);
	}

	@FXML
	void showClinicInfo(ActionEvent event) throws IOException {
		String info = clinicModel.toString();
		clinicInfoLabel.setText(info);
		setActivePane(clinicInfoPane);
	}

	@FXML
	void showClients(ActionEvent event) {
		ArrayList<CustomerModel> customers = clinicModel.getCustomers();
		TreeItem<String> root = new TreeItem<String>("Clients");

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

		clientsTree.setRoot(root);
		clientsTree.showRootProperty().set(false);
		setActivePane(clientListPane);
	}

	@FXML
	void addSampleCustomer(ActionEvent event) {
		clinicModel.addSampleCustomer();
		// Set message OK
	}

	@FXML
	void addClient(ActionEvent event) {

	}

	@FXML
	void removeClient(ActionEvent event) {

	}

	@FXML
	void goToMenu(ActionEvent event) {
		setActivePane(menuPane);
	}
}