package es.ieslosmontecillos.AppAgendaBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;
import java.util.Collection;
import java.util.Objects;
@Entity
@Table(name="LOGIN")
public class Login implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "CLAVE", nullable = false, length = 100)
    private String clave;
    @Basic
    @Column(name= "VIGENCIA", nullable = false)
    private Boolean vigencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVigencia() {
        return vigencia;
    }

    public void setVigencia(Boolean vigencia) {
        this.vigencia = vigencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(id, login.id) && Objects.equals(email, login.email) && Objects.equals(clave, login.clave) && Objects.equals(vigencia, login.vigencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, clave, vigencia);
    }

    public Login orElseThrow(Object loginNoEncontrado) {
        return null;
    }
}

