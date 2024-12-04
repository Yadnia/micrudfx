package org.YadMary.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", length = 40, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column (name = "Nombre")
    private String nombre;

    @Column (name = "Apellido")
    private String apellido;

    @Column (name = "Cedula")
    private String cedula;


    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
