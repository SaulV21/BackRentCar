package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="claseautomovil")
@Getter
@Setter

public class ClaseAutomovil implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_clase",length = 8)
    private Integer id_clase;
    @Column(name="nombre", nullable=false, length = 50, unique=false)
    private String nombre;

    @Column(name="precio_alquiler_dia", nullable=false, unique=false)
    private double precio_alquiler_dia;

    @JsonIgnore
    @OneToMany(mappedBy="claseAutomovil")
    private List<Automovil> automovil;

    public ClaseAutomovil() {
    }

    public ClaseAutomovil(@NotBlank String nombreClase, @Min(0)double precioAlquilerDia) {
        this.nombre = nombreClase;
        this.precio_alquiler_dia = precioAlquilerDia;
    }
}
