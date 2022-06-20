package com.petcure.controllers;

import java.io.IOException;

import com.petcure.App;

import javafx.fxml.FXML;

public class PrimaryController {

	@FXML
	private void switchToSecondary() throws IOException {
		App.setRoot("secondary");
	}
}
