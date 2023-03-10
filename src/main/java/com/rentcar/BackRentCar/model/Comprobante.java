package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="comprobante")
@Getter
@Setter
public class Comprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_comp", length = 8)
    private Long cod_comp;
    @Column(name="descripcion", nullable=false, length = 45, unique=false)
    private String descripcion;
    @Column(name="precio", nullable=false, unique=false)
    private Double precio;

  //  @JsonIgnore
    @OneToOne(mappedBy="comprobante")
    private Alquiler alquiler;

    public Comprobante() {
    }

    public Comprobante(Long cod_comp) {
        this.cod_comp = cod_comp;
    }

    public Comprobante(Long cod_comp, String descripcion, Double precio, Alquiler alquiler) {
        this.cod_comp = cod_comp;
        this.descripcion = descripcion;
        this.precio = precio;
        this.alquiler = alquiler;
    }

    //        @JsonIgnore
//	@OneToOne(mappedBy="comprobante")
//	private RegistrarDanio comprobantes;
}
