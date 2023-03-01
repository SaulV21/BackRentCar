package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="reserva")
@Getter
@Setter

public class Reserva implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="cod_reserva", nullable=false, length = 8, unique=false)
    private Long cod_reserva;
    @Column(name="horareservarealizad", nullable=false, length = 45, unique=false)
    private Date horareservarealizad;
    private Date fecha_iniresv;
    private Date fecha_finresv;
    @Column(name="forma_pago", nullable=false, length = 20, unique=false)
    private String forma_pago;

    //
    //reserva-automovil
 //   @JsonIgnore


    public Reserva() {
    }

    public Reserva(Long cod_reserva) {
        this.cod_reserva = cod_reserva;
    }

    public Reserva(Long cod_reserva, Date horareservarealizad, Date fecha_iniresv, Date fecha_finresv, String forma_pago, Automovil automovil, Seguro seguro, Alquiler alquileres) {
        this.cod_reserva = cod_reserva;
        this.horareservarealizad = horareservarealizad;
        this.fecha_iniresv = fecha_iniresv;
        this.fecha_finresv = fecha_finresv;
        this.forma_pago = forma_pago;
        this.automovil = automovil;
        this.seguro = seguro;
        this.alquileres = alquileres;
    }

    @ManyToOne
    @JoinColumn(name = "num_placa", referencedColumnName = "num_placa")
    private Automovil automovil;

    //seguro-reserva
   // @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cod_seguro", referencedColumnName = "cod_seguro")
    private Seguro seguro;

  //  @JsonIgnore
    @OneToOne(mappedBy="reserva")
    private Alquiler alquileres;

}
