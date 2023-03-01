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
    private Long cod_rgd;
    @Column(name="descripcion", nullable=false, length = 100, unique=false)
    private String descripcion;
    @Column(name="precio", nullable=false, unique=false)
    private Double precio;
    //daños-automovil


    public RegistrarDanio() {
    }

    public RegistrarDanio(Long cod_rgd) {
        this.cod_rgd = cod_rgd;
    }

    public RegistrarDanio(Long cod_rgd, String descripcion, Double precio) {
        this.cod_rgd = cod_rgd;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "num_placa", referencedColumnName = "num_placa")
    private Automovil automovil;

   /* @JsonIgnore
    @OneToMany(mappedBy="registrarDanio")
    private List<Devolucion> devolucion;*/

}
