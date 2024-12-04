package org.YadMary.controller;

import javafx.fxml.FXML;
import org.YadMary.App;

import java.io.IOException;

public class sellController {

    @FXML
    private void switchToHome() throws IOException, IOException {
        App.setRoot("Main");
    }
}
