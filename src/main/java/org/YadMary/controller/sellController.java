package org.YadMary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.YadMary.App;
import org.YadMary.entity.*;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class sellController {

    @FXML
    private ChoiceBox<String> productChoice;

    @FXML
    private ChoiceBox<String> sellerChoice;
    @FXML
    private TextArea productsField;
    @FXML
    private Label total;

    @FXML
    private ChoiceBox<String> clientChoice;
    ObservableList<Proveedor> proveedores;
    ObservableList<Producto> productos = FXCollections.observableArrayList();
    ObservableList<Cliente> clientes;
    ObservableList<User> users;
    int monto;


    @FXML
    public void initialize() {
        proveedores= getProveedores();
        productos = getProductos();
        clientes = getClientes();
        users = getUsuarios();

        for (User user : users) {
            String nombre=user.getNombre();
            sellerChoice.getItems().add(nombre);
        }
        for (Producto producto : productos) {
            String desc= producto.getDescription();
            productChoice.getItems().add(desc);
        }
        for (Cliente cliente : clientes) {
            String nombre = cliente.getNames();
            clientChoice.getItems().add(nombre);
        }
    }

    @FXML
    private void switchToHome() throws IOException, IOException {
        App.setRoot("Main");
    }

    @FXML
    private void addToCart(){
    productChoice.setItems(productChoice.getItems());
    for (Producto producto : productos) {
        if (productChoice.getValue().equals(producto.getDescription())) {
            monto = producto.getPrecio();
        }
    }
    }
    @FXML
    private void CalculateTotal(){
        total.setText(String.valueOf(monto));
    }

    @FXML
    private void applyDiscount(){
    double desc = monto * 0.2;
    monto = (int) (monto - desc);
    total.setText(String.valueOf(monto));
    }
    @FXML
    private void AddSell(){
       Ventas ventas  = new Ventas();
       ventas.setCliente(clientChoice.getValue());
       ventas.setProducto(productChoice.getValue());
       ventas.setMonto(monto);
        LocalDate localDate = LocalDate.now();
        String fecha = localDate.toString();
       ventas.setFecha(fecha);
        createSell(ventas);
    }
    private ObservableList<Producto> getProductos (){
        IGenericService<Producto> productoService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(productoService.findAll());
    }
    private ObservableList<Proveedor> getProveedores (){
        IGenericService<Proveedor> provService = new GenericServiceImpl<>(Proveedor.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(provService.findAll());
    }
    private ObservableList<Cliente> getClientes (){
        IGenericService<Cliente> provService = new GenericServiceImpl<>(Cliente.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(provService.findAll());
    }
    private ObservableList<User> getUsuarios (){
        IGenericService<User> usuarioService = new GenericServiceImpl<>(User.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(usuarioService.findAll());
    }
    public void createSell(Ventas venta){
        IGenericService<Ventas> venya = new GenericServiceImpl<>(Ventas.class, HibernateUtil.getSessionFactory());
        venya.save(venta);
    }


}
