package com.petcure.controller;

import java.io.IOException;

import com.petcure.App;
import com.petcure.model.ClinicModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClinicController {
	private ClinicModel clinicModel = new ClinicModel();

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
	private Button goHomeBtn;

	@FXML
	private Label clinicInfoLabel;

	@FXML
	void showClinicInfo(ActionEvent event) throws IOException {
		String info = clinicModel.toString();
		clinicInfoLabel.setText(info);
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