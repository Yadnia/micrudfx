package org.YadMary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.YadMary.App;

import java.io.IOException;

public class MainController {

    @FXML
    private Button mainBtton;
    @FXML
    private Button comprasBtton;
    @FXML
    private Button inventoryBtton;
    @FXML
    private Button sellBttn;
    @FXML
    private Button administrateBtton;
    @FXML
    private Button configBtton;

    @FXML
    private void switchToCompras() throws IOException {
        App.setRoot("Acquisitions");
    }
    @FXML
    private void switchToInventory() throws IOException {
        App.setRoot("Inventory");
    }
    @FXML
    private void switchToSell() throws IOException {
        App.setRoot("sell");
    }
    @FXML
    private void switchToAdministrate() throws IOException {
        App.setRoot("Administration");
    }
    @FXML
    private void switchToConfig() throws IOException {
        App.setRoot("Config");
    }

}
