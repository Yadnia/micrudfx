package org.YadMary.controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.YadMary.App;
import org.YadMary.entity.Producto;
import org.YadMary.entity.Proveedor;
import org.YadMary.entity.User;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import javax.persistence.Table;
import java.io.IOException;


public class InventoryController {
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
    private void switchToHome() throws IOException {
        App.setRoot("Main");
    }
    @FXML
    public void initializeTable() {

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
        productsList.add(producto);
     }
    }

    private ObservableList<Producto> getProductos (){
        IGenericService<Producto> productoService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        return FXCollections.observableArrayList(productoService.findAll());
    }
}
