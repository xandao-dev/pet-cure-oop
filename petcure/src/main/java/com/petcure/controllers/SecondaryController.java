package com.petcure.controllers;

import java.io.IOException;

import com.petcure.App;

import javafx.fxml.FXML;

public class SecondaryController {

	@FXML
	private void switchToPrimary() throws IOException {
		App.setRoot("primary");
	}
}