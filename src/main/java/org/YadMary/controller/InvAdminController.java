package org.YadMary.controller;

import javafx.fxml.FXML;
import org.YadMary.App;

import java.io.IOException;

public class InvAdminController {
    @FXML
    private void switchToAdministration () throws IOException {
        App.setRoot("InvAdmin");
    }
}
