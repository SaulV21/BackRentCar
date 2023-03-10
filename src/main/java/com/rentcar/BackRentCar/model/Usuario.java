package com.rentcar.BackRentCar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String nombreUsuario;
    @NotNull
    private String password;

    /*@JsonIgnore
    @OneToMany(mappedBy="usuarios")
    private List<Automovil> automovil;*/
   // @JsonIgnore


    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;
  //  @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;

   /* @JsonIgnore
    @OneToMany(mappedBy="usuarios")
    private List<Alquiler> alquiler;*/

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String password, Persona persona, Rol rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.persona = persona;
        this.rol = rol;
    }
}


