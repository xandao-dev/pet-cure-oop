module com.petcure {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.petcure to javafx.fxml;
    exports com.petcure;
}
