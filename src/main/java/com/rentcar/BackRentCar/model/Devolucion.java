package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="devolucion")
@Getter
@Setter
public class Devolucion  implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="cod_dv",length = 8)
    private Long cod_dv;

    private Date fecha_dv;
    @Column(name="lugar_dv", nullable=false, length = 45, unique=false)
    private String lugar_dv;



    public Devolucion() {
    }

    public Devolucion(Long cod_dv) {
        this.cod_dv = cod_dv;
    }

    public Devolucion(Long cod_dv, Date fecha_dv, String lugar_dv, Persona persona, RegistrarDanio registrarDanio, Alquiler alquiler) {
        this.cod_dv = cod_dv;
        this.fecha_dv = fecha_dv;
        this.lugar_dv = lugar_dv;
        this.persona = persona;
        this.registrarDanio = registrarDanio;
        this.alquiler = alquiler;
    }

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;


   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cod_rgd", referencedColumnName = "cod_rgd")
    private RegistrarDanio registrarDanio;


    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_alquiler", referencedColumnName = "id_alquiler")
    private Alquiler alquiler;


}
