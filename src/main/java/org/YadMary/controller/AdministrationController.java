package org.YadMary.controller;

import javafx.fxml.FXML;
import org.YadMary.App;

import java.io.IOException;

public class AdministrationController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("Main");
    }
    @FXML
    private void switchToAdmins() throws IOException {
        App.setRoot("Main");
    }
    @FXML
    private void switchToSellers() throws IOException {
        App.setRoot("Main");
    }
    @FXML
    private void switchToInventory() throws IOException {
        App.setRoot("Main");
    }
    @FXML
    private void switchToAcquisitions() throws IOException {
        App.setRoot("Main");
    }

}
