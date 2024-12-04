package org.YadMary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.YadMary.entity.Post;
import org.YadMary.entity.User;
import org.YadMary.service.IGenericService;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.utils.HibernateUtil;

import java.net.URL;
import java.util.ResourceBundle;

public class UserController implements Initializable {

    public Button btnPost;
    public TextField txtuser;
    public TextField txtpass;
    public Button btnlogin;
    public Label lbwelcome;
    private User loggedUser;
    ObservableList<User> usuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        crearUsuario();
    }

    private void crearUsuario() {
        usuarios = getUsuarios();
        if(usuarios.isEmpty()){
            User usuario = new User();
            usuario.setUsername("yad");
            usuario.setPassword("1234");


            IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
            usuarioService.save(usuario);
            loggedUser = usuario;
            usuarios.add(loggedUser);
        };
    }

   private ObservableList<User> getUsuarios (){
       IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
       return FXCollections.observableArrayList(usuarioService.findAll());
    }

    public void loginUser(){
        String username = txtuser.getText();
        String password = txtpass.getText();
        boolean flag =false;
        for (User usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            lbwelcome.setText("Welcome " + username);
        } else {
            lbwelcome.setText("Invalid user or password");
        }
    }

    public void testPost(){
        Post post = new Post();
        post.setTitle("Test");
        post.setContent("Test");
        post.setUser(loggedUser);

        IGenericService<Post> postService = new GenericServiceImpl<>(Post.class, HibernateUtil
                .getSessionFactory());
        postService.save(post);

    }
}
