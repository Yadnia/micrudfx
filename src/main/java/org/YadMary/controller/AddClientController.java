package org.YadMary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.YadMary.App;
import org.YadMary.entity.Cliente;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class AddClientController {
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
    public void addClient(){
        String name = nametxt.getText();
        String apellidost = apellidostxt.getText();
        String ced = cedtxt.getText();

        Cliente cliente = new Cliente();
        cliente.setNames(name);
        cliente.setSurnames(apellidost);
        cliente.setIDE(ced);
        createClient(cliente);

    }
    public void createClient(Cliente cliente){
        IGenericService<Cliente> clientService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        clientService.save(cliente);
    }

}
