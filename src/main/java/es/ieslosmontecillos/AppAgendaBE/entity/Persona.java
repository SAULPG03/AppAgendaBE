package es.ieslosmontecillos.AppAgendaBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.type.descriptor.jdbc.SmallIntJdbcType;
import org.hibernate.type.descriptor.jdbc.TinyIntJdbcType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name="PERSONA")
public class Persona implements Serializable {
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Id
    @Column(name="ID",nullable = false)
    private Long id;
    @Basic
    @Column(name = "NOMBRE", nullable = false,length=20)
    private String nombre;
    @Basic
    @Column(name = "APPELLIDOS",nullable = false,length = 40)
    private String apellidos;
    @Basic
    @Column(name ="TELEFONO",length = 15)
    private String telefono;
    @Basic
    @Column(name = "EMAIL",length = 30)
    private String email;
    @Basic
    @Column(name = "PROVINCIA",nullable = false)
    private Integer provincia;
    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;
    @Basic
    @Column(name="NUM_HIJOS")
    private SmallIntJdbcType numHijos;
    @Basic
    @Column(name = "ESTADO_CIVIL",length = 1)
    private String estadoCivil;
    @Basic
    @Column(name="SALARIO")
    private Double salario;
    @Basic
    @Column(name = "JUBILADO")
    private TinyIntJdbcType jubilado;
    @Basic
    @Column(name = "FOTO",length = 30)
    private String foto;



}
