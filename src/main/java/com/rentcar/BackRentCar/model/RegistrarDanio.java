package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="registrarDanio")
@Getter
@Setter
public class RegistrarDanio {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_rgd",  length = 8)
    private Integer cod_rgd;
    @Column(name="descripcion", nullable=false, length = 100, unique=false)
    private String descripcion;
    @Column(name="precio", nullable=false, unique=false)
    private Double precio;
    //daños-automovil

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "num_placa", referencedColumnName = "num_placa")
    private Automovil automovil;

    @JsonIgnore
    @OneToMany(mappedBy="registrarDanio")
    private List<Devolucion> devolucion;

}
