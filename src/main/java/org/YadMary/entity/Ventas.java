package org.YadMary.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "cliente")
    private String cliente;


    @Column(name = "productod")
    private String producto;

    @Column(name = "monto")
    private int monto;

    @Column(name = "vendedor")
    private String vendedor;

    @Column(name = "fecha")
    private String fecha;

    // Default constructor
    public Ventas() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Ventas(String cliente, String productoIds, int monto, String vendedor, String fecha) {
        this.cliente = cliente;
        this.producto = productoIds;
        this.monto = monto;
        this.vendedor = vendedor;
        this.fecha = fecha;
    }
// Parameterized constructor
}
