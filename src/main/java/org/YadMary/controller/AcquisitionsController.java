package org.YadMary.controller;

import com.google.errorprone.annotations.FormatMethod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import org.YadMary.App;
import org.YadMary.entity.Cliente;
import org.YadMary.entity.Producto;
import org.YadMary.entity.Proveedor;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class AcquisitionsController {

    @FXML
    ChoiceBox <String> prodChoice;

    @FXML
    ChoiceBox <String> provChoice;
    @FXML
    ChoiceBox <String> dateChoice;

    @FXML
    ChoiceBox <Integer> quantityChoice;

    ObservableList<Proveedor> provList = FXCollections.observableArrayList();
    ObservableList<Proveedor> proveedores;
    ObservableList<Producto> productos = FXCollections.observableArrayList();

    @FXML
    private void switchToHome() throws IOException {
        App.setRoot("Main");
    }

    @FXML
    public void initialize() {
        proveedores= getProveedores();
        productos = getProductos();
        for (Proveedor proveedor : proveedores) {
            String nombre=proveedor.getProvName();
            provChoice.getItems().add(nombre);
        }
        for (Producto producto : productos) {
            String desc= producto.getDescription();
            prodChoice.getItems().add(desc);
        }
        for (int i = 0; i<100; i++){
            quantityChoice.getItems().add(i);
        }

    }

    private ObservableList<Producto> getProductos (){
        IGenericService<Producto> productoService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(productoService.findAll());
    }
    private ObservableList<Proveedor> getProveedores (){
        IGenericService<Proveedor> provService = new GenericServiceImpl<>(Proveedor.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(provService.findAll());
    }

}
