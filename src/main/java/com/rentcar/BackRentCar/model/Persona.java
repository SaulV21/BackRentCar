package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name="persona")
@Getter
@Setter
@Entity
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_persona", nullable=false, length = 8)
    private Integer id_persona;

    @Column(name="nombre", nullable=false, length = 45, unique=false)
    private String nombre;
    @Column(name="apellido", nullable=false, length = 45, unique=false)
    private String apellido ;
    @Column(name="cedula", nullable=false, length = 10, unique=false)
    private String cedula ;
    @Column(name="direccion", nullable=false, length = 100, unique=false)
    private String direccion ;

    @Column(name="telefono", nullable=false, length = 10, unique=false)
    private String telefono;
    @Column(name="correo", nullable=false, length = 45, unique=true)
    private String correo;
    @Column(name="edad", nullable=false, length = 50, unique=false)
    private int edad;
    @Column(name="ciudad", nullable=false, length = 20, unique=false)
    private String ciudad;
    @Column(name="genero", nullable=false, length = 20, unique=false)
    private String genero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuario usuario;

    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Usuario> usuarios;


}
