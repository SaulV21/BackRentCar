package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="alquiler")
@Getter
@Setter

public class Alquiler  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_alquiler", length = 8)
    private Long id_alquiler;
    @Column(name="num_dias_alquiler", nullable=false, length = 10, unique=false)
    private String num_dias_alquiler;
    @Column(name="fecha_salida", nullable=false)
    private Date fecha_salida;
    @Column(name="prox_fecha_entrega", nullable=false)
    private Date prox_fecha_entrega;
    @Column(name="documento_garantia", nullable=false, length = 15, unique=false)
    private String documento_garantia;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cod_comp", referencedColumnName = "cod_comp")
    private Comprobante comprobante;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cod_reserva", referencedColumnName = "cod_reserva")
    private Reserva reserva;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuario usuarios;
}
