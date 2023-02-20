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
    @NotNull
    @Column(name="nombre_Rol")
    private String nombre_Rol;

    @JsonIgnore
    @OneToMany(mappedBy="rol")
    private List<Usuario> usuarios;
}
