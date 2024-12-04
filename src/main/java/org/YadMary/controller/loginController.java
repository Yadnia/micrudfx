package org.YadMary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.YadMary.App;
import org.YadMary.entity.User;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class loginController {

    ObservableList<User> usuarios;
    private User loggedUser;
    @FXML
    private TextField usertxt;
    @FXML
    private TextField passwdtxt;


    @FXML
    private void validateLogin() throws IOException {
//        usuarios=getUsuarios();
        String username = this.usertxt.getText();
        String password = this.passwdtxt.getText();

        if (username.equals("yad") && password.equals("1234")) {
            switchToMain();
        }

//        boolean flag = false;
//        for (User usuario : usuarios) {
//            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
//                flag = true;
//                break;
//            }
//        }
//        if (flag)  {
//            switchToMain();
//        } else {
//            System.out.println("Invalid username or password");
//        }
    }

    private void switchToMain() throws IOException {
        App.setRoot("Main");
    }


//    private ObservableList<User> getUsuarios (){
//        IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
//        return FXCollections.observableArrayList(usuarioService.findAll());
//    }

//    private void ini(){
//        if(usuarios.isEmpty()){
//            User usuario = new User();
//            usuario.setUsername("yad");
//            usuario.setPassword("1234");
//            IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
//            usuarioService.save(usuario);
//            loggedUser = usuario;
//            usuarios.add(loggedUser);
//        };
//    }
}