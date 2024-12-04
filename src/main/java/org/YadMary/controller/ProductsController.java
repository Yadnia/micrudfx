package org.YadMary.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.YadMary.App;
import org.YadMary.entity.Producto;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class ProductsController {

    @FXML
    TableView<Producto> productosTable;

    @FXML
    TableColumn<Producto, String> desc;

    @FXML
    TableColumn<Producto, String> color;
    @FXML
    TableColumn<Producto, String> precio;
    @FXML
    TableColumn<Producto, String> prov;
    @FXML
    TableColumn<Producto, String> stock;

    private final ObservableList<Producto> productsList = FXCollections.observableArrayList();
    ObservableList<Producto> productos;
    @FXML
    private void switchToAdministration() throws IOException {
        App.setRoot("Main");
    }
    @FXML
    private void switchToAdmins() throws IOException {
        App.setRoot("Admins");
    } @FXML
    private void switchToSellers() throws IOException {
        App.setRoot("Sellers");
    } @FXML
    private void switchToClients() throws IOException {
        App.setRoot("Clients");
    }
    @FXML
    private void switchToInventory() throws IOException {
        App.setRoot("products");
    }
    @FXML
    private void switchToProvs() throws IOException {
        App.setRoot("provs");
    }
    @FXML
    private void switchToAdd() throws IOException {
        App.setRoot("addProducts");
    }

    @FXML
    public void initializeTable() {
            addProduct();
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        desc.setCellValueFactory(new PropertyValueFactory<Producto, String>("desc"));
        color.setCellValueFactory(new PropertyValueFactory<Producto, String>("color"));
        precio.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));
        prov.setCellValueFactory(new PropertyValueFactory<Producto, String>("prov"));
        stock.setCellValueFactory(new PropertyValueFactory<Producto, String>("stock"));
        addProduct();
        productosTable.setItems(productsList);
    }

    public void addProduct() {
        productos=getProductos();
        for (Producto producto:productos) {
           Producto newProd = new Producto();
           String desc = newProd.getDescription();
           String color = newProd.getColor();
           int precio = newProd.getPrecio();
           String prov = newProd.getProveedor();
           int stock = newProd.getStock();


            productsList.add(newProd);
        }
    }

    private ObservableList<Producto> getProductos (){
        IGenericService<Producto> productoService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(productoService.findAll());
    }
}

