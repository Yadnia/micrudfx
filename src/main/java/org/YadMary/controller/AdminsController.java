package org.YadMary.controller;

import javafx.fxml.FXML;
import org.YadMary.App;

import java.io.IOException;

public class AdminsController {

    @FXML
    private void switchToAdministration() throws IOException {
        App.setRoot("Main");
    }
}
