package com.petcure.controllers;

import java.io.IOException;

import com.petcure.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ClinicController {

	@FXML
	private Button removeClientBtn;

	@FXML
	private Button addSampleCustomersBtn;

	@FXML
	private Button showClientsBtn;

	@FXML
	private Button addClientBtn;

	@FXML
	private Button showClinicInfoBtn;

	@FXML
	void showClinicInfo(ActionEvent event) throws IOException {
		App.setRoot("primary");
	}

	@FXML
	void showClients(ActionEvent event) {

	}

	@FXML
	void addSampleCustomers(ActionEvent event) {

	}

	@FXML
	void addClient(ActionEvent event) {

	}

	@FXML
	void removeClient(ActionEvent event) {

	}

}
