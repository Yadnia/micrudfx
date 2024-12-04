package org.YadMary.entity;

import javax.persistence.*;

@Entity
@Table (name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "provId")
    Long id;

    @Column (name = "Nombre")
    String provName;

    @Column (name = "Apellido")
    String provApell;

    @Column (name = "Telefono")
    String provTelef;

    public Proveedor() {
    }

    public Proveedor(String provName, String provApell, String provTelef) {
        this.provName = provName;
        this.provApell = provApell;
        this.provTelef = provTelef;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getProvApell() {
        return provApell;
    }

    public void setProvApell(String provApell) {
        this.provApell = provApell;
    }

    public String getProvTelef() {
        return provTelef;
    }

    public void setProvTelef(String provTelef) {
        this.provTelef = provTelef;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", provName='" + provName + '\'' +
                ", provApell='" + provApell + '\'' +
                ", provTelef='" + provTelef + '\'' +
                '}';
    }
}
