module com.petcure {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafaker;
	requires java.sql;

	opens com.petcure to javafx.fxml;
	opens com.petcure.controller to javafx.fxml;

	exports com.petcure;
	exports com.petcure.controller;
}
