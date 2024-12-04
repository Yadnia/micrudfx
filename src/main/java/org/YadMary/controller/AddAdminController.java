package org.YadMary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.YadMary.App;
import org.YadMary.entity.User;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class AddAdminController {

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
    public void addAdmin(){
        String name = nametxt.getText();
        String apellidost = apellidostxt.getText();
        String ced = cedtxt.getText();
        String user = usertxt.getText();

        User admin = new User();
        admin.setNombre(name);
        admin.setApellido(apellidost);
        admin.setUsername(user);
        admin.setPassword(ced);
        createAdmin(admin);

    }
    public void createAdmin(User user){
        IGenericService<User> VendeService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        VendeService.save(user);
    }

}
