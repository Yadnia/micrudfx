package org.YadMary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.YadMary.App;
import org.YadMary.entity.Producto;
import org.YadMary.entity.User;
import org.YadMary.entity.Vendedor;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class AddSellerController {

    @FXML
    private TextField nametxt;

    @FXML
    private TextField apellidostxt;

    @FXML
    private TextField cedtxt;
    @FXML
    private TextField usertxt;

    @FXML
    private void switchToAdministration() throws IOException {
        App.setRoot("Administration");
    }

    @FXML
    public void addSeller(){
        String name = nametxt.getText();
        String apellidost = apellidostxt.getText();
        String ced = cedtxt.getText();
        String user = usertxt.getText();

        User vendedor = new User();
        vendedor.setNombre(name);
        vendedor.setApellido(apellidost);
        vendedor.setUsername(user);
        vendedor.setPassword(ced);
        createVendedor(vendedor);

    }
    public void createVendedor(User user){
        IGenericService<User> VendeService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        VendeService.save(user);
    }

}
