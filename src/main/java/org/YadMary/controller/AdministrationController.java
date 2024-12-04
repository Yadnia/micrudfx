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
        App.setRoot("Admins");
    }
    @FXML
    private void switchToSellers() throws IOException {
        App.setRoot("Sellers");
    }
    @FXML
    private void switchToInventory() throws IOException {
        App.setRoot("products");
    }
    @FXML
    private void switchToProvs() throws IOException {
        App.setRoot("provs");
    }
    @FXML
    private void switchToClients() throws IOException {
        App.setRoot("clients");
    }

}
