package org.YadMary.controller;

import javafx.fxml.FXML;
import org.YadMary.App;

import java.io.IOException;

public class AcquisitionsController {

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("Main");
    }
    
}
