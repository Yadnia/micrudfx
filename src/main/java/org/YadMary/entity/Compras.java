package org.YadMary.entity;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Entity
@Table (name = "compras")
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Id")
    private int id;

    @Column(name = "Producto")
    private String producto;

    @Column (name = "Proveedor")
    private String proveedor;

    @Column (name = "Monto")
    private double monto;

    @Column (name = "fecha")
    private String fecha;

    public Compras() {

    }
    public Compras(String producto, String proveedor, double monto, String fecha) {
        this.producto = producto;
        this.proveedor = proveedor;
        this.monto = monto;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Compras{" +
                "id=" + id +
                ", producto='" + producto + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", monto=" + monto +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
