package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private Long id_rol;
    //Anotamos el tipo de dato del rol String

    @Column(name="nombre_rol")
    private String nombre_rol;

    public Rol() {
    }

    public Rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public Rol(Long id_rol, String nombre_rol) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
    }

  /*  @JsonIgnore
    @OneToMany(mappedBy="rol")
    private List<Usuario> usuarios;*/



    public Long getId_rol() {
        return id_rol;
    }

    public String getNombre_Rol() {
        return nombre_rol;
    }

   /* public List<Usuario> getUsuarios() {
        return usuarios;
    }*/

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public void setNombre_Rol(String nombre_Rol) {
        this.nombre_rol = nombre_Rol;
    }

   /* public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }*/



}
