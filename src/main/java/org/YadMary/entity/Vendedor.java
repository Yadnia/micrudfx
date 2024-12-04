package org.YadMary.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Vendedor")
public class Vendedor extends User{

    @Column (name = "rol")
    private String rol;

    public Vendedor(String password, String username, String rol) {
        super(password, username);
        this.rol = rol;
    }

    public Vendedor(String password, String username) {
        super(password, username);
    }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "rol='" + rol + '\'' +
                '}';
    }
}