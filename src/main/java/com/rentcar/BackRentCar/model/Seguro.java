package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="seguro")
@Getter
@Setter
public class Seguro  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_seguro", length =8)
    private Long cod_seguro;
    @Column(name="nom_seguro", nullable=false, length = 50, unique=false)
    private String nom_seguro;
    @Column(name="precio_seguro", nullable=false, unique=false)
    private Double precio_seguro;

    //Reserva-seguro


    public Seguro() {
    }

    public Seguro(Long cod_seguro) {
        this.cod_seguro = cod_seguro;
    }

    public Seguro(Long cod_seguro, String nom_seguro, Double precio_seguro, Automovil automovil) {
        this.cod_seguro = cod_seguro;
        this.nom_seguro = nom_seguro;
        this.precio_seguro = precio_seguro;
        this.automovil = automovil;
    }

    // @JsonIgnore
    @OneToOne(mappedBy="seguro")
    private Automovil automovil;
}


