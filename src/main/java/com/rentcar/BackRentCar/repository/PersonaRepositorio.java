package com.rentcar.BackRentCar.repository;

import com.rentcar.BackRentCar.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepositorio extends JpaRepository<Persona, Long> {
    @Query(value = "Select * from persona c where c.cedula = :cedula", nativeQuery = true)
    public Persona findByPersona(String cedula);
}
