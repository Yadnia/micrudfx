package org.YadMary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.YadMary.App;
import org.YadMary.entity.Proveedor;
import org.YadMary.entity.User;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class AddProvController {
    @FXML
    private TextField nametxt;

    @FXML
    private TextField apellidostxt;

    @FXML
    private TextField cedtxt;


    @FXML
    private void switchToAdministration() throws IOException {
        App.setRoot("Administration");
    }

    @FXML
    public void addProv(){
        String name = nametxt.getText();
        String apellidost = apellidostxt.getText();
        String ced = cedtxt.getText();

        Proveedor proveedor = new Proveedor();
        proveedor.setProvName(name);
        proveedor.setProvApell(apellidost);
        proveedor.setProvTelef(ced);
        createProv(proveedor);

    }
    public void createProv(Proveedor proveedor){
        IGenericService<Proveedor> provService = new GenericServiceImpl<>(Proveedor.class, HibernateUtil.getSessionFactory());
        provService.save(proveedor);
    }

}
