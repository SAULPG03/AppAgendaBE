package es.ieslosmontecillos.AppAgendaBE.entity;

import jakarta.persistence.*;


import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
    @Id
    @Column(name = "TYPE", length = 50)
    private String type;
    @Basic
    @Column(name = "RPTA", nullable = false)
    private Integer rpta;
    @Basic
    @Column(name = "MESSAGE", nullable = false, length = 200)
    private String message;
    @ManyToOne
    @JoinColumn(name = "LOGIN")
    private Login login;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRpta() {
        return rpta;
    }

    public void setRpta(Integer rpta) {
        this.rpta = rpta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(type, usuario.type) && Objects.equals(rpta, usuario.rpta) && Objects.equals(message, usuario.message) && Objects.equals(login, usuario.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, rpta, message, login);
    }
}

