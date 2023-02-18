package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="automovil")
@Getter
@Setter
public class Automovil  implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="num_placa", nullable=false, length = 8, unique=true)
    private String num_placa;
    @Column(name="modelo", nullable=false, length = 50, unique=false)
    private String modelo;
    @Column(name="estado", nullable=false, length = 20, unique=false)
    private String estado;
    @Column(name="color", nullable=false, length = 25, unique=false)
    private String color;
    @Column(name="anio", nullable=false, length = 4, unique=false)
    private Date anio;
    @Column(name="marca", nullable=false, length = 20, unique=false)
    private String marca;
    @Column(name="tipo_vehiculo", nullable=false, length = 50, unique=false)
    private String tipo_vehiculo;

    //Automovil-daños
    @JsonIgnore
    @OneToMany(mappedBy="automovil")
    private List<RegistrarDanio> danios;
    //Automovil-reserva
    @JsonIgnore
    @OneToMany(mappedBy="automovil")
    private List<Reserva> reserva;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private ClaseAutomovil claseAutomovil;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cod_seguro", referencedColumnName = "cod_seguro")
    private Seguro seguro;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuario usuarios;

}
