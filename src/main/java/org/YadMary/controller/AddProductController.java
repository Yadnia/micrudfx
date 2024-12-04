package org.YadMary.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.YadMary.App;
import org.YadMary.entity.Producto;
import org.YadMary.entity.User;
import org.YadMary.service.GenericServiceImpl;
import org.YadMary.service.IGenericService;
import org.YadMary.utils.HibernateUtil;

import java.io.IOException;

public class AddProductController {
    @FXML
    private TextField desctxt;

    @FXML
    private TextField colortxt;

    @FXML
    private TextField catTxt;

    @FXML
    private TextField tallaTxt;
    @FXML
    private TextField stockTxt;

    @FXML
    private TextField precioTxt;
    @FXML
    private TextField proveedorTxt;

    @FXML
    private void switchToAdministration() throws IOException {
        App.setRoot("Administration");
    }
    @FXML
    public void addProduct() throws IOException {
        String desc = desctxt.getText();
        String color = colortxt.getText();
        String cat = catTxt.getText();
        String talla = tallaTxt.getText();
        int stock = Integer.parseInt(stockTxt.getText());
        int precio = Integer.parseInt(precioTxt.getText());
        String proveedor = proveedorTxt.getText();

        Producto producto = new Producto();
        producto.setDescription(desc);
        producto.setColor(color);
        producto.setCate(cat);
        producto.setSize(talla);
        producto.setStock(stock);
        producto.setPrecio(precio);
        producto.setProveedor(proveedor);
        createProduct(producto);

    }

    public void createProduct(Producto producto){
        IGenericService<Producto> usuarioService = new GenericServiceImpl<>(Producto.class, HibernateUtil.getSessionFactory());
        usuarioService.save(producto);
    }

}
