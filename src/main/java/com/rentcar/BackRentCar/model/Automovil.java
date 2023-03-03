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


    private static final long serialVersionUID = -1469285467119600917L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idauto",  unique=true)
    private Long idauto;

    @Column(name="num_placa", length = 8, unique=true)
    private String num_placa;
    @Column(name="modelo",  length = 50)
    private String modelo;
    @Column(name="estado",  length = 20)
    private String estado;
    @Column(name="color",  length = 25)
    private String color;
    @Column(name="anio", length = 5)
    private String anio;
    @Column(name="marca", length = 20)
    private String marca;
    @Column(name="tipo_vehiculo", length = 50)
    private String tipo_vehiculo;

    private String foto;

    @ManyToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private ClaseAutomovil claseAutomovil;

    //@JsonIgnore
    @OneToOne
    @JoinColumn(name = "cod_seguro", referencedColumnName = "cod_seguro")
    private Seguro seguro;

   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuario usuarios;


    public Automovil() {
    }

    public Automovil(Long idauto) {
        super();
        this.idauto = idauto;
    }

    public Automovil(Long idauto, String num_placa, String modelo, String estado, String color, String anio, String marca, String tipo_vehiculo, ClaseAutomovil claseAutomovil, Seguro seguro, Usuario usuarios) {
        this.idauto = idauto;
        this.num_placa = num_placa;
        this.modelo = modelo;
        this.estado = estado;
        this.color = color;
        this.anio = anio;
        this.marca = marca;
        this.tipo_vehiculo = tipo_vehiculo;
        this.claseAutomovil = claseAutomovil;
        this.seguro = seguro;
        this.usuarios = usuarios;


    }

    public Automovil(Long idauto, String num_placa, String modelo, String estado, String color, String anio, String marca, String tipo_vehiculo, String foto, ClaseAutomovil claseAutomovil, Seguro seguro, Usuario usuarios) {
        this.idauto = idauto;
        this.num_placa = num_placa;
        this.modelo = modelo;
        this.estado = estado;
        this.color = color;
        this.anio = anio;
        this.marca = marca;
        this.tipo_vehiculo = tipo_vehiculo;
        this.foto = foto;
        this.claseAutomovil = claseAutomovil;
        this.seguro = seguro;
        this.usuarios = usuarios;
    }
}
